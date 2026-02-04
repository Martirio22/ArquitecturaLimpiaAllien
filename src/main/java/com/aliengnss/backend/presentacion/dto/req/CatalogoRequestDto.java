package com.aliengnss.backend.presentacion.dto.req;

import lombok.Data;

@Data
public class CatalogoRequestDto {

	private Long idCatalogo;
	private String nombreCatalogo;
	private String descripcion;
	private boolean esActivo;
}
