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

    @Column(nullable = false)
    private Long idCompraProductoDetalle;

    @Column(nullable = false)
    private Long idDetalleVenta;

    @Column(nullable = false)
    private Long idProductoSerial;

    @Column(nullable = false)
    private Long idMovimientoDetalle;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String foto;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precioVenta;

    @Column(nullable = false)
    private Boolean esConSerial;

    @Column(nullable = false)
    private BigDecimal porcentajeComision;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
}
