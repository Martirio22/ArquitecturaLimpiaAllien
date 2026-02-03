package com.aliengnss.backend.presentacion.dto.req;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.Producto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MovimientoDetalleRequestDto {
	
	private Long idMovimientoDetalle;
	@NotNull
	private int cantidad;
	private Boolean esActivo;
	@NotNull
	private Movimiento fkMovimiento;
	@NotNull
	private Producto fkProducto;
	
}
