package com.fetchrepostask.fetchrepos.exceptions.headerexception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class HeaderException {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timesStamp;

    public HeaderException(String message, HttpStatus httpStatus, ZonedDateTime timesStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timesStamp = timesStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimesStamp() {
        return timesStamp;
    }
}
