package com.kakaopay.membership.domain.point.dto;

import com.kakaopay.membership.domain.common.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PointResponseDto {

    private String barcode;

    private Category category;

    private Integer points;

}
