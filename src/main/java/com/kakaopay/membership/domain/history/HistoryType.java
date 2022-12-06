package com.kakaopay.membership.domain.history;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HistoryType {
    EARN("earn"),
    USE("use");

    private final String name;
}
