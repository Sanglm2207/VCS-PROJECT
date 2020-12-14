package com.itsol.bankapi.exception;

import org.springframework.http.HttpStatus;

/**
 * @author SangLM
 * @Created 11/12/2020 - 11:14 AM
 * @Project spring-boot-security-jwt
 **/
public class BankapiException extends RuntimeException{
    private static final long serialVersionUID = -6593330219878485669L;

    private final HttpStatus status;
    private final String message;

    public BankapiException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public BankapiException(HttpStatus status, String message, Throwable exception) {
        super(exception);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
