package com.mikipmax.excepciones;

import java.time.LocalDateTime;

public record ErrorPersonalizadoRecord(LocalDateTime fecha,
                                       String mensaje,
                                       String detalle) {

}
