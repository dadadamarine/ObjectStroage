package com.storage.exception;

public class ImageNotFoundException extends RuntimeException {

    public ImageNotFoundException() {
        super();
    }

    public ImageNotFoundException(String message) {
        super(message);
    }
}
