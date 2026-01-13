package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CompraProducto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long idCompraProducto;
    private final Long idCompraProductoDetalle;
    private final LocalDateTime fechaIngreso;
    private final Long idUsuario;
    private final String observaciones;

    public CompraProducto(Long idCompraProducto,
                          Long idCompraProductoDetalle,
                          LocalDateTime fechaIngreso,
                          Long idUsuario,
                          String observaciones) {
        this.idCompraProducto = idCompraProducto;
        this.idCompraProductoDetalle = idCompraProductoDetalle;
        this.fechaIngreso = fechaIngreso;
        this.idUsuario = idUsuario;
        this.observaciones = observaciones;
    }

    public Long getIdCompraProducto() {
        return idCompraProducto;
    }

    public Long getIdCompraProductoDetalle() {
        return idCompraProductoDetalle;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getObservaciones() {
        return observaciones;
    }
}