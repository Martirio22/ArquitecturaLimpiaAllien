package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;

public interface IInventarioMovimientoUseCase {
	
	InventarioMovimiento guardar(InventarioMovimiento inventarioMovimiento);
	InventarioMovimiento buscarPorId(Long idInventarioMovimiento);
	List<InventarioMovimiento> listarTodos();
	void eliminar(Long idInventarioMovimiento);

}
