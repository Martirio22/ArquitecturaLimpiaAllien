package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long idVenta;
    private final String numeroFactura;
    private final LocalDateTime fechaVenta;
    private BigDecimal total;
    private final String observaciones;
    
    private Cliente fkCliente;
    private Usuario fkUsuario;
    
    public Venta(Long idVenta, String numeroFactura, LocalDateTime fechaVenta, BigDecimal total, String observaciones,
			Cliente fkCliente, Usuario fkUsuario) {
		super();
		this.idVenta = idVenta;
		this.numeroFactura = numeroFactura;
		this.fechaVenta = fechaVenta;
		this.total = total;
		this.observaciones = observaciones;
		this.fkCliente = fkCliente;
		this.fkUsuario = fkUsuario;
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
	

    
}