package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Venta")

public class VentaJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta;
    private String numeroFactura;
    private LocalDateTime fechaVenta;
    private BigDecimal total;
    private String observaciones;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteJpa fkCliente;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioJpa fkUsuario;
}
