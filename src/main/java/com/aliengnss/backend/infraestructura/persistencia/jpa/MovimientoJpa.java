package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
@Entity
@Table(name = "Movimiento")
public class MovimientoJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Column(nullable = false)
    private int idCompraProducto;

    @NotNull(message = "fechaMovimiento es obligatoria")
    @PastOrPresent(message = "fechaMovimiento no puede ser futura")
    @Column(nullable = false)
    private LocalDateTime fechaMovimiento;

    @Column(nullable = false)
    private int idUsuario;

    @Column(nullable = false)
    private int idUbicacionOrigen;

    @Column(nullable = false)
    private int idUbicacionDestino;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 255)
    private String observaciones;

    @PrePersist
    public void prePersist() {
        if (this.fechaMovimiento == null) {
            this.fechaMovimiento = LocalDateTime.now();
        }
    }
}