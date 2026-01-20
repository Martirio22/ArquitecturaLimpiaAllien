package com.aliengnss.backend.aplicacion.casosuso.entrada;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;

import java.time.LocalDateTime;
import java.util.List;

public interface IDetalleVentaUseCase {
    DetalleVenta guardar(DetalleVenta detalleVenta);
    DetalleVenta buscarPorId(Long idDetalleVenta);
    List<DetalleVenta> listarTodos();
    void eliminar(Long idDetalleVenta);
    
    List<DetalleVenta> ventasPorProductoUbicacionYFecha(
	        Long idProducto,
	        Long idUbicacion,
	        LocalDateTime fechaInicio,
	        LocalDateTime fechaFin);
}
