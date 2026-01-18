package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreUsuario;
    private String correoElectronico;
    private String cedula;
    private String clave;
    private int intentosActual;
    private Date ultimoAcceso;
    private String rol;
    private Boolean esActivo;
}
