package com.aliengnss.backend.dominio.repositorios;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IDetalleVentaRepositorio {
    DetalleVenta guardar(DetalleVenta detalleVenta);
    Optional<DetalleVenta> buscarPorId(Long idDetalleVenta);
    List<DetalleVenta> listarTodos();
    void eliminar(Long idDetalleVenta);
    
    List<DetalleVenta> ventasPorProductoUbicacionYFecha(
	        Long idProducto,
	        Long idUbicacion,
	        LocalDateTime fechaInicio,
	        LocalDateTime fechaFin);
}
