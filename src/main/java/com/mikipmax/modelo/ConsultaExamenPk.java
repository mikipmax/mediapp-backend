package com.mikipmax.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ConsultaExamenPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;
    
    @ManyToOne
    @JoinColumn(name = "id_examen")
    private Examen examen;

}
