package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleUseCase {
	MovimientoDetalle crear(MovimientoDetalle movimientoDetalle);

	MovimientoDetalle obtenerPorId(Long id);

	List<MovimientoDetalle> Listar();

	void eliminar(Long id);
}
