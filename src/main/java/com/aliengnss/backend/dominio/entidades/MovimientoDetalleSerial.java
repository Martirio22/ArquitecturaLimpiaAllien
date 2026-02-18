package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class MovimientoDetalleSerial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Long idMovimientoDetalleSerial;
	
	private MovimientoDetalle fkMovimientoDetalle;
	private ProductoSerial fkProductoSerial;
	
	public MovimientoDetalleSerial(Long idMovimientoDetalleSerial, MovimientoDetalle fkMovimientoDetalle,
			ProductoSerial fkProductoSerial) {
		super();
		this.idMovimientoDetalleSerial = idMovimientoDetalleSerial;
		this.fkMovimientoDetalle = fkMovimientoDetalle;
		this.fkProductoSerial = fkProductoSerial;
	}
	public MovimientoDetalle getFkMovimientoDetalle() {
		return fkMovimientoDetalle;
	}
	public void setFkMovimientoDetalle(MovimientoDetalle fkMovimientoDetalle) {
		this.fkMovimientoDetalle = fkMovimientoDetalle;
	}
	public ProductoSerial getFkProductoSerial() {
		return fkProductoSerial;
	}
	public void setFkProductoSerial(ProductoSerial fkProductoSerial) {
		this.fkProductoSerial = fkProductoSerial;
	}
	public Long getIdMovimientoDetalleSerial() {
		return idMovimientoDetalleSerial;
	}
	
	
	
	
}
