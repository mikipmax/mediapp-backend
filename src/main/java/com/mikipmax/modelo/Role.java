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
@Table(name = "role")
public class Role {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_role")
    private Integer idRole;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;

}
