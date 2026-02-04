package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idCatalogo;
	private String nombreCatalogo;
	private String descripcion;
	private boolean esActivo;
	
	public Catalogo(Long idCatalogo, String nombreCatalogo, String descripcion, boolean esActivo) {
		super();
		this.idCatalogo = idCatalogo;
		this.nombreCatalogo = nombreCatalogo;
		this.descripcion = descripcion;
		this.esActivo = esActivo;
	}
	public Long getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEsActivo() {
		return esActivo;
	}
	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	
	
}
