package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class MovimientoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idMovimientoDetalle;
	private final int cantidad;
	private final Boolean esActivo;
	private Movimiento fkMovimiento;
	private Producto fkProducto;

	public MovimientoDetalle(Long idMovimientoDetalle, int cantidad, Boolean esActivo, Movimiento fkMovimiento,
			Producto fkProducto) {
		super();
		this.idMovimientoDetalle = idMovimientoDetalle;
		this.cantidad = cantidad;
		this.esActivo = esActivo;
		this.fkMovimiento = fkMovimiento;
		this.fkProducto = fkProducto;
	}

	public Movimiento getFkMovimiento() {
		return fkMovimiento;
	}

	public void setFkMovimiento(Movimiento fkMovimiento) {
		this.fkMovimiento = fkMovimiento;
	}

	public Producto getFkProducto() {
		return fkProducto;
	}

	public void setFkProducto(Producto fkProducto) {
		this.fkProducto = fkProducto;
	}

	public Long getIdMovimientoDetalle() {
		return idMovimientoDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Boolean getEsActivo() {
		return esActivo;
	}

}
