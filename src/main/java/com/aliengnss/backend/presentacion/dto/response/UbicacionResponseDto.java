package com.aliengnss.backend.presentacion.dto.response;

import lombok.Data;

@Data
public class UbicacionResponseDto {
	private Long idUbicacion;

	private Long idCompraProducto;

	private Long idVenta;

	private Long idDetalleVenta;

	private Long idMovimiento;

	private String nombre;

	private String descripcion;

	private String tipo;
	
	
}
