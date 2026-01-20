package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idMovimiento;
	private final LocalDateTime fechaMovimiento;
	private final String tipo;
	private final String observaciones;
	
	private Usuario fkUsuario;
	private Ubicacion fkUbicacionOrigen;
	private Ubicacion fkUbicacionDestino;
	
	public Movimiento(Long idMovimiento, LocalDateTime fechaMovimiento, String tipo, String observaciones,
			Usuario fkUsuario, Ubicacion fkUbicacionOrigen, Ubicacion fkUbicacionDestino) {
		super();
		this.idMovimiento = idMovimiento;
		this.fechaMovimiento = fechaMovimiento;
		this.tipo = tipo;
		this.observaciones = observaciones;
		this.fkUsuario = fkUsuario;
		this.fkUbicacionOrigen = fkUbicacionOrigen;
		this.fkUbicacionDestino = fkUbicacionDestino;
	}
	public Usuario getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	public Ubicacion getFkUbicacionOrigen() {
		return fkUbicacionOrigen;
	}
	public void setFkUbicacionOrigen(Ubicacion fkUbicacionOrigen) {
		this.fkUbicacionOrigen = fkUbicacionOrigen;
	}
	public Ubicacion getFkUbicacionDestino() {
		return fkUbicacionDestino;
	}
	public void setFkUbicacionDestino(Ubicacion fkUbicacionDestino) {
		this.fkUbicacionDestino = fkUbicacionDestino;
	}
	public Long getIdMovimiento() {
		return idMovimiento;
	}
	public LocalDateTime getFechaMovimiento() {
		return fechaMovimiento;
	}
	public String getTipo() {
		return tipo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	
	
	
	
}