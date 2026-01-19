package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

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

    
}
