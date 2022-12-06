package com.kakaopay.membership.domain.history.dto;

import com.kakaopay.membership.domain.history.HistoryType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class HistoryDto {

    private String approvedAt;

    private String type;

    private String category;

    private String partnerName;

    @QueryProjection
    public HistoryDto(LocalDateTime approvedAt, HistoryType type, String category, String partnerName) {
        this.approvedAt = approvedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.type = type.getName();
        this.category = category;
        this.partnerName = partnerName;
    }
}
