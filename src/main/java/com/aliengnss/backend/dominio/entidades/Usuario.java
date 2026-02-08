package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Usuario implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private final Long idUsuario;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String nombreUsuario;
    private final String correoElectronico;
    private final String cedula;
    private final String clave;
    private final int intentosActual;
    private final LocalDateTime ultimoAcceso;
    private final String rol;
    private final Boolean esActivo;
    private final Boolean esNuevo;
    
	public Usuario(Long idUsuario, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String nombreUsuario, String correoElectronico, String cedula, String clave,
			int intentosActual, LocalDateTime ultimoAcceso, String rol, Boolean esActivo, Boolean esNuevo) {
		super();
		this.idUsuario = idUsuario;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
		this.cedula = cedula;
		this.clave = clave;
		this.intentosActual = intentosActual;
		this.ultimoAcceso = ultimoAcceso;
		this.rol = rol;
		this.esActivo = esActivo;
		this.esNuevo = esNuevo;
	}

	public Long getIdUsuario() {
		return idUsuario;
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getCedula() {
		return cedula;
	}

	public String getClave() {
		return clave;
	}

	public int getIntentosActual() {
		return intentosActual;
	}

	public LocalDateTime getUltimoAcceso() {
		return ultimoAcceso;
	}

	public String getRol() {
		return rol;
	}

	public Boolean getEsActivo() {
		return esActivo;
	}

	public Boolean getEsNuevo() {
		return esNuevo;
	}
    
    
}
