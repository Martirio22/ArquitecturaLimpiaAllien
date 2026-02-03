package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class VentaDetalleSerial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Long idVentaDetalleSerial;
	private final Boolean esActivo;
	private DetalleVenta fkDetalleVenta;
	private ProductoSerial fkProductoSerial;
	
	
	public VentaDetalleSerial(Long idVentaDetalleSerial, Boolean esActivo, DetalleVenta fkDetalleVenta,
			ProductoSerial fkProductoSerial) {
		super();
		this.idVentaDetalleSerial = idVentaDetalleSerial;
		this.esActivo = esActivo;
		this.fkDetalleVenta = fkDetalleVenta;
		this.fkProductoSerial = fkProductoSerial;
	}
	public DetalleVenta getFkDetalleVenta() {
		return fkDetalleVenta;
	}
	public void setFkDetalleVenta(DetalleVenta fkDetalleVenta) {
		this.fkDetalleVenta = fkDetalleVenta;
	}
	public ProductoSerial getFkProductoSerial() {
		return fkProductoSerial;
	}
	public void setFkProductoSerial(ProductoSerial fkProductoSerial) {
		this.fkProductoSerial = fkProductoSerial;
	}
	public Long getIdVentaDetalleSerial() {
		return idVentaDetalleSerial;
	}
	public Boolean getEsActivo() {
		return esActivo;
	}
	
}
