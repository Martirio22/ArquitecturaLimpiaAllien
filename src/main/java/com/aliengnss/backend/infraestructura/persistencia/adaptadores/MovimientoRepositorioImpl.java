package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;
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

    
}
