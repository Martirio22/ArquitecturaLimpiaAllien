package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

	private Long idUsuario;
	@NotNull
    private Long idCompraProducto;
	@NotNull
    private Long idVenta;
	@NotNull
    private Long idMovimiento;
	@NotBlank
    private String primerNombre;
	@NotBlank
    private String segundoNombre;
	@NotBlank
    private String primerApellido;
	@NotBlank
    private String segundoApellido;
	@NotBlank
    private String nombreUsuario;
	@NotBlank
    private String rol;
	@NotNull
    private Boolean esActivo;
}
