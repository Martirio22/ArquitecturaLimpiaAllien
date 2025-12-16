package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private final Long idDetalleVenta;
    private final Long idProductoSerial;
    private final Long idVenta;
    private final Long idProducto;
    private final Long idUbicacion;
    private final int cantidad;
    private final BigDecimal precioUnitario;
    private final BigDecimal porcentajeComision;
    private final BigDecimal subtotal;
    
    
	public DetalleVenta(Long idDetalleVenta, Long idProductoSerial, Long idVenta, Long idProducto, Long idUbicacion,
			int cantidad, BigDecimal precioUnitario, BigDecimal porcentajeComision, BigDecimal subtotal) {
		this.idDetalleVenta = idDetalleVenta;
		this.idProductoSerial = idProductoSerial;
		this.idVenta = idVenta;
		this.idProducto = idProducto;
		this.idUbicacion = idUbicacion;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.porcentajeComision = porcentajeComision;
		this.subtotal = subtotal;
	}

	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}


	public Long getIdProductoSerial() {
		return idProductoSerial;
	}


	public Long getIdVenta() {
		return idVenta;
	}


	public Long getIdProducto() {
		return idProducto;
	}


	public Long getIdUbicacion() {
		return idUbicacion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}


	public BigDecimal getPorcentajeComision() {
		return porcentajeComision;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}
    
    

}
