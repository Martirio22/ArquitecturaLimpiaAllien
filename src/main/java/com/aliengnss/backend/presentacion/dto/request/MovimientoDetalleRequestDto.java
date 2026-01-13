package com.aliengnss.backend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovimientoDetalleRequestDto {
	private Long idMovimientoDetalle;
	@NotNull
	private Long idMovimientoSeries;
	@NotNull
	private Long idMovimiento;
	@NotNull
	private Long idProducto;
	@NotBlank
	private int cantidad;
}
