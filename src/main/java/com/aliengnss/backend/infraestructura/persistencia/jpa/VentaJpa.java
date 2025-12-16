package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Venta")

public class VentaJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

	@Size(max = 50, message = "el número de factura no puede exceder 50caracteres")
    @Column(length = 50, nullable = false)
    private String numeroFactura;
	
	@NotNull(message = "fechaVenta es obligatoria")
    @PastOrPresent(message = "fechaVenta no puede ser futura")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
    private Date fechaVenta;

	@NotNull(message = "idCliente es obligatorio")
    @Positive(message = "idCliente debe ser mayor que 0")
    @Column(nullable = false)
    private Integer idCliente;
	
	@NotNull(message = "idUsuario es obligatorio")
    @Positive(message = "idUsuario debe ser mayor que 0")
    @Column(nullable = false)
    private Integer idUsuario;
	
	@NotNull(message = "idUbicacion es obligatorio")
    @Positive(message = "idUbicacion debe ser mayor que 0")
    @Column(nullable = false)
    private Integer idUbicacion;

    @Column(precision = 14, scale = 2, nullable = false)
    private BigDecimal total;

    @Size(max = 500, message = "observaciones no puede exceder 500 caracteres")
    @Column(length = 500)
    private String observaciones;
    
    @PrePersist
    public void prePersist() {
        if (this.fechaVenta == null) {
            this.fechaVenta = new Date();
        }
    }
}
