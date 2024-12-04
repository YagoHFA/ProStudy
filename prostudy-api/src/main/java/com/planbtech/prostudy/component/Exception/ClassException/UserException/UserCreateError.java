package com.planbtech.prostudy.component.Exception.ClassException.UserException;

public class UserCreateError extends RuntimeException {
    public UserCreateError(){super("User Create Error");}
    public UserCreateError(String message) {
        super(message);
    }
}
