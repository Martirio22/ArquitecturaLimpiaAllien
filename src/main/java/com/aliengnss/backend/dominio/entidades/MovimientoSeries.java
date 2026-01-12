package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class MovimientoSeries implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Long idMovimientoSeries;
	private final Long idMovimientoDetalle;
	private final Long idProductoSerial;

	public MovimientoSeries(Long idMovimientoSeries, Long idMovimientoDetalle, Long idProductoSerial) {
		super();
		this.idMovimientoSeries = idMovimientoSeries;
		this.idMovimientoDetalle = idMovimientoDetalle;
		this.idProductoSerial = idProductoSerial;
	}
	
	public Long getIdMovimientoSeries() {
		return idMovimientoSeries;
	}

	public Long getIdMovimientoDetalle() {
		return idMovimientoDetalle;
	}

	public Long getIdProductoSerial() {
		return idProductoSerial;
	}

}
