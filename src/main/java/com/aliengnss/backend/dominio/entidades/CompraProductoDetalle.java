package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompraProductoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long idCompraProductoDetalle;
    private final int cantidad;
    private final BigDecimal costoUnitario;
    private final Boolean esActivo;
    
    private CompraProducto fkCompraProducto;
    private Producto fkProducto;
    private Ubicacion fkUbicacion;
    
	
	public CompraProductoDetalle(Long idCompraProductoDetalle, int cantidad, BigDecimal costoUnitario, Boolean esActivo,
			CompraProducto fkCompraProducto, Producto fkProducto, Ubicacion fkUbicacion) {
		super();
		this.idCompraProductoDetalle = idCompraProductoDetalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
		this.esActivo = esActivo;
		this.fkCompraProducto = fkCompraProducto;
		this.fkProducto = fkProducto;
		this.fkUbicacion = fkUbicacion;
	}
	public CompraProducto getFkCompraProducto() {
		return fkCompraProducto;
	}
	public void setFkCompraProducto(CompraProducto fkCompraProducto) {
		this.fkCompraProducto = fkCompraProducto;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getIdCompraProductoDetalle() {
		return idCompraProductoDetalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	public Boolean getEsActivo() {
		return esActivo;
	}

}
