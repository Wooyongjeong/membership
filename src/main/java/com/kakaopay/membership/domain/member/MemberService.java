package com.kakaopay.membership.domain.member;

import com.kakaopay.membership.domain.member.dto.MemberBarcodeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberReader memberReader;

    public MemberBarcodeResponseDto getMemberBarcode(Long memberId) {
        Member member = memberReader.read(memberId);
        return MemberBarcodeResponseDto.fromEntity(member);
    }

}
