package com.aliengnss.backend.presentacion.dto.req;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
	
	private Long idUsuario;

    @NotBlank
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    private String primerNombre;

    @NotBlank
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    private String segundoNombre;

    @NotBlank
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    private String primerApellido;

    @NotBlank
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    private String segundoApellido;

    @NotBlank
    private String nombreUsuario;

    @NotBlank
    @Email
    private String correoElectronico;

    @NotBlank
    private String cedula;
    private int intentosActual;

    @NotBlank
    private String clave;

    @NotBlank
    private String rol;
    private Boolean esActivo;
    private Boolean esNuevo;
}
