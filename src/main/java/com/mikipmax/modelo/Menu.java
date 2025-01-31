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
@Table(name = "menu")
public class Menu {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_menu")
    private Integer idMenu;

    @Column(nullable = false, name = "icono")
    private String icono;

    @Column(nullable = false, name = "nombre")
    private String nombre;
    
    @Column(nullable = false, name = "url")
    private String url;

}
