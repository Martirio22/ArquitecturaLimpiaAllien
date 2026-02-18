package com.aliengnss.backend.presentacion.dto.req;

import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.Ubicacion;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CompraProductoDetalleRequestDTO {
	
	@Null
	private Long idCompraProductoDetalle;
	@NotNull
    private int cantidad;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal costoUnitario;
    
    @NotNull
    private CompraProducto fkCompraProducto;
    @NotNull
    private Producto fkProducto;
    @NotNull
    private Ubicacion fkUbicacion;
}
