package com.aliengnss.backend.dominio.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleRepositorio {

	MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);

	Optional<MovimientoDetalle> buscarPorId(Long idMovimientoDetalle);

	List<MovimientoDetalle> listarTodos();

	void eliminar(Long idMovimientoDetalle);
	
	// NUEVOS:
    List<MovimientoDetalle> movimientosDeProductoEnRango(Long idProducto, LocalDateTime inicio, LocalDateTime fin);
    List<MovimientoDetalle> movimientosDesdeUbicacionEnRango(Long idUbicacionOrigen, LocalDateTime inicio, LocalDateTime fin);
    List<MovimientoDetalle> movimientosHaciaUbicacionEnRango(Long idUbicacionDestino, LocalDateTime inicio, LocalDateTime fin);

    // opcional:
    List<MovimientoDetalle> detallesDeMovimiento(Long idMovimiento);

}
