package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;

public class MovimientoSeriesUseCaseImpl implements IMovimientoSeriesUseCase {
	
	private final IMovimientoSeriesRepositorio movimientoSeriesRepositorio;
	
	public MovimientoSeriesUseCaseImpl(IMovimientoSeriesRepositorio movimientoSeriesRepositorio) {
		this.movimientoSeriesRepositorio = movimientoSeriesRepositorio;
	}

	@Override
	public MovimientoDetalleSerial guardar(MovimientoDetalleSerial movimientoSeries) {
		return movimientoSeriesRepositorio.guardar(movimientoSeries);
	}

	@Override
	public MovimientoDetalleSerial buscarPorId(Long idMovimientoSeries) {
		return movimientoSeriesRepositorio.buscarPorId(idMovimientoSeries).orElseThrow(() -> new RuntimeException("No existe el MovimientoSeries con el id " + idMovimientoSeries));
	}

	@Override
	public List<MovimientoDetalleSerial> listarTodos() {
		return movimientoSeriesRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idMovimientoSeries) {
		movimientoSeriesRepositorio.eliminar(idMovimientoSeries);
	}

}
