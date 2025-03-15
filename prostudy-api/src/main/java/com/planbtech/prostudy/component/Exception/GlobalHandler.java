package com.planbtech.prostudy.component.Exception;

import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.CategoryCreateError;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.CategoryDeleteException;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.CategoryNotFound;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.LoadCategoryException;
import com.planbtech.prostudy.component.Exception.ClassException.ProjectException.ProjectNotFound;
import com.planbtech.prostudy.component.Exception.ClassException.SecurityException.RoleNotFound;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserAddProjectError;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserCreateError;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserNotFound;
import com.planbtech.prostudy.component.Exception.ClassException.VideoException.VideoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity<ResponseRestException> UserNotFound(UserNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseRestException(HttpStatus.NOT_FOUND,ex.getMessage()));
    }

    @ExceptionHandler(UserCreateError.class)
    private ResponseEntity<ResponseRestException> UserAlreadyExists(UserCreateError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseRestException(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(CategoryCreateError.class)
    private ResponseEntity<ResponseRestException> CategoryAlreadyExists(CategoryCreateError ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseRestException(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(CategoryNotFound.class)
    private ResponseEntity<ResponseRestException> CategoryNotFound(CategoryNotFound ex){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseRestException(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(CategoryDeleteException.class)
    private ResponseEntity<ResponseRestException> CategoryDeleteError(CategoryDeleteException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseRestException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(LoadCategoryException.class)
    private ResponseEntity<ResponseRestException> CategoryLoadError(LoadCategoryException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseRestException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(ProjectNotFound.class)
    private ResponseEntity<ResponseRestException> ProjectNotFound(ProjectNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseRestException(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(RoleNotFound.class)
    private ResponseEntity<ResponseRestException> RoleNotFound(RoleNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseRestException(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(UserAddProjectError.class)
    private ResponseEntity<ResponseRestException> UserProjectError(UserCreateError ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseRestException(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(VideoNotFound.class)
    private ResponseEntity<ResponseRestException> VideoNotFound(VideoNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseRestException(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(MailException.class)
    private ResponseEntity<ResponseRestException> MailException(MailException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseRestException(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
