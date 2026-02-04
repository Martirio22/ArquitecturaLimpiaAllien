package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class DetalleCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idDetalleCatalogo;
	private String codigoDetalle;
	private String descripcion;
	private double valorNumerico;
	private Long orden;
	private boolean esActivo;
	
	private Long idCatalogo;

	public DetalleCatalogo(Long idDetalleCatalogo, String codigoDetalle, String descripcion, double valorNumerico,
			Long orden, boolean esActivo, Long idCatalogo) {
		super();
		this.idDetalleCatalogo = idDetalleCatalogo;
		this.codigoDetalle = codigoDetalle;
		this.descripcion = descripcion;
		this.valorNumerico = valorNumerico;
		this.orden = orden;
		this.esActivo = esActivo;
		this.idCatalogo = idCatalogo;
	}

	public Long getIdDetalleCatalogo() {
		return idDetalleCatalogo;
	}

	public void setIdDetalleCatalogo(Long idDetalleCatalogo) {
		this.idDetalleCatalogo = idDetalleCatalogo;
	}

	public String getCodigoDetalle() {
		return codigoDetalle;
	}

	public void setCodigoDetalle(String codigoDetalle) {
		this.codigoDetalle = codigoDetalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(double valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	public Long getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	
	

}
