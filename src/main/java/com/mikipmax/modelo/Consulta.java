package com.mikipmax.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "consulta")
public class Consulta extends EntidadBase {

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;

    @Column(name = "numero_consultorio", nullable = false)
    private String numeroConsultorio;

    @Column(name = "fecha_y_hora_consulta", nullable = false)
    private LocalDateTime fechaYHoraConsulta;
    
    @OneToMany(mappedBy = "consulta", cascade = {CascadeType.ALL})
    private List<DetalleConsulta> listaDetallesConsulta;
    

}
