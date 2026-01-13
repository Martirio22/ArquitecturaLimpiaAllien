package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

@Data
public class ProductoSerialResponseDto {
	private Long idProductoSerial;
	private Long idMovimientoSeries;
	private Long idProducto;
	private Long idCompraProductoDetalle;
	private String serial;
	private Long idUbicacion;
	private String estado;
	private Long idDetalleVenta;
}
