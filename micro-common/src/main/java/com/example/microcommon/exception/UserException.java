package com.example.microcommon.exception;

/**
 * @Author wen.yang
 */
public class UserException extends RuntimeException {

    String message;

    public UserException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
