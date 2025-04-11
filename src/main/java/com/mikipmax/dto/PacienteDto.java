package com.mikipmax.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDto extends EntidadBaseDto {

    private String nombre;

    private String apellido;

    private String identificacion;

    private String correo;

    private String telefono;

    private String direccion;
}
