package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;

public interface IMovimientoSeriesRepositorio {

    MovimientoDetalleSerial guardar(MovimientoDetalleSerial entity);
    Optional<MovimientoDetalleSerial> buscarPorId(Long idMovimientoDetalleSerial);
    List<MovimientoDetalleSerial> listarTodos();
    void eliminar(Long idMovimientoDetalleSerial);

}
