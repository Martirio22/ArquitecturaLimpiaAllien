package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class MovimientoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idMovimientoDetalle;
	private final Long idMovimientoSeries;
	private final Long idMovimiento;
	private final Long idProducto;
	private final int cantidad;

	public MovimientoDetalle(Long idMovimientoDetalle, Long idMovimientoSeries, Long idMovimiento, Long idProducto,
			int cantidad) {
		super();
		this.idMovimientoDetalle = idMovimientoDetalle;
		this.idMovimientoSeries = idMovimientoSeries;
		this.idMovimiento = idMovimiento;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public Long getIdMovimientoDetalle() {
		return idMovimientoDetalle;
	}

	public Long getIdMovimientoSeries() {
		return idMovimientoSeries;
	}

	public Long getIdMovimiento() {
		return idMovimiento;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	

}
