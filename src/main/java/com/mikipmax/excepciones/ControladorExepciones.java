package com.mikipmax.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControladorExepciones extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPersonalizadoRecord> manejadorEntidadNoEncontrada(Exception exception, WebRequest webRequest) {
        ErrorPersonalizadoRecord error = new ErrorPersonalizadoRecord(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntidadNoEncontradoExcepcion.class)
    public ResponseEntity<ErrorPersonalizadoRecord> manejadorEntidadNoEncontrada(EntidadNoEncontradoExcepcion entidadNoEncontradoExcepcion, WebRequest webRequest) {
        ErrorPersonalizadoRecord error = new ErrorPersonalizadoRecord(LocalDateTime.now(), entidadNoEncontradoExcepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String mensaje = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getField().concat(":").concat(Objects.requireNonNull(x.getDefaultMessage())))
                .collect(Collectors.joining(","));
        ErrorPersonalizadoRecord error = new ErrorPersonalizadoRecord(LocalDateTime.now(), mensaje, request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
