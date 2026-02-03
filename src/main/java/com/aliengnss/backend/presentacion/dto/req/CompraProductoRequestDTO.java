package com.aliengnss.backend.presentacion.dto.req;

import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CompraProductoRequestDTO {

	@Null
	private Long idCompraProducto;
	@NotNull
    private LocalDateTime fechaIngreso;
	@NotBlank
    private String observaciones;
	private Boolean esActivo;
	@NotNull
    private UsuarioRequestDTO fkUsuario;

}
