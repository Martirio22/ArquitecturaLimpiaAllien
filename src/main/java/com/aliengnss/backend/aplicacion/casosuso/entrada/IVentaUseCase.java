package com.aliengnss.backend.aplicacion.casosuso.entrada;

import com.aliengnss.backend.dominio.entidades.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentaUseCase {
    Venta guardar(Venta venta);
    Venta buscarPorId(Long idVenta);
    List<Venta> listarTodos();
    void eliminar(Long idVenta);
}
