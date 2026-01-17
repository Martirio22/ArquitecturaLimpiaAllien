package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;

public interface IMovimientoSeriesRepositorio {
	MovimientoDetalleSerial guardar(MovimientoDetalleSerial movimientoSeries);
    Optional<MovimientoDetalleSerial> buscarPorId(Long idMovimientoSeries);
    List<MovimientoDetalleSerial> listarTodos();
    void eliminar(Long idMovimientoSeries);
}
