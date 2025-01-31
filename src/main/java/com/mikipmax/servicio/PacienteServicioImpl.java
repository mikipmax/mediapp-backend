package com.mikipmax.servicio;

import com.mikipmax.modelo.Paciente;
import com.mikipmax.repositorio.PacienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements IPacienteServicio {

    public final PacienteRepositorio pacienteRepositorio;

    @Override
    public List<Paciente> listarTodos() throws Exception {
        return pacienteRepositorio.findAll();
    }
}
