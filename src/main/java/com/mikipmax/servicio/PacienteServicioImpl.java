package com.mikipmax.servicio;

import com.mikipmax.modelo.Paciente;
import com.mikipmax.repositorio.PacienteRepositorio;
import com.mikipmax.repositorio.RepositorioBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl extends ServicioBaseImpl<Paciente, Long> implements IPacienteServicio {

    private final PacienteRepositorio pacienteRepositorio;

    @Override
    protected RepositorioBase<Paciente, Long> getRepositorioBase() {
        return pacienteRepositorio;
    }
}
