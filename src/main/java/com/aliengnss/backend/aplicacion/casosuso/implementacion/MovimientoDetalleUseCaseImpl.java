package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;


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

    
}
