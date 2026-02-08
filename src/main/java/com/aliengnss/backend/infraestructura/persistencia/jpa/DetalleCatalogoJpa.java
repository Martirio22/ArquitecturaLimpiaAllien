package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DetalleCatalogo")
public class DetalleCatalogoJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCatalogo;

    private String codigoDetalle;
    private String descripcion;
    private double valorNumerico;
    private Long orden;
    private boolean esActivo;

    @Column(updatable = false, nullable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCatalogo", nullable = false)
    private CatalogoJpa catalogo;

    @PrePersist
    public void prePersist() {
      LocalDateTime now = LocalDateTime.now();
      this.fechaCreacion = now;
      this.fechaActualizacion = now;
    }

    @PreUpdate
    public void preUpdate() {
      this.fechaActualizacion = LocalDateTime.now();
    }
}
