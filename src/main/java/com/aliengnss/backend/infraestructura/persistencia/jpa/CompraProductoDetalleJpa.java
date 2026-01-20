package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(
        name = "CompraProductoDetalle"
)
public class CompraProductoDetalleJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompraProductoDetalle;
    private int cantidad;
    private BigDecimal costoUnitario;
    
    @ManyToOne
    @JoinColumn(name = "idCompraProducto")
    private CompraProductoJpa fkCompraProducto;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private ProductoJpa fkProducto;
    @ManyToOne
    @JoinColumn(name = "idUbicacion")
    private UbicacionJpa fkUbicacion;
}
