package com.aliengnss.backend.dominio.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;

public interface IInventarioMovimientoRepositorio {

	InventarioMovimiento guardar(InventarioMovimiento inventarioMovimiento);
	Optional<InventarioMovimiento> buscarPorId(Long idInventarioMovimiento);
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
}
