package com.kakaopay.membership.exception;

public class NotEnoughPointException extends RuntimeException {
    public NotEnoughPointException() {
        super("포인트 부족으로 사용할 수 없습니다.");
    }
}
