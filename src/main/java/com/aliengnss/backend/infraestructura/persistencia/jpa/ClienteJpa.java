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
@Table(name = "Cliente")

public class ClienteJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;



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

	@NotBlank(message = "documento es obligatorio")
	@Size(max = 60, message = "documento no debe exceder 20 caracteres")
	@Column(nullable = false, length = 20)
    private String documento;

	@NotBlank(message = "telefono es obligatorio")
    @Size(max = 15, message = "rol no debe exceder 15 caracteres")
    @Column(nullable = false, length = 15)
    private String telefono;

	@NotBlank(message = "mail es obligatorio")
    @Size(max = 255, message = "rol no debe exceder 255 caracteres")
    @Column(nullable = false, length = 255)
    private String email;

	@NotBlank(message = "direccion es obligatorio")
    @Size(max = 255, message = "rol no debe exceder 255 caracteres")
    @Column(nullable = false, length = 255)
    private String direccion;
}
