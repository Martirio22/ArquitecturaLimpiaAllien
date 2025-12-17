package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductoSerial")

public class ProductoSerialJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProductoSerial;
	
	@Column(nullable = false)
	private Long idMovimientoSeries;
	
	@Column(nullable = false)
	private Long idProducto;
	
	@Column(nullable = false)
	private Long idCompraProductoDetalle;
	
	@Column(nullable = false)
	private String serial;
	
	@Column(nullable = false)
	private Long idUbicacion;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private Long idDetalleVenta;

}
