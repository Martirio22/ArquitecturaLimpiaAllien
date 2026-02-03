package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private final Long idDetalleVenta;
    private final int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal porcentajeComision;
    private BigDecimal subtotal;
    private final Boolean esActivo;
    private Venta fkVenta;
    private Producto fkProducto;
    private Ubicacion fkUbicacion;
    
	
	public DetalleVenta(Long idDetalleVenta, int cantidad, BigDecimal precioUnitario, BigDecimal porcentajeComision,
			BigDecimal subtotal, Boolean esActivo, Venta fkVenta, Producto fkProducto, Ubicacion fkUbicacion) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.porcentajeComision = porcentajeComision;
		this.subtotal = subtotal;
		this.esActivo = esActivo;
		this.fkVenta = fkVenta;
		this.fkProducto = fkProducto;
		this.fkUbicacion = fkUbicacion;
	}
	public Venta getFkVenta() {
		return fkVenta;
	}
	public void setFkVenta(Venta fkVenta) {
		this.fkVenta = fkVenta;
	}
	public Producto getFkProducto() {
		return fkProducto;
	}
	public void setFkProducto(Producto fkProducto) {
		this.fkProducto = fkProducto;
	}
	public Ubicacion getFkUbicacion() {
		return fkUbicacion;
	}
	public void setFkUbicacion(Ubicacion fkUbicacion) {
		this.fkUbicacion = fkUbicacion;
	}
	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public BigDecimal getPorcentajeComision() {
		return porcentajeComision;
	}
	public void setPorcentajeComision(BigDecimal porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public Boolean getEsActivo() {
		return esActivo;
	}
}
