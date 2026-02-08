package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
    name = "Producto",
    uniqueConstraints = {
        @UniqueConstraint(name="uk_producto_nombre_marca_tipo", columnNames = {"nombre","marca","tipo"})
    }
)
public class ProductoJpa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private String marca;
    private String tipo;
    private String foto;
    private String descripcion;

    private Boolean esConSerial;
    private BigDecimal porcentajeComision;
    private LocalDateTime fechaCreacion;
    private Boolean esActivo;
}