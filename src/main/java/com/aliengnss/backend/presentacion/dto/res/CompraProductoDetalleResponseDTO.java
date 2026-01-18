package com.aliengnss.backend.presentacion.dto.res;

import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.Ubicacion;

import lombok.Data;

@Data
public class CompraProductoDetalleResponseDTO {

	private Long idCompraProductoDetalle;
    private int cantidad;
    private BigDecimal costoUnitario;
    
    private CompraProducto fkCompraProducto;
    private Producto fkProducto;
    private Ubicacion fkUbicacion;
}
