package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.util.Date;

public class CompraProducto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long idCompraProducto;
    private final Long idCompraProductoDetalle;
    private final Date fechaIngreso;
    private final Long idUsuario;
    private final String observaciones;

    public CompraProducto(Long idCompraProducto, Long idCompraProductoDetalle, Date fechaIngreso, Long idUsuario, String observaciones) {
        this.idCompraProducto = idCompraProducto;
        this.idCompraProductoDetalle = idCompraProductoDetalle;
        this.fechaIngreso = fechaIngreso;
        this.idUsuario = idUsuario;
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Long getIdCompraProductoDetalle() {
        return idCompraProductoDetalle;
    }

    public Long getIdCompraProducto() {
        return idCompraProducto;
    }
}
