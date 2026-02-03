package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class InventarioMovimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Long idInventarioMovimiento;
	private final LocalDateTime fecha;
	private final String tipo;
	private final int cantidadEntrada;
	private final int cantidadSalida;
	private final String referenciaTipo;
	private final int referenciaId;
	private final Boolean esActivo;
	private Producto fkProducto;
	private ProductoSerial fkProductoSerial;
	private Ubicacion fkUbicacion;
	

	public InventarioMovimiento(Long idInventarioMovimiento, LocalDateTime fecha, String tipo, int cantidadEntrada,
			int cantidadSalida, String referenciaTipo, int referenciaId, Boolean esActivo, Producto fkProducto,
			ProductoSerial fkProductoSerial, Ubicacion fkUbicacion) {
		super();
		this.idInventarioMovimiento = idInventarioMovimiento;
		this.fecha = fecha;
		this.tipo = tipo;
		this.cantidadEntrada = cantidadEntrada;
		this.cantidadSalida = cantidadSalida;
		this.referenciaTipo = referenciaTipo;
		this.referenciaId = referenciaId;
		this.esActivo = esActivo;
		this.fkProducto = fkProducto;
		this.fkProductoSerial = fkProductoSerial;
		this.fkUbicacion = fkUbicacion;
	}

	public Producto getFkProducto() {
		return fkProducto;
	}

	public void setFkProducto(Producto fkProducto) {
		this.fkProducto = fkProducto;
	}

	public ProductoSerial getFkProductoSerial() {
		return fkProductoSerial;
	}

	public void setFkProductoSerial(ProductoSerial fkProductoSerial) {
		this.fkProductoSerial = fkProductoSerial;
	}

	public Ubicacion getFkUbicacion() {
		return fkUbicacion;
	}

	public void setFkUbicacion(Ubicacion fkUbicacion) {
		this.fkUbicacion = fkUbicacion;
	}

	public Long getIdInventarioMovimiento() {
		return idInventarioMovimiento;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCantidadEntrada() {
		return cantidadEntrada;
	}

	public int getCantidadSalida() {
		return cantidadSalida;
	}

	public String getReferenciaTipo() {
		return referenciaTipo;
	}

	public int getReferenciaId() {
		return referenciaId;
	}

	public Boolean getEsActivo() {
		return esActivo;
	}

}
