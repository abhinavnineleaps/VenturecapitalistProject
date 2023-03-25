package com.platform.VentureCapitalist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MismatchTypeorBlankException.class)
    public ResponseEntity<ErrorResponse> exceptionEmailHandler(Exception e)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorCode((HttpStatus.NOT_FOUND.value()));
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
