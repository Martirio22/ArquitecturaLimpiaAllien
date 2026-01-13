package com.aliengnss.backend.presentacion.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovimientoRequestDto {
	private Long idMovimiento;
	@NotNull
	private Long idCompraProducto;
	@NotNull
	private Date fechaMovimiento;
	@NotNull
	private Long idUsuario;
	@NotNull
	private Long idUbicacionOrigen;
	@NotNull
	private Long idUbicacionDestino;
	@NotBlank
	private String tipo;
	@NotBlank
	private String observaciones;
}
