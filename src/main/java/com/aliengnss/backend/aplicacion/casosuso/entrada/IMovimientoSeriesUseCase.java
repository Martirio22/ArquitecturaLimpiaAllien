package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoSeries;

public interface IMovimientoSeriesUseCase {
	MovimientoSeries guardar(MovimientoSeries movimientoSeries);
	MovimientoSeries buscarPorId(Long idMovimientoSeries);
	List<MovimientoSeries> listarTodos();
	void eliminar(Long idMovimientoSeries);
}
