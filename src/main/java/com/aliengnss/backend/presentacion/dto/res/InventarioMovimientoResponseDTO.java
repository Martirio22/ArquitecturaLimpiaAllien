package com.aliengnss.backend.presentacion.dto.res;

import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.dominio.entidades.Ubicacion;

import lombok.Data;

@Data
public class InventarioMovimientoResponseDTO {

	private Long idInventarioMovimiento;
	private LocalDateTime fecha;
	private String tipo;
	private int cantidadEntrada;
	private int cantidadSalida;
	private String referenciaTipo;
	private int referenciaId;
	private Producto fkProducto;
	private ProductoSerial fkProductoSerial;
	private Ubicacion fkUbicacion;
}
