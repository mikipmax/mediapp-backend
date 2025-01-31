package com.mikipmax.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "usuario")
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "clave_usuario", nullable = false)
    private String claveUsuario;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

}
