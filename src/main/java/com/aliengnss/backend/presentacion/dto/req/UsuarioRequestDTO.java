package com.aliengnss.backend.presentacion.dto.req;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
	
	private Long idUsuario;

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
    @Email
    private String correoElectronico;

    @NotBlank
    private String cedula;

    @NotBlank
    private String clave;

    @Min(0)
    private int intentosActual;

    @NotNull
    @PastOrPresent
    private Date ultimoAcceso;

    @NotBlank
    private String rol;

    @NotNull
    private Boolean esActivo;
}
