package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;

public interface IMovimientoUseCase {
	Movimiento crear(MovimientoRequestDto dto);

	Movimiento obtenerPorId(Long id);

	List<Movimiento> Listar();

	void eliminar(Long id);
}
