package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;

public interface IMovimientoSeriesRepositorio {

    MovimientoDetalleSerial guardar(MovimientoDetalleSerial entity);
    Optional<MovimientoDetalleSerial> buscarPorId(Long idMovimientoDetalleSerial);
    List<MovimientoDetalleSerial> listarTodos();
    void eliminar(Long idMovimientoDetalleSerial);

    // Consultas (equivalentes al JPA repo, usando IDs para no depender de JPA)
    List<MovimientoDetalleSerial> buscarPorMovimientoDetalleId(Long idMovimientoDetalle);
    List<MovimientoDetalleSerial> buscarPorProductoSerialId(Long idProductoSerial);

    Optional<MovimientoDetalleSerial> buscarPorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial);

    boolean existePorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial);

    long eliminarPorMovimientoDetalleId(Long idMovimientoDetalle);

    long contarPorMovimientoDetalleId(Long idMovimientoDetalle);
    long contarPorProductoSerialId(Long idProductoSerial);
}
