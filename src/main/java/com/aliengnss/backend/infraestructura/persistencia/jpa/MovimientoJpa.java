package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Movimiento")
public class MovimientoJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;
	private LocalDateTime fechaMovimiento;
	private String tipo;
	private String observaciones;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private UsuarioJpa fkUsuario;
	@ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "idUbicacionOrigen")
    private UbicacionJpa fkUbicacionOrigen;

	@ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "idUbicacionDestino")
    private UbicacionJpa fkUbicacionDestino;
	
}