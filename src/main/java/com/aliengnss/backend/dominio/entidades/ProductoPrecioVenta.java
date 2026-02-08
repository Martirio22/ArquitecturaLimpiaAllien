package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductoPrecioVenta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idPrecioVenta;
	private Long idProducto;
	private BigDecimal precioVenta;
	private LocalDateTime desde;
	private LocalDateTime hasta;
	public ProductoPrecioVenta(Long idPrecioVenta, Long idProducto, BigDecimal precioVenta, LocalDateTime desde,
			LocalDateTime hasta) {
		super();
		this.idPrecioVenta = idPrecioVenta;
		this.idProducto = idProducto;
		this.precioVenta = precioVenta;
		this.desde = desde;
		this.hasta = hasta;
	}
	public Long getIdPrecioVenta() {
		return idPrecioVenta;
	}
	public void setIdPrecioVenta(Long idPrecioVenta) {
		this.idPrecioVenta = idPrecioVenta;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public LocalDateTime getDesde() {
		return desde;
	}
	public void setDesde(LocalDateTime desde) {
		this.desde = desde;
	}
	public LocalDateTime getHasta() {
		return hasta;
	}
	public void setHasta(LocalDateTime hasta) {
		this.hasta = hasta;
	}
}
