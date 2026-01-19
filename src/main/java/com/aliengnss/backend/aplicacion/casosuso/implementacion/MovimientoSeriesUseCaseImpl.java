package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;

@Service
@Transactional
public class MovimientoSeriesUseCaseImpl implements IMovimientoSeriesUseCase {

    private final IMovimientoSeriesRepositorio repo;

    public MovimientoSeriesUseCaseImpl(IMovimientoSeriesRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public MovimientoDetalleSerial guardar(MovimientoDetalleSerial entity) {
        return repo.guardar(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDetalleSerial buscarPorId(Long idMovimientoDetalleSerial) {
        return repo.buscarPorId(idMovimientoDetalleSerial)
                .orElseThrow(() -> new RuntimeException("MovimientoSeries no encontrado: " + idMovimientoDetalleSerial));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalleSerial> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long idMovimientoDetalleSerial) {
        repo.eliminar(idMovimientoDetalleSerial);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalleSerial> buscarPorMovimientoDetalleId(Long idMovimientoDetalle) {
        return repo.buscarPorMovimientoDetalleId(idMovimientoDetalle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalleSerial> buscarPorProductoSerialId(Long idProductoSerial) {
        return repo.buscarPorProductoSerialId(idProductoSerial);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDetalleSerial buscarPorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial) {
        return repo.buscarPorMovimientoDetalleIdYProductoSerialId(idMovimientoDetalle, idProductoSerial)
                .orElseThrow(() -> new RuntimeException("No encontrado para movimientoDetalle/productoSerial"));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial) {
        return repo.existePorMovimientoDetalleIdYProductoSerialId(idMovimientoDetalle, idProductoSerial);
    }

    @Override
    public long eliminarPorMovimientoDetalleId(Long idMovimientoDetalle) {
        return repo.eliminarPorMovimientoDetalleId(idMovimientoDetalle);
    }

    @Override
    @Transactional(readOnly = true)
    public long contarPorMovimientoDetalleId(Long idMovimientoDetalle) {
        return repo.contarPorMovimientoDetalleId(idMovimientoDetalle);
    }

    @Override
    @Transactional(readOnly = true)
    public long contarPorProductoSerialId(Long idProductoSerial) {
        return repo.contarPorProductoSerialId(idProductoSerial);
    }
}
