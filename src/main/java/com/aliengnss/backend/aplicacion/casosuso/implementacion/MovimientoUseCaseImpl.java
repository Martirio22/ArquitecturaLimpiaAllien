package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;

@Service
@Transactional
public class MovimientoUseCaseImpl implements IMovimientoUseCase {

    private final IMovimientoRepositorio repo;

    public MovimientoUseCaseImpl(IMovimientoRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public Movimiento guardar(Movimiento movimiento) {
        return repo.guardar(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento buscarPorId(Long idMovimiento) {
        return repo.buscarPorId(idMovimiento)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado: " + idMovimiento));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long idMovimiento) {
        repo.eliminar(idMovimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorTipo(String tipo) {
        return repo.buscarPorTipo(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorUsuarioId(Long idUsuario) {
        return repo.buscarPorUsuarioId(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorRangoFechas(desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorTipoYRangoFechas(String tipo, LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorTipoYRangoFechas(tipo, desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorUsuarioIdYRangoFechas(idUsuario, desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorUbicacionOrigenId(Long idUbicacionOrigen) {
        return repo.buscarPorUbicacionOrigenId(idUbicacionOrigen);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorUbicacionDestinoId(Long idUbicacionDestino) {
        return repo.buscarPorUbicacionDestinoId(idUbicacionDestino);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorUbicacionOrigenIdYDestinoId(Long idUbicacionOrigen, Long idUbicacionDestino) {
        return repo.buscarPorUbicacionOrigenIdYDestinoId(idUbicacionOrigen, idUbicacionDestino);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorObservaciones(String texto) {
        return repo.buscarPorObservaciones(texto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarPorUsuarioIdTipoYRangoFechas(Long idUsuario, String tipo, LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorUsuarioIdTipoYRangoFechas(idUsuario, tipo, desde, hasta);
    }
}
