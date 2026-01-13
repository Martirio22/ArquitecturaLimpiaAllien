package com.aliengnss.backend.presentacion.dto.req;

import lombok.Data;

@Data
public class ProductoSerialRequestDto {
	private Long idProductoSerial;
	private Long idMovimientoSeries;
	private Long idProducto;
	private Long idCompraProductoDetalle;
	private String serial;
	private Long idUbicacion;
	private String estado;
	private Long idDetalleVenta;
}
