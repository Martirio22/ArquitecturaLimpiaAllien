package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

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

    // Si serial puede ser null (producto sin serial), deja sin @NotNull
    @Positive(message = "idProductoSerial debe ser mayor que 0")
    @Column
    private Long idProductoSerial;

    @NotNull(message = "idCompraProducto es obligatorio")
    @Positive(message = "idCompraProducto debe ser mayor que 0")
    @Column(nullable = false)
    private Long idCompraProducto;

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
}
