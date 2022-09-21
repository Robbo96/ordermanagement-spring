package com.example.springjparest.error;

public class EntitiyNotFoundException extends Exception{
    public EntitiyNotFoundException() {
        super();
    }

    public EntitiyNotFoundException(String message) {
        super(message);
    }

    public EntitiyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntitiyNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EntitiyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
