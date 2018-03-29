package com.may.the.fourth.be.with.you.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime dateTim;
    private String message;
    private String details;

     public ExceptionResponse(LocalDateTime dateTim, String message, String details) {
        this.dateTim = dateTim;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse() {

    }

    public LocalDateTime getDateTim() {
        return dateTim;
    }

    public void setDateTim(LocalDateTime dateTim) {
        this.dateTim = dateTim;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
