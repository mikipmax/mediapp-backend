package com.mikipmax.servicio;

import java.util.List;

public interface IServicioBase<T, ID> {

    List<T> listarTodos() throws Exception;

    T buscarPorId(ID id) throws Exception;

    T guardar(T t) throws Exception;

    T actualizar(ID id, T t) throws Exception;

    void eliminar(ID id) throws Exception;
}
