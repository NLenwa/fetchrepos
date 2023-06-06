package com.fetchrepostask.fetchrepos.exceptions.usernotfoundexception;

import com.fetchrepostask.fetchrepos.exceptions.usernotfoundexception.UserRequestException;
import com.fetchrepostask.fetchrepos.exceptions.usernotfoundexception.UserRequestExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserRequestExceptionHandler {

    @ExceptionHandler(value = {UserRequestExceptions.class})
    public ResponseEntity<Object> handleRequestException(UserRequestExceptions e) {

        UserRequestException userRequestException = new UserRequestException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Europe/Warsaw"))
        );

        return new ResponseEntity<>(userRequestException, HttpStatus.NOT_FOUND);
    }

}
