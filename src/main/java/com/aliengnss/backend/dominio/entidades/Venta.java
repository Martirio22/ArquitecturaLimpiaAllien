package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long idVenta;
    private final String numeroFactura;
    private final LocalDateTime fechaVenta;
    private final Long idCliente;
    private final Long idUsuario;
    private final Long idUbicacion;
    private final BigDecimal total;
    private final String observaciones;

    public Venta(Long idVenta,
                 String numeroFactura,
                 LocalDateTime fechaVenta,
                 Long idCliente,
                 Long idUsuario,
                 Long idUbicacion,
                 BigDecimal total,
                 String observaciones) {
        this.idVenta = idVenta;
        this.numeroFactura = numeroFactura;
        this.fechaVenta = fechaVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idUbicacion = idUbicacion;
        this.total = total;
        this.observaciones = observaciones;
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

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdUbicacion() {
        return idUbicacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
