package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoSeriesJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoSeriesJpaRepository;

public class MovimientoSeriesRepositorioImpl implements IMovimientoSeriesRepositorio {

    private final IMovimientoSeriesJpaRepository repoJpa;
    private final IMovimientoSeriesJpaMapper mapper;

    public MovimientoSeriesRepositorioImpl(IMovimientoSeriesJpaRepository repoJpa,
                                          IMovimientoSeriesJpaMapper mapper) {
        this.repoJpa = repoJpa;
        this.mapper = mapper;
    }

    @Override
    public MovimientoDetalleSerial guardar(MovimientoDetalleSerial entity) {
        MovimientoDetalleSerialJpa saved = repoJpa.save(mapper.toEntity(entity));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MovimientoDetalleSerial> buscarPorId(Long idMovimientoDetalleSerial) {
        return repoJpa.findById(idMovimientoDetalleSerial).map(mapper::toDomain);
    }

    @Override
    public List<MovimientoDetalleSerial> listarTodos() {
        return repoJpa.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idMovimientoDetalleSerial) {
        repoJpa.deleteById(idMovimientoDetalleSerial);
    }

}
