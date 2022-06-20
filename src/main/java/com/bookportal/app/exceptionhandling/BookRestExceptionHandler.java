package com.bookportal.app.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookRestExceptionHandler {
    // add an exception handler for CustomerNotFound Exception
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exc){
        // create CustomerErrorResponse
        BookErrorResponse error=new BookErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    //    Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception exc){
        // create CustomerErrorResponse
        BookErrorResponse error=new BookErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
