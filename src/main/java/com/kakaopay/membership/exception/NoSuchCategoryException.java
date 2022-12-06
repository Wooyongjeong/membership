package com.kakaopay.membership.exception;

public class NoSuchCategoryException extends RuntimeException {
    public NoSuchCategoryException() {
        super("등록되지 않은 카테고리입니다.");
    }
}
