package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;

@Service
@Transactional
public class MovimientoDetalleUseCaseImpl implements IMovimientoDetalleUseCase {

    private final IMovimientoDetalleRepositorio repo;

    public MovimientoDetalleUseCaseImpl(IMovimientoDetalleRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle) {
        return repo.guardar(movimientoDetalle);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDetalle buscarPorId(Long idMovimientoDetalle) {
        return repo.buscarPorId(idMovimientoDetalle)
                .orElseThrow(() -> new RuntimeException("MovimientoDetalle no encontrado: " + idMovimientoDetalle));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalle> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long idMovimientoDetalle) {
        repo.eliminar(idMovimientoDetalle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalle> buscarPorMovimientoId(Long idMovimiento) {
        return repo.buscarPorMovimientoId(idMovimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalle> buscarPorProductoId(Long idProducto) {
        return repo.buscarPorProductoId(idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDetalle buscarPorMovimientoIdYProductoId(Long idMovimiento, Long idProducto) {
        return repo.buscarPorMovimientoIdYProductoId(idMovimiento, idProducto)
                .orElseThrow(() -> new RuntimeException("MovimientoDetalle no encontrado para movimiento/producto"));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorMovimientoIdYProductoId(Long idMovimiento, Long idProducto) {
        return repo.existePorMovimientoIdYProductoId(idMovimiento, idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public long contarPorMovimientoId(Long idMovimiento) {
        return repo.contarPorMovimientoId(idMovimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public long contarPorProductoId(Long idProducto) {
        return repo.contarPorProductoId(idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalle> buscarPorMovimientoIdYCantidadMayorQue(Long idMovimiento, int cantidad) {
        return repo.buscarPorMovimientoIdYCantidadMayorQue(idMovimiento, cantidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalle> buscarPorMovimientoIdYCantidadEntre(Long idMovimiento, int min, int max) {
        return repo.buscarPorMovimientoIdYCantidadEntre(idMovimiento, min, max);
    }
}
