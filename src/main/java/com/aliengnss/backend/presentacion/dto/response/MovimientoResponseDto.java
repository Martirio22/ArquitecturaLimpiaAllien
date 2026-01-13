package com.aliengnss.backend.presentacion.dto.response;

import java.sql.Date;

import lombok.Data;

@Data
public class MovimientoResponseDto {

	private Long idMovimiento;
	
	private Long idCompraProducto;

	private Date fechaMovimiento;

	private Long idUsuario;

	private Long idUbicacionOrigen;

	private Long idUbicacionDestino;

	private String tipo;

	private String observaciones;
}
