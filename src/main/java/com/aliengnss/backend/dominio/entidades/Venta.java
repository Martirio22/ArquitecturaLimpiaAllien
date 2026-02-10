package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Long idVenta;
	private final String numeroFactura;
	private final LocalDateTime fechaVenta;

	private BigDecimal subtotal; // NUEVO (opcional)
	private BigDecimal ivaPorcentaje; // NUEVO (opcional) ej: 15
	private BigDecimal ivaValor; // NUEVO (opcional)
	private BigDecimal total;

	private final String observaciones;
	private final Boolean esActivo;
	private Cliente fkCliente;
	private Usuario fkUsuario;

	public Venta(Long idVenta, String numeroFactura, LocalDateTime fechaVenta, BigDecimal subtotal,
			BigDecimal ivaPorcentaje, BigDecimal ivaValor, BigDecimal total, String observaciones, Boolean esActivo,
			Cliente fkCliente, Usuario fkUsuario) {
		this.idVenta = idVenta;
		this.numeroFactura = numeroFactura;
		this.fechaVenta = fechaVenta;
		this.subtotal = subtotal;
		this.ivaPorcentaje = ivaPorcentaje;
		this.ivaValor = ivaValor;
		this.total = total;
		this.observaciones = observaciones;
		this.esActivo = esActivo;
		this.fkCliente = fkCliente;
		this.fkUsuario = fkUsuario;
	}

	// getters/setters nuevos
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getIvaPorcentaje() {
		return ivaPorcentaje;
	}

	public void setIvaPorcentaje(BigDecimal ivaPorcentaje) {
		this.ivaPorcentaje = ivaPorcentaje;
	}

	public BigDecimal getIvaValor() {
		return ivaValor;
	}

	public void setIvaValor(BigDecimal ivaValor) {
		this.ivaValor = ivaValor;
	}

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Usuario getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public Boolean getEsActivo() {
		return esActivo;
	}

}