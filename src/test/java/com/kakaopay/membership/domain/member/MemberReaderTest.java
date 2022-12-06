package com.kakaopay.membership.domain.member;

import com.kakaopay.membership.exception.NoSuchBarcodeException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberReaderTest {

    @Mock
    MemberRepository memberRepository;
    @Mock
    MemberWriter memberWriter;
    @InjectMocks
    MemberReader memberReader;

    @BeforeEach
    void setUp(TestInfo info) {
        if (info.getTags().contains("skipSetUp")) {
            return;
        }

        Long memberId = 123456789L;
        Member member = Member.create(memberId);
        Optional<Member> optionalMember = Optional.of(member);

        lenient().when(memberRepository.findById(memberId)).thenReturn(optionalMember);
    }

    @Test
    void readMemberWrongMemberId() {
        Long[] memberIds = {12345678L, 1000000000L, 99999999L};

        for (Long memberId : memberIds) {
            assertThatThrownBy(() -> memberReader.read(memberId))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 형식의 아이디입니다.");
        }
    }

    @Test
    void readMemberId() {
        //given
        Long memberId = 123456789L;

        //when
        Member readMember = memberReader.read(memberId);

        //then
        assertThat(readMember.getMemberId()).isEqualTo(123456789L);
        then(memberRepository).should(times(1)).findById(memberId);
        then(memberRepository).shouldHaveNoMoreInteractions();
    }

    @Tag(value = "skipSetUp")
    @Test
    void readMemberIdNewMember() {
        //given
        Long memberId = 987654321L;
        Member member = Member.create(memberId);
        given(memberWriter.write(memberId)).willReturn(member);

        //when
        Member readMember = memberReader.read(memberId);

        //then
        assertThat(readMember.getBarcode()).isEqualTo("9876543213");
        then(memberWriter).should(times(1)).write(memberId);
        then(memberWriter).shouldHaveNoMoreInteractions();
    }

    @Test
    void readBarcodeWithWrongBarcode() {
        String[] barcodes = {"123456789", "10000000000", "0000000000"};

        for (String barcode : barcodes) {
            assertThatThrownBy(() -> memberReader.read(barcode))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 형식의 바코드입니다.");
        }
    }

    @Test
    void readBarcodeExistingMember() {
        //given
        Optional<Member> optionalMember = memberRepository.findById(123456789L);

        String barcode = "1234567897";
        given(memberRepository.findByBarcode(barcode)).willReturn(optionalMember);

        //when
        Member member = memberReader.read(barcode);

        //then
        assertThat(member.getBarcode()).isEqualTo(barcode);
        then(memberRepository).should(times(1)).findByBarcode(barcode);
    }

    @Tag(value = "skipSetUp")
    @Test
    void readBarcodeNonExistingMember() {
        String barcode = "9876543213";

        assertThatThrownBy(() -> memberReader.read(barcode))
                .isInstanceOf(NoSuchBarcodeException.class)
                .hasMessage("등록되지 않은 바코드입니다.");
    }
}