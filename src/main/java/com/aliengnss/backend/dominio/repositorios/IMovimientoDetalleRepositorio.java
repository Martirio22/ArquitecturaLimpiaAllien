package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleRepositorio {
	MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);

	Optional<MovimientoDetalle> buscarPorId(Long id);

	List<MovimientoDetalle> listarTodos();

	void eliminar(Long id);
}
