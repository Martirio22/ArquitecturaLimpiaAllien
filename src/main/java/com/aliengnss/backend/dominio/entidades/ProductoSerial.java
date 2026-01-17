package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class ProductoSerial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Long idProductoSerial;
	private final String serial;
	private final String estado;
	
    private Producto fkProducto;

	public ProductoSerial(Long idProductoSerial, String serial, String estado, Producto fkProducto) {
		super();
		this.idProductoSerial = idProductoSerial;
		this.serial = serial;
		this.estado = estado;
		this.fkProducto = fkProducto;
	}

	public Producto getFkProducto() {
		return fkProducto;
	}

	public void setFkProducto(Producto fkProducto) {
		this.fkProducto = fkProducto;
	}

	public Long getIdProductoSerial() {
		return idProductoSerial;
	}

	public String getSerial() {
		return serial;
	}

	public String getEstado() {
		return estado;
	}

	
}
