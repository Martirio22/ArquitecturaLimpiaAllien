package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoSeries;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;

public class MovimientoSeriesUseCaseImpl implements IMovimientoSeriesUseCase {
	
	private final IMovimientoSeriesRepositorio movimientoSeriesRepositorio;
	
	public MovimientoSeriesUseCaseImpl(IMovimientoSeriesRepositorio movimientoSeriesRepositorio) {
		this.movimientoSeriesRepositorio = movimientoSeriesRepositorio;
	}

	@Override
	public MovimientoSeries guardar(MovimientoSeries movimientoSeries) {
		return movimientoSeriesRepositorio.guardar(movimientoSeries);
	}

	@Override
	public MovimientoSeries buscarPorId(Long idMovimientoSeries) {
		return movimientoSeriesRepositorio.buscarPorId(idMovimientoSeries).orElseThrow(() -> new RuntimeException("No existe el MovimientoSeries con el id " + idMovimientoSeries));
	}

	@Override
	public List<MovimientoSeries> listarTodos() {
		return movimientoSeriesRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idMovimientoSeries) {
		movimientoSeriesRepositorio.eliminar(idMovimientoSeries);
	}

}
