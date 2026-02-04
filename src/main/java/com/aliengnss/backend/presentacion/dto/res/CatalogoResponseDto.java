package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

@Data
public class CatalogoResponseDto {

	private Long idCatalogo;
	private String nombreCatalogo;
	private String descripcion;
	private boolean esActivo;
}
