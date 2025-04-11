package com.mikipmax.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadNoEncontradoExcepcion extends RuntimeException {
    public EntidadNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
