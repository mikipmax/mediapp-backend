package com.mikipmax.controlador;

import com.mikipmax.modelo.Paciente;
import com.mikipmax.servicio.IPacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/pacientes")
@RequiredArgsConstructor
public class PacienteControlador {

    private final IPacienteServicio pacienteServicio;

    @GetMapping
    public List<Paciente> listarTodos() throws Exception {
        return pacienteServicio.listarTodos();
    }
}
