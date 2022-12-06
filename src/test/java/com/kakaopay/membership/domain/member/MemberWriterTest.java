package com.kakaopay.membership.domain.member;

import com.kakaopay.membership.exception.NoSuchBarcodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class MemberWriterTest {

    @Mock
    MemberRepository memberRepository;
    @InjectMocks
    MemberWriter memberWriter;

    @BeforeEach
    void setUp() {
    }

    @Test
    void write() {
        //given

        //when

        //then
    }

}