package com.aliengnss.backend.presentacion.dto.req;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompraProductoRequestDTO {

	private Long idCompraProducto;
	@NotNull
    private Long idCompraProductoDetalle;
	@NotNull
    private LocalDateTime fechaIngreso;
	@NotNull
    private Long idUsuario;
	@NotBlank
	private String observaciones;

}
