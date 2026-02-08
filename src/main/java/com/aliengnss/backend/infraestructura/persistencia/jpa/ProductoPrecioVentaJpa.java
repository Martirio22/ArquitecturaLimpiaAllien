package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ProductoPrecioVenta")
public class ProductoPrecioVentaJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrecioVenta;

    @ManyToOne(optional = false)
    @JoinColumn(name="idProducto", nullable=false)
    private ProductoJpa producto;

    @Column(nullable=false, precision=12, scale=2)
    private BigDecimal precioVenta;

    @Column(nullable=false)
    private LocalDateTime desde;

    @Column
    private LocalDateTime hasta; // null = vigente
}