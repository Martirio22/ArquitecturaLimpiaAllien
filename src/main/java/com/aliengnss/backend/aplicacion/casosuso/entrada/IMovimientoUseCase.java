package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Movimiento;

public interface IMovimientoUseCase {
	Movimiento crear(Movimiento movimiento);

	Movimiento obtenerPorId(Long id);

	List<Movimiento> Listar();

	void eliminar(Long id);
}
