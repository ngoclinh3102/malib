package logixtek.moitech.malib.controllers;

import logixtek.moitech.malib.models.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleBindException(BindException bindException) {
        HashMap<String, String> mapError = new HashMap<>();

        bindException.getBindingResult()
                     .getFieldErrors()
                     .forEach(e -> mapError.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new ResponseMessage(Timestamp.from(new Date().toInstant()).toString(),
                                                       HttpStatus.BAD_REQUEST,
                                                       bindException.getBindingResult().getObjectName(),
                                                       "bugs nè, fix đi",
                                                       mapError));
    }
}
