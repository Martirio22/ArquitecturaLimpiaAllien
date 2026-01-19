package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleUseCase {

    MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);
    MovimientoDetalle buscarPorId(Long idMovimientoDetalle);
    List<MovimientoDetalle> listarTodos();
    void eliminar(Long idMovimientoDetalle);

    }
