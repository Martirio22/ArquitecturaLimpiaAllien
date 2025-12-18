package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Ubicacion")
public class UbicacionJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUbicacion;

	@Column(nullable = false)
	private int idCompraProducto;
	@Column(nullable = false)
	private int idVenta;
	@Column(nullable = false)
	private int idDetalleVenta;
	@Column(nullable = false)
	private int idMovimiento;
	@NotBlank(message = "Nombre es obligatorio")
	@Size(max = 75, message = "Nombre no debe exceder 75 caracteres")
	@Column(nullable = false, length = 75)
	private String nombre;
	@Column(nullable = false, length = 255)
	private String descripcion;
	@Column(nullable = false, length = 40)
	private String tipo;

}
