package com.kakaopay.membership.exception;

public class NoSuchBarcodeException extends RuntimeException {
    public NoSuchBarcodeException() {
        super("등록되지 않은 바코드입니다.");
    }

    public NoSuchBarcodeException(String message) {
        super(message);
    }
}
