package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final Long idProducto;
	private final String nombre;
	private final String foto;
	private final String descripcion;
	private final BigDecimal precioVenta;
	private final Boolean esConSerial;
	private final BigDecimal porcentajeComision;
	private final LocalDateTime fechaCreacion;
	public Producto(Long idProducto, String nombre, String foto, String descripcion, BigDecimal precioVenta,
			Boolean esConSerial, BigDecimal porcentajeComision, LocalDateTime fechaCreacion) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precioVenta = precioVenta;
		this.esConSerial = esConSerial;
		this.porcentajeComision = porcentajeComision;
		this.fechaCreacion = fechaCreacion;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFoto() {
		return foto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public Boolean getEsConSerial() {
		return esConSerial;
	}
	public BigDecimal getPorcentajeComision() {
		return porcentajeComision;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	
}
