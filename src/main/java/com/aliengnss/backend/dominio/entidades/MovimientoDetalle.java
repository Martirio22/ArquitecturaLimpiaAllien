package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class MovimientoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idMovimientoDetalle;
	private final int idMovimientoSeries;
	private final int idMovimiento;
	private final int idProducto;
	private final int cantidad;

	private MovimientoDetalle(Long idMovimientoDetalle, int idMovimientoSeries, int idMovimiento, int idProducto,
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

	public int getIdMovimientoSeries() {
		return idMovimientoSeries;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	

}
