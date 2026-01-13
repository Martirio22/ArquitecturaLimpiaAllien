package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class ProductoSerial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Long idProductoSerial;
	private final Long idMovimientoSeries;
    private final Long idProducto;
    private final Long idCompraProductoDetalle;
    private final String serial;
    private final Long idUbicacion;
    private final String estado;
    private final Long idDetalleVenta;
    
    public ProductoSerial(Long idProductoSerial, Long idMovimientoSeries, Long idProducto, Long idCompraProductoDetalle,
			String serial, Long idUbicacion, String estado, Long idDetalleVenta) {
		this.idProductoSerial = idProductoSerial;
		this.idMovimientoSeries = idMovimientoSeries;
		this.idProducto = idProducto;
		this.idCompraProductoDetalle = idCompraProductoDetalle;
		this.serial = serial;
		this.idUbicacion = idUbicacion;
		this.estado = estado;
		this.idDetalleVenta = idDetalleVenta;
	}
    

	public Long getIdProductoSerial() {
		return idProductoSerial;
	}

	public Long getIdMovimientoSeries() {
		return idMovimientoSeries;
	}

	public Long getIdProducto() {
		return idProducto;
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
