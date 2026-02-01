package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.time.LocalDateTime;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;

public interface IInventarioMovimientoUseCase {
	
	InventarioMovimiento guardar(InventarioMovimiento inventarioMovimiento);
	InventarioMovimiento buscarPorId(Long idInventarioMovimiento);
	List<InventarioMovimiento> listarTodos();
	void eliminar(Long idInventarioMovimiento);

	List<InventarioMovimiento> buscarPorProductoYTipo(Long idProducto, String tipo);
	List<InventarioMovimiento> buscarPorUbicacionTipoYFecha(
			 Long idUbicacion,
	         String tipo,
	         LocalDateTime fechaInicio,
	         LocalDateTime fechaFin
			);
	List<InventarioMovimiento> buscarMovimientoPorSerial(String serial);
	Integer obtenerStockPorProductoYUbicacion(Long idProducto, Long idUbicacion);
}
