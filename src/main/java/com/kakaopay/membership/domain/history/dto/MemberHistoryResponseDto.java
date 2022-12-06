package com.kakaopay.membership.domain.history.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class MemberHistoryResponseDto {

    private List<HistoryDto> history;

    @Builder
    public MemberHistoryResponseDto(List<HistoryDto> history) {
        this.history = history;
    }
}
