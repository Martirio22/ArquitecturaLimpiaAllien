package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "DetalleVenta")
@Data
public class DetalleVentaJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;
	
	@Positive(message = "idProductoSerial debe ser mayor que 0")
	@Column
	private Long idProductoSerial;
	
	@NotNull(message = "idVenta es obligatorio")
    @Positive(message = "idVenta debe ser mayor que 0")
    @Column(nullable = false)
    private Long idVenta;
	
	@NotNull(message = "idProducto es obligatorio")
    @Positive(message = "idProducto debe ser mayor que 0")
    @Column(nullable = false)
    private Long idProducto;
	
	@NotNull(message = "idUbicacion es obligatorio")
    @Positive(message = "idUbicacion debe ser mayor que 0")
    @Column(nullable = false)
    private Long idUbicacion;

	
	@Min(value = 1, message = "cantidad debe ser al menos 1")
    @Max(value = 1_000_000, message = "cantidad excede el máximo permitido")
	@Column(nullable = false)
    private int cantidad;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal precioUnitario;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal porcentajeComision;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal subtotal;
}
