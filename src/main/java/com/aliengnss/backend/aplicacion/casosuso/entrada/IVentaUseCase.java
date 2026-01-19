package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Venta;

public interface IVentaUseCase {

    Venta guardar(Venta venta);
    Venta buscarPorId(Long idVenta);
    List<Venta> listarTodos();
    void eliminar(Long idVenta);

}
