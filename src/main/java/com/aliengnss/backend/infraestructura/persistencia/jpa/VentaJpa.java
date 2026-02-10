package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(
  name = "Venta",
  uniqueConstraints = {
    @UniqueConstraint(name = "uk_venta_numero_factura", columnNames = "numeroFactura")
  }
)
public class VentaJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(nullable = false)
    private String numeroFactura;

    private LocalDateTime fechaVenta;

    // NUEVOS (opcionales => nullable por defecto)
    @Column(precision = 18, scale = 2)
    private BigDecimal subtotal;

    @Column(precision = 5, scale = 2) // 15.00, 12.00, etc
    private BigDecimal ivaPorcentaje;

    @Column(precision = 18, scale = 2)
    private BigDecimal ivaValor;

    @Column(precision = 18, scale = 2)
    private BigDecimal total;

    private String observaciones;
    private Boolean esActivo;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteJpa fkCliente;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioJpa fkUsuario;
}
