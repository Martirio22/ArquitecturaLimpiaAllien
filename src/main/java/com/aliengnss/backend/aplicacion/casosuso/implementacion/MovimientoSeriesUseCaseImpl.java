package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;


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

}
