package com.aliengnss.backend.presentacion.dto.res;

import com.aliengnss.backend.dominio.entidades.Producto;

import lombok.Data;

@Data
public class ProductoSerialResponseDto {
	private Long idProductoSerial;
	private String serial;
	private String estado;
	
    private Producto fkProducto;
}
