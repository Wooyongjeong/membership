package com.kakaopay.membership.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    A("식품"),
    B("화장품"),
    C("식당");

    private final String name;
}
