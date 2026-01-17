package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Usuario;

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
    private LocalDateTime fechaIngreso;
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioJpa fkUsuario;

    
    
    
    
    
    
}
