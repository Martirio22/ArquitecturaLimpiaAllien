package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Producto")
public class ProductoJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
	private String nombre;
	private String marca;
	private String tipo;
	private String foto;
	private String descripcion;
	private BigDecimal precioVenta;
	private Boolean esConSerial;
	private BigDecimal porcentajeComision;
	private LocalDateTime fechaCreacion;
	private Boolean esActivo;
}
