package com.mikipmax.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consulta_examen")
@IdClass(ConsultaExamenPk.class)
public class ConsultaExamen {

    @Id
    private Consulta consulta;

    @Id
    private Examen examen;

}
