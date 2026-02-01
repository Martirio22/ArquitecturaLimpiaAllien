package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleRepositorio {
    MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);
    
    // ✅ Agrega este método para manejar la lista de productos
    List<MovimientoDetalle> guardarTodo(List<MovimientoDetalle> detalles);
    List<MovimientoDetalle> buscarPorMovimiento(Long idMovimiento);

    Optional<MovimientoDetalle> buscarPorId(Long idMovimientoDetalle);
    List<MovimientoDetalle> listarTodos();
    void eliminar(Long idMovimientoDetalle);
}
