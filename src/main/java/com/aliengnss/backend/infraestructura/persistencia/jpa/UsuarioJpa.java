package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(
        name = "Usuario"
)
public class UsuarioJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Min(value = 0, message = "idCompraProducto no puede ser negativo")
    private int idCompraProducto;

    @Min(value = 0, message = "idVenta no puede ser negativo")
    private int idVenta;

    @Min(value = 0, message = "idMovimiento no puede ser negativo")
    private int idMovimiento;

    @NotBlank(message = "primerNombre es obligatorio")
    @Size(max = 60, message = "primerNombre no debe exceder 60 caracteres")
    @Column(nullable = false, length = 60)
    private String primerNombre;

    @Size(max = 60, message = "segundoNombre no debe exceder 60 caracteres")
    @Column(length = 60)
    private String segundoNombre;

    @NotBlank(message = "primerApellido es obligatorio")
    @Size(max = 60, message = "primerApellido no debe exceder 60 caracteres")
    @Column(nullable = false, length = 60)
    private String primerApellido;

    @Size(max = 60, message = "segundoApellido no debe exceder 60 caracteres")
    @Column(length = 60)
    private String segundoApellido;

    @NotBlank(message = "nombreUsuario es obligatorio")
    @Size(min = 3, max = 30, message = "nombreUsuario debe tener entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$", message = "nombreUsuario solo permite letras, números, punto, guion y guion bajo")
    @Column(nullable = false, length = 30)
    private String nombreUsuario;

    @NotBlank(message = "rol es obligatorio")
    @Size(max = 30, message = "rol no debe exceder 30 caracteres")
    @Column(nullable = false, length = 30)
    private String rol;

    @NotNull(message = "esActivo es obligatorio")
    @Column(nullable = false)
    private Boolean esActivo;

    @PrePersist
    public void prePersist() {
        if (esActivo == null) esActivo = true;
        if (nombreUsuario != null) nombreUsuario = nombreUsuario.trim();
    }
}
