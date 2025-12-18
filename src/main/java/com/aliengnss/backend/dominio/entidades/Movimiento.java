package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idMovimiento;
	private final int idCompraProducto;
	private final Date fechaMovimiento;
	private final int idUsuario;
	private final int idUbicacionOrigen;
	private final int idUbicacionDestino;
	private final String tipo;
	private final String observaciones;

	

	private Movimiento(Long idMovimiento, int idCompraProducto, Date fechaMovimiento, int idUsuario,
			int idUbicacionOrigen, int idUbicacionDestino, String tipo, String observaciones) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCompraProducto = idCompraProducto;
		this.fechaMovimiento = fechaMovimiento;
		this.idUsuario = idUsuario;
		this.idUbicacionOrigen = idUbicacionOrigen;
		this.idUbicacionDestino = idUbicacionDestino;
		this.tipo = tipo;
		this.observaciones = observaciones;
	}

	public Long getIdUbicacion() {
		return idMovimiento;
	}

	public int getIdCompraProducto() {
		return idCompraProducto;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getIdUbicacionOrigen() {
		return idUbicacionOrigen;
	}

	public int getIdUbicacionDestino() {
		return idUbicacionDestino;
	}

	public String getTipo() {
		return tipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

}
