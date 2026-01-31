package com.aliengnss.backend.presentacion.dto.res;

import java.time.LocalDateTime;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.entidades.Usuario;

import lombok.Data;

@Data
public class MovimientoResponseDto {
    private Long idMovimiento;
    private LocalDateTime fechaMovimiento;
    private String tipo;
    private String observaciones;
    private Usuario fkUsuario;
    private Long idUbicacionOrigen;
    private Long idUbicacionDestino;
    
    // ✅ Agregar esta lista para devolver los productos guardados
    private List<MovimientoDetalle> detalles; 
}