package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;

public interface IMovimientoSeriesUseCase {
	MovimientoDetalleSerial guardar(MovimientoDetalleSerial movimientoSeries);
	MovimientoDetalleSerial buscarPorId(Long idMovimientoSeries);
	List<MovimientoDetalleSerial> listarTodos();
	void eliminar(Long idMovimientoSeries);
}
