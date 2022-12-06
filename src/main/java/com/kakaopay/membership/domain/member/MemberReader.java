package com.kakaopay.membership.domain.member;

import com.kakaopay.membership.exception.NoSuchBarcodeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class MemberReader {

    private final MemberRepository memberRepository;
    private final MemberWriter memberWriter;

    @Transactional(readOnly = true)
    public Member read(Long memberId) {
        if (memberId > 999999999L || memberId < 100000000L) {
            throw new IllegalArgumentException("잘못된 형식의 아이디입니다.");
        }
         return memberRepository.findById(memberId)
                .orElseGet(() -> memberWriter.write(memberId));
    }

    @Transactional(readOnly = true)
    public Member read(String barcode) {
        if (barcode.length() != 10 || barcode.startsWith("0")) {
            throw new IllegalArgumentException("잘못된 형식의 바코드입니다.");
        }
        return memberRepository.findByBarcode(barcode)
                .orElseThrow(NoSuchBarcodeException::new);
    }

    @Transactional(readOnly = true)
    public boolean existsByBarcode(String barcode) {
        return memberRepository.existsByBarcode(barcode);
    }
}
