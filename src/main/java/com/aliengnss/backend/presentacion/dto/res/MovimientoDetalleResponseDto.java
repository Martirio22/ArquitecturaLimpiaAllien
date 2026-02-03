package com.aliengnss.backend.presentacion.dto.res;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.Producto;

import lombok.Data;

@Data
public class MovimientoDetalleResponseDto {

	private Long idMovimientoDetalle;
	private int cantidad;
	private Boolean esActivo;
	private Movimiento fkMovimiento;
	private Producto fkProducto;
}
