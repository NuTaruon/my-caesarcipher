package org.example.caesar.exception;

public class CaesarException extends RuntimeException{

    public CaesarException(String message) {
        super(message);
    }

    public CaesarException(String message, Throwable cause) {
        super(message, cause);
    }
}
