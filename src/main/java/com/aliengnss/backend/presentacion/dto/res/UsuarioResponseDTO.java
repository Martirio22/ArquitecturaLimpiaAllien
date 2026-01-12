package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

	private Long idUsuario;
    private Long idCompraProducto;
    private Long idVenta;
    private Long idMovimiento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreUsuario;
    private String rol;
    private Boolean esActivo;
    
}
