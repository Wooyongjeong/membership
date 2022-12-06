package com.kakaopay.membership.domain.point.dto;

import lombok.Data;

@Data
public class PointRequestDto {

    private Long storeId;

    private String barcode;

    private Integer amount;

}
