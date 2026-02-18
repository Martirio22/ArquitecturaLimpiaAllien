package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import com.aliengnss.backend.dominio.entidades.Producto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductoSerial")

public class ProductoSerialJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProductoSerial;
	private String serial;
	private String estado;
	
	@ManyToOne
    @JoinColumn(name = "idProducto")
    private ProductoJpa fkProducto;

}
