package com.storage.exception;

public class CannotSaveException extends RuntimeException {

    public CannotSaveException() {
        super();
    }

    public CannotSaveException(String message) {
        super(message);
    }

}
