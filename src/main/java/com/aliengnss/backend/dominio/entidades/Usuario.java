package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Long idUsuario;
    private final int idCompraProducto;
    private final int idVenta;
    private final int idMovimiento;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String nombreUsuario;
    private final String rol;
    private final Character esActivo;

    public Usuario(Long idUsuario, int idCompraProducto, int idVenta, int idMovimiento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String nombreUsuario, String rol, Character esActivo) {
        this.idUsuario = idUsuario;
        this.idCompraProducto = idCompraProducto;
        this.idVenta = idVenta;
        this.idMovimiento = idMovimiento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.esActivo = esActivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public int getIdCompraProducto() {
        return idCompraProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public Character getEsActivo() {
        return esActivo;
    }
}
