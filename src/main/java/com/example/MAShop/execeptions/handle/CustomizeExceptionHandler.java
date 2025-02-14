package com.example.MAShop.execeptions.handle;

import com.example.MAShop.execeptions.BusinessException;
import com.example.MAShop.execeptions.ExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<Object> handleBusinessException(Exception ex, WebRequest request) {
        ExceptionModel exceptionModel = ExceptionModel.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build();

        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionModel exceptionModel = ExceptionModel.builder().message(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

        return new ResponseEntity<>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionModel exceptionModel = ExceptionModel
                .builder()
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }
}
