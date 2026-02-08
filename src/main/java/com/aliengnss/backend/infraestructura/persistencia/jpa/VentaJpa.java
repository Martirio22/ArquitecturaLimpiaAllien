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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(nullable = false)
    private String numeroFactura;

    private LocalDateTime fechaVenta;
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