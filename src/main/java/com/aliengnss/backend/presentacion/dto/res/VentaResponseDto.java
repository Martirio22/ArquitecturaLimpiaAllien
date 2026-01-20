package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.entidades.Usuario;

@Data
public class VentaResponseDto {
	private Long idVenta;
    private String numeroFactura;
    private LocalDateTime fechaVenta;
    private BigDecimal total;
    private String observaciones;
    
    private Cliente fkCliente;
    private Usuario fkUsuario;
}
