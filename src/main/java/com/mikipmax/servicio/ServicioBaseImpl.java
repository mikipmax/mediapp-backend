package com.mikipmax.servicio;

import com.mikipmax.excepciones.EntidadNoEncontradoExcepcion;
import com.mikipmax.modelo.Paciente;
import com.mikipmax.repositorio.PacienteRepositorio;
import com.mikipmax.repositorio.RepositorioBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public abstract class ServicioBaseImpl<T, ID> implements IServicioBase<T, ID> {

    protected abstract RepositorioBase<T, ID> getRepositorioBase();

    @Override
    public List<T> listarTodos() throws Exception {
        return getRepositorioBase().findAll();
    }

    @Override
    public T buscarPorId(ID id) {
        return getRepositorioBase().findById(id).orElseThrow(() -> new EntidadNoEncontradoExcepcion("ID no encontrado:" + id));
    }

    @Override
    public T guardar(T t) throws Exception {
        return getRepositorioBase().save(t);
    }

    @Override
    public T actualizar(ID id, T t) throws Exception {
        buscarPorId(id);
        return getRepositorioBase().save(t);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        buscarPorId(id);
        getRepositorioBase().deleteById(id);
    }
}
