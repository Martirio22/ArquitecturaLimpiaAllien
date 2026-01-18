package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private final Long idCliente;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String documento;
    private final String telefono;
    private final String email;
    private final String direccion;
    
    
	public Cliente(Long idCliente, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String documento, String telefono, String email, String direccion) {
		this.idCliente = idCliente;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.documento = documento;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}


	public Long getIdCliente() {
		return idCliente;
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


	public String getDocumento() {
		return documento;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getEmail() {
		return email;
	}


	public String getDireccion() {
		return direccion;
	}
    
    
	
}
