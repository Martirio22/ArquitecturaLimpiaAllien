package com.aliengnss.backend.presentacion.dto.res;

import java.util.Date;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

	private Long idUsuario;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreUsuario;
    private String correoElectronico;
    private String cedula;
    private String clave;
    private int intentosActual;
    private Date ultimoAcceso;
    private String rol;
    private Boolean esActivo;
    private Boolean esNuevo;
    
}
