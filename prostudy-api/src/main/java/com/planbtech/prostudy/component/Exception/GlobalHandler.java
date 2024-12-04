package com.planbtech.prostudy.component.Exception;

import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserCreateError;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> UserNotFound(UserNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserCreateError.class)
    public ResponseEntity<String> UserAlreadyExists(UserCreateError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
