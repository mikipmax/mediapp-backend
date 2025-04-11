package com.mikipmax.repositorio;

import com.mikipmax.modelo.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends RepositorioBase<Paciente, Long> {
}
