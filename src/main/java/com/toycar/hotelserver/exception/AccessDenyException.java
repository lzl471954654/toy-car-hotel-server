package com.toycar.hotelserver.exception;

public class AccessDenyException extends RuntimeException {

    public AccessDenyException(String message) {
        super(message);
    }
}
