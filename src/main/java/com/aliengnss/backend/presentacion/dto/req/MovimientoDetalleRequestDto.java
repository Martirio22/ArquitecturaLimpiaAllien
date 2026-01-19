package com.aliengnss.backend.presentacion.dto.req;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.Producto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class MovimientoDetalleRequestDto {
	@Null
	private Long idMovimientoDetalle;
	@NotNull
	private int cantidad;
	@NotNull
	private Movimiento fkMovimiento;
	@NotNull
	private Producto fkProducto;
}
