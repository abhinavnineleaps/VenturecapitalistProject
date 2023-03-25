package com.platform.VentureCapitalist.exceptions;

public class MismatchTypeorBlankException extends Exception {
    private String errorMessage;

    public MismatchTypeorBlankException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public MismatchTypeorBlankException() {
    }
}
