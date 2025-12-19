package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long idMovimiento;
    private final int idCompraProducto;
    private final LocalDateTime fechaMovimiento;
    private final int idUsuario;
    private final int idUbicacionOrigen;
    private final int idUbicacionDestino;
    private final String tipo;
    private final String observaciones;

    public Movimiento(Long idMovimiento,
                      int idCompraProducto,
                      LocalDateTime fechaMovimiento,
                      int idUsuario,
                      int idUbicacionOrigen,
                      int idUbicacionDestino,
                      String tipo,
                      String observaciones) {
        this.idMovimiento = idMovimiento;
        this.idCompraProducto = idCompraProducto;
        this.fechaMovimiento = fechaMovimiento;
        this.idUsuario = idUsuario;
        this.idUbicacionOrigen = idUbicacionOrigen;
        this.idUbicacionDestino = idUbicacionDestino;
        this.tipo = tipo;
        this.observaciones = observaciones;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public int getIdCompraProducto() {
        return idCompraProducto;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdUbicacionOrigen() {
        return idUbicacionOrigen;
    }

    public int getIdUbicacionDestino() {
        return idUbicacionDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }
}