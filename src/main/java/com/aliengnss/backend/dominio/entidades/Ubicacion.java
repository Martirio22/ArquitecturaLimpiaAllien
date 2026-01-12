package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private final Long idUbicacion;
	private final int idCompraProducto;
	private final int idVenta;
	private final int idDetalleVenta;
	private final int idMovimiento;
	private final String nombre;
	private final String descripcion;
	private final String tipo;

	private Ubicacion(Long idUbicacion, int idCompraProducto, int idVenta, int idDetalleVenta, int idMovimiento,
			String nombre, String descripcion, String tipo) {
		super();
		this.idUbicacion = idUbicacion;
		this.idCompraProducto = idCompraProducto;
		this.idVenta = idVenta;
		this.idDetalleVenta = idDetalleVenta;
		this.idMovimiento = idMovimiento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}


	public Long getIdUbicacion() {
		return idUbicacion;
	}

	public int getIdCompraProducto() {
		return idCompraProducto;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	
}
