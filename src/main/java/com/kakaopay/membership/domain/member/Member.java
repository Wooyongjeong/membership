package com.kakaopay.membership.domain.member;

import com.kakaopay.membership.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseTimeEntity {

    @Id
    private Long memberId;

    @Column(length = 10, nullable = false, unique = true)
    private String barcode;

    @Builder
    private Member(Long memberId, String barcode) {
        this.memberId = memberId;
        this.barcode = barcode;
    }

    public static Member create(Long memberId) {
        return Member.builder()
                .memberId(memberId)
                .barcode(makeBarcode(memberId))
                .build();
    }

    private static String makeBarcode(Long memberId) {
        String barcode = String.valueOf(memberId);

        int a = barcode.charAt(0) - '0';
        int b = barcode.charAt(5) - '0';

        return barcode + (a + b) % 10;
    }
}
