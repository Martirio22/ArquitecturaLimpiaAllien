package com.aliengnss.backend.presentacion.dto.res;

import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Usuario;

import lombok.Data;

@Data
public class CompraProductoResponseDTO {

	private Long idCompraProducto;
    private LocalDateTime fechaIngreso;
    private String observaciones;
    
    private Usuario fkUsuario;
}
