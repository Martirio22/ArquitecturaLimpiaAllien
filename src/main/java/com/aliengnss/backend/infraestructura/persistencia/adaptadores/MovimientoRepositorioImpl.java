package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoJpaRepository;

public class MovimientoRepositorioImpl implements IMovimientoRepositorio {

    private final IMovimientoJpaRepository repoJpa;
    private final IMovimientoJpaMapper mapper;

    public MovimientoRepositorioImpl(IMovimientoJpaRepository repoJpa, IMovimientoJpaMapper mapper) {
        this.repoJpa = repoJpa;
        this.mapper = mapper;
    }

    @Override
    public Movimiento guardar(Movimiento movimiento) {
        MovimientoJpa saved = repoJpa.save(mapper.toEntity(movimiento));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Movimiento> buscarPorId(Long idMovimiento) {
        return repoJpa.findById(idMovimiento).map(mapper::toDomain);
    }

    @Override
    public List<Movimiento> listarTodos() {
        return repoJpa.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idMovimiento) {
        repoJpa.deleteById(idMovimiento);
    }

    @Override
    public List<Movimiento> buscarPorTipo(String tipo) {
        return repoJpa.findByTipo(tipo).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorUsuarioId(Long idUsuario) {
        UsuarioJpa userRef = new UsuarioJpa();
        userRef.setIdUsuario(idUsuario);
        return repoJpa.findByFkUsuario(userRef).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta) {
        return repoJpa.findByFechaMovimientoBetween(desde, hasta).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorTipoYRangoFechas(String tipo, LocalDateTime desde, LocalDateTime hasta) {
        return repoJpa.findByTipoAndFechaMovimientoBetween(tipo, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        UsuarioJpa userRef = new UsuarioJpa();
        userRef.setIdUsuario(idUsuario);

        return repoJpa.findByFkUsuarioAndFechaMovimientoBetween(userRef, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorUbicacionOrigenId(Long idUbicacionOrigen) {
        UbicacionJpa ubiRef = new UbicacionJpa();
        ubiRef.setIdUbicacion(idUbicacionOrigen);

        return repoJpa.findByFkUbicacionOrigen(ubiRef).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorUbicacionDestinoId(Long idUbicacionDestino) {
        UbicacionJpa ubiRef = new UbicacionJpa();
        ubiRef.setIdUbicacion(idUbicacionDestino);

        return repoJpa.findByFkUbicacionDestino(ubiRef).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorUbicacionOrigenIdYDestinoId(Long idUbicacionOrigen, Long idUbicacionDestino) {
        UbicacionJpa origenRef = new UbicacionJpa();
        origenRef.setIdUbicacion(idUbicacionOrigen);

        UbicacionJpa destinoRef = new UbicacionJpa();
        destinoRef.setIdUbicacion(idUbicacionDestino);

        return repoJpa.findByFkUbicacionOrigenAndFkUbicacionDestino(origenRef, destinoRef)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorObservaciones(String texto) {
        return repoJpa.findByObservacionesContainingIgnoreCase(texto)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Movimiento> buscarPorUsuarioIdTipoYRangoFechas(Long idUsuario, String tipo, LocalDateTime desde, LocalDateTime hasta) {
        UsuarioJpa userRef = new UsuarioJpa();
        userRef.setIdUsuario(idUsuario);

        return repoJpa.findByFkUsuarioAndTipoAndFechaMovimientoBetween(userRef, tipo, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }
}
