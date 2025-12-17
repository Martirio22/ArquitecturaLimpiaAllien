package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class ProductoSerial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Long idProdcutoSerial;
	private final Long idMovimientoSeries;
	private final Long idProdcuto;
	private final Long idCompraProductoDetalle;
	private final String serial;
	private final Long idUbicacion;
	private final String estado;
	private final Long idDetalleVenta;
	
	public ProductoSerial(Long idProdcutoSerial, Long idMovimientoSeries, Long idProdcuto, Long idCompraProductoDetalle,
			String serial, Long idUbicacion, String estado, Long idDetalleVenta) {
		super();
		this.idProdcutoSerial = idProdcutoSerial;
		this.idMovimientoSeries = idMovimientoSeries;
		this.idProdcuto = idProdcuto;
		this.idCompraProductoDetalle = idCompraProductoDetalle;
		this.serial = serial;
		this.idUbicacion = idUbicacion;
		this.estado = estado;
		this.idDetalleVenta = idDetalleVenta;
	}
	
	public Long getIdProdcutoSerial() {
		return idProdcutoSerial;
	}

	public Long getIdMovimientoSeries() {
		return idMovimientoSeries;
	}

	public Long getIdProdcuto() {
		return idProdcuto;
	}

	public Long getIdCompraProductoDetalle() {
		return idCompraProductoDetalle;
	}

	public String getSerial() {
		return serial;
	}

	public Long getIdUbicacion() {
		return idUbicacion;
	}

	public String getEstado() {
		return estado;
	}

	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}

}
