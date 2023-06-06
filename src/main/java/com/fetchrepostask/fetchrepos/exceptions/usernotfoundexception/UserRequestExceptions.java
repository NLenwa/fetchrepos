package com.fetchrepostask.fetchrepos.exceptions.usernotfoundexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserRequestExceptions extends RuntimeException{
    public UserRequestExceptions(String message) {
        super(message);
    }

}
