package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleRepositorio {

    MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);
    Optional<MovimientoDetalle> buscarPorId(Long idMovimientoDetalle);
    List<MovimientoDetalle> listarTodos();
    void eliminar(Long idMovimientoDetalle);

    // Búsquedas equivalentes al JPA repo (sin depender de JPA)
    List<MovimientoDetalle> buscarPorMovimientoId(Long idMovimiento);
    List<MovimientoDetalle> buscarPorProductoId(Long idProducto);

    Optional<MovimientoDetalle> buscarPorMovimientoIdYProductoId(Long idMovimiento, Long idProducto);

    boolean existePorMovimientoIdYProductoId(Long idMovimiento, Long idProducto);

    long contarPorMovimientoId(Long idMovimiento);
    long contarPorProductoId(Long idProducto);

    List<MovimientoDetalle> buscarPorMovimientoIdYCantidadMayorQue(Long idMovimiento, int cantidad);

    List<MovimientoDetalle> buscarPorMovimientoIdYCantidadEntre(Long idMovimiento, int min, int max);
}
