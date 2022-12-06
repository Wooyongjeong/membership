package com.kakaopay.membership.domain.history.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistorySearchCondition {

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String barcode;

}
