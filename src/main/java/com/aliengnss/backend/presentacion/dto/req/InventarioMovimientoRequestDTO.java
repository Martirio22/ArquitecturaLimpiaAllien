package com.aliengnss.backend.presentacion.dto.req;


import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.dominio.entidades.Ubicacion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class InventarioMovimientoRequestDTO {

	@Null
	private Long idInventarioMovimiento;
	@NotBlank
	private String tipo;
	@NotNull
	private int cantidadEntrada;
	@NotNull
	private int cantidadSalida;
	@NotBlank
	private String referenciaTipo;
	@NotNull
	private int referenciaId;
	private Boolean esActivo;
	@NotNull
	private Producto fkProducto;
	
	private ProductoSerial fkProductoSerial;
	@NotNull
	private Ubicacion fkUbicacion;
}
