package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;

public interface IMovimientoSeriesUseCase {

    MovimientoDetalleSerial guardar(MovimientoDetalleSerial entity);
    MovimientoDetalleSerial buscarPorId(Long idMovimientoDetalleSerial);
    List<MovimientoDetalleSerial> listarTodos();
    void eliminar(Long idMovimientoDetalleSerial);

}
