package com.aliengnss.backend.dominio.repositorios;

import com.aliengnss.backend.dominio.entidades.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentaRepositorio {
    Venta guardar(Venta venta);
    Optional<Venta> buscarPorId(Long idVenta);
    List<Venta> listarTodos();
    void eliminar(Long idVenta);
}
