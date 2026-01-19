package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;

public interface IMovimientoDetalleUseCase {

    MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle);
    MovimientoDetalle buscarPorId(Long idMovimientoDetalle);
    List<MovimientoDetalle> listarTodos();
    void eliminar(Long idMovimientoDetalle);

    List<MovimientoDetalle> buscarPorMovimientoId(Long idMovimiento);
    List<MovimientoDetalle> buscarPorProductoId(Long idProducto);

    MovimientoDetalle buscarPorMovimientoIdYProductoId(Long idMovimiento, Long idProducto);

    boolean existePorMovimientoIdYProductoId(Long idMovimiento, Long idProducto);

    long contarPorMovimientoId(Long idMovimiento);
    long contarPorProductoId(Long idProducto);

    List<MovimientoDetalle> buscarPorMovimientoIdYCantidadMayorQue(Long idMovimiento, int cantidad);
    List<MovimientoDetalle> buscarPorMovimientoIdYCantidadEntre(Long idMovimiento, int min, int max);
}
