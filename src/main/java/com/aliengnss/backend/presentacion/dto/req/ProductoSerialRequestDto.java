package com.aliengnss.backend.presentacion.dto.req;

import com.aliengnss.backend.dominio.entidades.Producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class ProductoSerialRequestDto {
	@Null
	private Long idProductoSerial;
	@NotBlank
	private String serial;
	@NotBlank
	private String estado;
	@NotNull
    private Producto fkProducto;
}
