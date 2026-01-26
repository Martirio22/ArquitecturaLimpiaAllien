package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class UbicacionRequestDto {
	private Long idUbicacion;
	@NotBlank
	private String nombre;
	@NotBlank
	private String tipo;
	@NotBlank
	private String descripcion;
}
