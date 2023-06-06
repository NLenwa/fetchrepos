package com.fetchrepostask.fetchrepos.exceptions.usernotfoundexception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class UserRequestException {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timesStamp;

    public UserRequestException(String message,
                                HttpStatus httpStatus,
                                ZonedDateTime timesStamp) {
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
