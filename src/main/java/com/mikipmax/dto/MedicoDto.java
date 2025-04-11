package com.mikipmax.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDto extends EntidadBaseDto{
    
    private String nombre;

    private String apellido;

    private String cmp;

    //Se cambia a otro nombre solo para ejercicio de model mapper
    private String pathFoto;
}
