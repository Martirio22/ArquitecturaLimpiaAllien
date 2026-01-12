package com.aliengnss.backend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UbicacionRequestDto {
	@NotNull
	private Long idUbicacion;
	@NotNull
	private Long idCompraProducto;
	@NotNull
	private Long idVenta;
	@NotNull
	private Long idDetalleVenta;
	@NotNull
	private Long idMovimiento;
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotBlank
	private String tipo;
}
