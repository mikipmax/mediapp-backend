package com.mikipmax.servicio;

import com.mikipmax.modelo.Medico;
import com.mikipmax.repositorio.MedicoRepositorio;
import com.mikipmax.repositorio.RepositorioBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl extends ServicioBaseImpl<Medico, Long> implements IMedicoServicio {

    private final MedicoRepositorio medicoRepositorio;

    @Override
    protected RepositorioBase<Medico, Long> getRepositorioBase() {
        return medicoRepositorio;
    }
}
