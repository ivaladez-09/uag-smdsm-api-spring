package com.smdsm.uagsmdsmapispring.exception;

import com.smdsm.uagsmdsmapispring.dto.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );
        log.error("Current resource " + exception.getResourceName() +
                " was not found for " + exception.getFieldName() +
                " " + exception.getFieldValue());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(
            Exception exception,
            WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );
        log.error("Internal Server Error in " + errorDetails.getDetails() +
                " due to: " + errorDetails.getMessage());
        return new ResponseEntity<>(
                errorDetails,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            WebRequest webRequest) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder errorsStringBuilder = new StringBuilder();
        errorsStringBuilder.append("\n");
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errorsStringBuilder
                    .append(fieldName)
                    .append(" : ")
                    .append(message)
                    .append("\n");
            errors.put(fieldName, message);
        });
        log.error(errorsStringBuilder.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
