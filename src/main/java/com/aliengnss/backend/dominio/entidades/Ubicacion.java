package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final Long idUbicacion;
	private final String nombre;
	private final String tipo;
	private final String descripcion;
	private final Boolean esActivo;
	
	
	
	public Ubicacion(Long idUbicacion, String nombre, String tipo, String descripcion, Boolean esActivo) {
		super();
		this.idUbicacion = idUbicacion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.esActivo = esActivo;
	}
	public Long getIdUbicacion() {
		return idUbicacion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Boolean getEsActivo() {
		return esActivo;
	}
	
}
