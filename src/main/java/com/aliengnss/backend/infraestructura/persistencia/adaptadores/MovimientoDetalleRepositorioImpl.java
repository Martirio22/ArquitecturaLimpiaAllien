package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoDetalleJpaRepository;

public class MovimientoDetalleRepositorioImpl implements IMovimientoDetalleRepositorio {

    private final IMovimientoDetalleJpaRepository repoJpa;
    private final IMovimientoDetalleJpaMapper mapper;

    public MovimientoDetalleRepositorioImpl(IMovimientoDetalleJpaRepository repoJpa,
                                            IMovimientoDetalleJpaMapper mapper) {
        this.repoJpa = repoJpa;
        this.mapper = mapper;
    }

    @Override
    public MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle) {
        return mapper.toDomain(repoJpa.save(mapper.toEntity(movimientoDetalle)));
    }

    @Override
    public Optional<MovimientoDetalle> buscarPorId(Long idMovimientoDetalle) {
        return repoJpa.findById(idMovimientoDetalle).map(mapper::toDomain);
    }

    @Override
    public List<MovimientoDetalle> listarTodos() {
        return repoJpa.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idMovimientoDetalle) {
        repoJpa.deleteById(idMovimientoDetalle);
    }

    // nuevos
    @Override
    public List<MovimientoDetalle> movimientosDeProductoEnRango(Long idProducto, LocalDateTime inicio, LocalDateTime fin) {
        return repoJpa.movimientosDeProductoEnRango(idProducto, inicio, fin)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<MovimientoDetalle> movimientosDesdeUbicacionEnRango(Long idUbicacionOrigen, LocalDateTime inicio, LocalDateTime fin) {
        return repoJpa.movimientosDesdeUbicacionEnRango(idUbicacionOrigen, inicio, fin)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<MovimientoDetalle> movimientosHaciaUbicacionEnRango(Long idUbicacionDestino, LocalDateTime inicio, LocalDateTime fin) {
        return repoJpa.movimientosHaciaUbicacionEnRango(idUbicacionDestino, inicio, fin)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    // opcional
    @Override
    public List<MovimientoDetalle> detallesDeMovimiento(Long idMovimiento) {
        return repoJpa.detallesDeMovimiento(idMovimiento)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
    
}
