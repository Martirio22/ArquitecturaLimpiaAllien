package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CompraProducto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long idCompraProducto;
    private final LocalDateTime fechaIngreso;
    private final String observaciones;
    
    private Usuario fkUsuario;
    
    public CompraProducto(Long idCompraProducto, LocalDateTime fechaIngreso, String observaciones, Usuario fkUsuario) {
		super();
		this.idCompraProducto = idCompraProducto;
		this.fechaIngreso = fechaIngreso;
		this.observaciones = observaciones;
		this.fkUsuario = fkUsuario;
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

	public Long getIdCompraProducto() {
		return idCompraProducto;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public String getObservaciones() {
		return observaciones;
	}
    
}