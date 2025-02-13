package com.example.MAShop.execeptions.handle;

import com.example.MAShop.execeptions.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleBusinessException(Exception ex, WebRequest request) {
        ExceptionModel exceptionModel = ExceptionModel.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build();

        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionModel exceptionModel = ExceptionModel.builder().message(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

        return new ResponseEntity<>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public final ResponseEntity<Object> handleNotfoundExceptions(Exception ex, WebRequest request) {
        ExceptionModel exceptionModel = ExceptionModel.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()).build();

        return new ResponseEntity<>(exceptionModel, HttpStatus.NOT_FOUND);
    }
}
