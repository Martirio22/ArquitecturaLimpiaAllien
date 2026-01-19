package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoSerialJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoSeriesJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoSeriesJpaRepository;

@Repository
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

    @Override
    public List<MovimientoDetalleSerial> buscarPorMovimientoDetalleId(Long idMovimientoDetalle) {
        return repoJpa.findByFkMovimientoDetalle_IdMovimientoDetalle(idMovimientoDetalle)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<MovimientoDetalleSerial> buscarPorProductoSerialId(Long idProductoSerial) {
        return repoJpa.findByFkProductoSerial_IdProductoSerial(idProductoSerial)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<MovimientoDetalleSerial> buscarPorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle,
                                                                                          Long idProductoSerial) {
        return repoJpa.findByFkMovimientoDetalle_IdMovimientoDetalleAndFkProductoSerial_IdProductoSerial(
                idMovimientoDetalle, idProductoSerial
        ).map(mapper::toDomain);
    }

    @Override
    public boolean existePorMovimientoDetalleIdYProductoSerialId(Long idMovimientoDetalle, Long idProductoSerial) {
        // Tu JPA repo tiene exists() por entidades, así que construimos refs
        MovimientoDetalleJpa movDetRef = new MovimientoDetalleJpa();
        movDetRef.setIdMovimientoDetalle(idMovimientoDetalle);

        ProductoSerialJpa serialRef = new ProductoSerialJpa();
        serialRef.setIdProductoSerial(idProductoSerial);

        return repoJpa.existsByFkMovimientoDetalleAndFkProductoSerial(movDetRef, serialRef);
    }

    @Override
    public long eliminarPorMovimientoDetalleId(Long idMovimientoDetalle) {
        MovimientoDetalleJpa movDetRef = new MovimientoDetalleJpa();
        movDetRef.setIdMovimientoDetalle(idMovimientoDetalle);
        return repoJpa.deleteByFkMovimientoDetalle(movDetRef);
    }

    @Override
    public long contarPorMovimientoDetalleId(Long idMovimientoDetalle) {
        MovimientoDetalleJpa movDetRef = new MovimientoDetalleJpa();
        movDetRef.setIdMovimientoDetalle(idMovimientoDetalle);
        return repoJpa.countByFkMovimientoDetalle(movDetRef);
    }

    @Override
    public long contarPorProductoSerialId(Long idProductoSerial) {
        ProductoSerialJpa serialRef = new ProductoSerialJpa();
        serialRef.setIdProductoSerial(idProductoSerial);
        return repoJpa.countByFkProductoSerial(serialRef);
    }
}
