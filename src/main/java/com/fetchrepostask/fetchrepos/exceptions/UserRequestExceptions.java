package com.fetchrepostask.fetchrepos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserRequestExceptions extends RuntimeException{
    public UserRequestExceptions(String message) {
        super(message);
    }

    public UserRequestExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
