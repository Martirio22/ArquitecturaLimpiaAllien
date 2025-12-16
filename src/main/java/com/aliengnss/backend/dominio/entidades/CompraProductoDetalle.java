package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class CompraProductoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long idCompraProductoDetalle;
    private final Long idProductoSerial;
    private final Long idCompraProducto;
    private final Long idProducto;
    private final Long idUbicacion;
    private final int cantidad;

    public CompraProductoDetalle(Long idCompraProductoDetalle, Long idProductoSerial, Long idCompraProducto, Long idProducto, Long idUbicacion, int cantidad) {
        this.idCompraProductoDetalle = idCompraProductoDetalle;
        this.idProductoSerial = idProductoSerial;
        this.idCompraProducto = idCompraProducto;
        this.idProducto = idProducto;
        this.idUbicacion = idUbicacion;
        this.cantidad = cantidad;
    }

    public Long getIdUbicacion() {
        return idUbicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public Long getIdCompraProducto() {
        return idCompraProducto;
    }

    public Long getIdProductoSerial() {
        return idProductoSerial;
    }

    public Long getIdCompraProductoDetalle() {
        return idCompraProductoDetalle;
    }
}
