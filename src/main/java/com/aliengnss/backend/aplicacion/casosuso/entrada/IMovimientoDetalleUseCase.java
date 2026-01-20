package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.time.LocalDateTime;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleUseCase {

	MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);

	MovimientoDetalle buscarPorId(Long idMovimientoDetalle);

	List<MovimientoDetalle> listarTodos();

	void eliminar(Long idMovimientoDetalle);

	
	// NUEVOS:
    List<MovimientoDetalle> movimientosDeProductoEnRango(Long idProducto, LocalDateTime inicio, LocalDateTime fin);
    List<MovimientoDetalle> movimientosDesdeUbicacionEnRango(Long idUbicacionOrigen, LocalDateTime inicio, LocalDateTime fin);
    List<MovimientoDetalle> movimientosHaciaUbicacionEnRango(Long idUbicacionDestino, LocalDateTime inicio, LocalDateTime fin);

    // opcional:
    List<MovimientoDetalle> detallesDeMovimiento(Long idMovimiento);
}
