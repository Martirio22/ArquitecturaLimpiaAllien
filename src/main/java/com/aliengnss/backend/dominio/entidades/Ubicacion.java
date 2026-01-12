package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private final Long idUbicacion;
	private final Long idCompraProducto;
	private final Long idVenta;
	private final Long idDetalleVenta;
	private final Long idMovimiento;
	private final String nombre;
	private final String descripcion;
	private final String tipo;

	public Ubicacion(Long idUbicacion, Long idCompraProducto, Long idVenta, Long idDetalleVenta, Long idMovimiento,
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

	public Long getIdCompraProducto() {
		return idCompraProducto;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public Long getIdMovimiento() {
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
