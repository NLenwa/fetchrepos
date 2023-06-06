package com.fetchrepostask.fetchrepos.exceptions.headerexception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class HeaderExceptions extends RuntimeException{

    public HeaderExceptions(String message) {
        super(message);
    }
}
