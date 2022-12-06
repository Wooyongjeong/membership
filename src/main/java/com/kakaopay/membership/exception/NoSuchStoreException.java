package com.kakaopay.membership.exception;

public class NoSuchStoreException extends RuntimeException {
    public NoSuchStoreException() {
        super("등록되지 않은 상점입니다.");
    }
}
