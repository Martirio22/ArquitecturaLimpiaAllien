package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(
        name = "CompraProducto"

)
public class CompraProductoJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompraProducto;

    @NotNull(message = "idCompraProductoDetalle es obligatorio")
    @Positive(message = "idCompraProductoDetalle debe ser mayor que 0")
    @Column(nullable = false)
    private Long idCompraProductoDetalle;

    @NotNull(message = "fechaIngreso es obligatoria")
    @PastOrPresent(message = "fechaIngreso no puede ser futura")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaIngreso;

    @NotNull(message = "idUsuario es obligatorio")
    @Positive(message = "idUsuario debe ser mayor que 0")
    @Column(nullable = false)
    private Long idUsuario;

    @Size(max = 500, message = "observaciones no puede exceder 500 caracteres")
    @Column(length = 500)
    private String observaciones;

    @PrePersist
    public void prePersist() {
        if (this.fechaIngreso == null) {
            this.fechaIngreso = new Date();
        }
    }
}
