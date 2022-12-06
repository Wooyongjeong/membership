package com.kakaopay.membership.domain.member.dto;

import com.kakaopay.membership.domain.member.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberBarcodeResponseDto {

    private Long memberId;

    private String barcode;

    @Builder
    private MemberBarcodeResponseDto(Long memberId, String barcode) {
        this.memberId = memberId;
        this.barcode = barcode;
    }

    public static MemberBarcodeResponseDto fromEntity(Member member) {
        return MemberBarcodeResponseDto.builder()
                .memberId(member.getMemberId())
                .barcode(member.getBarcode())
                .build();
    }

}
