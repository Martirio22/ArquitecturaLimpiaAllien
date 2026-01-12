package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idMovimiento;
	private final Long idCompraProducto;
	private final LocalDate fechaMovimiento;
	private final Long idUsuario;
	private final Long idUbicacionOrigen;
	private final Long idUbicacionDestino;
	private final String tipo;
	private final String observaciones;

	

	public Movimiento(Long idMovimiento, Long idCompraProducto, LocalDate fechaMovimiento, Long idUsuario,
			Long idUbicacionOrigen, Long idUbicacionDestino, String tipo, String observaciones) {
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

	public Long getIdCompraProducto() {
		return idCompraProducto;
	}

	public LocalDate getFechaMovimiento() {
		return fechaMovimiento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Long getIdUbicacionOrigen() {
		return idUbicacionOrigen;
	}

	public Long getIdUbicacionDestino() {
		return idUbicacionDestino;
	}

	public String getTipo() {
		return tipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

}
