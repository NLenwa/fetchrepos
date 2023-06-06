package com.fetchrepostask.fetchrepos.exceptions.headerexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class HeaderExceptionHandler {

    public ResponseEntity<Object> handleHeaderException(HeaderExceptions e) {
        HeaderException headerException = new HeaderException(
                e.getMessage(),
                HttpStatus.NOT_ACCEPTABLE,
                ZonedDateTime.now(ZoneId.of("Europe/Warsaw"))
        );
        return new ResponseEntity<>(headerException, HttpStatus.NOT_ACCEPTABLE);
    }
}
