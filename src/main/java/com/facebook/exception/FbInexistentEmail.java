package com.facebook.exception;

public class FbInexistentEmail extends FbBusinessException{
    public FbInexistentEmail() {
    }

    public FbInexistentEmail(String message, Throwable cause) {
        super(message, cause);
    }
}
