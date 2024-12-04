package com.planbtech.prostudy.component.Exception.ClassException.UserException;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
