package com.aliengnss.backend.aplicacion.casosuso.entrada;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentaUseCase {
    DetalleVenta guardar(DetalleVenta detalleVenta);
    DetalleVenta buscarPorId(Long idDetalleVenta);
    List<DetalleVenta> listarTodos();
    void eliminar(Long idDetalleVenta);
}
