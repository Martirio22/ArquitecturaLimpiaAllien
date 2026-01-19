package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;

public interface IMovimientoSeriesUseCase {

    MovimientoDetalleSerial guardar(MovimientoDetalleSerial entity);
    MovimientoDetalleSerial buscarPorId(Long idMovimientoDetalleSerial);
    List<MovimientoDetalleSerial> listarTodos();
    void eliminar(Long idMovimientoDetalleSerial);

    List<MovimientoDetalleSerial> buscarPorMovimientoDetalleId(Long idMovimientoDetalle);
    List<MovimientoDetalleSerial> buscarPorProductoSerialId(Long idProductoSerial);

    MovimientoDetalleSerial buscarPorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial);

    boolean existePorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial);

    long eliminarPorMovimientoDetalleId(Long idMovimientoDetalle);

    long contarPorMovimientoDetalleId(Long idMovimientoDetalle);
    long contarPorProductoSerialId(Long idProductoSerial);
}
