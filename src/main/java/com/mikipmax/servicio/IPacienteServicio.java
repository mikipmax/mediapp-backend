package com.mikipmax.servicio;

import com.mikipmax.modelo.Paciente;

import java.util.List;

public interface IPacienteServicio {

    List<Paciente> listarTodos() throws Exception;
}
