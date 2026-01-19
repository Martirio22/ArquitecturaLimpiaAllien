package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoDetalleJpaRepository;

@Repository
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

    @Override
    public List<MovimientoDetalle> buscarPorMovimientoId(Long idMovimiento) {
        // Reutiliza tu método por id (no necesitas construir MovimientoJpa)
        return repoJpa.findByFkMovimiento_IdMovimiento(idMovimiento)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<MovimientoDetalle> buscarPorProductoId(Long idProducto) {
        // No tienes método por idProducto directo en tu repo JPA, así que creamos un "ref"
        ProductoJpa productoRef = new ProductoJpa();
        productoRef.setIdProducto(idProducto);

        return repoJpa.findByFkProducto(productoRef)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<MovimientoDetalle> buscarPorMovimientoIdYProductoId(Long idMovimiento, Long idProducto) {
        return repoJpa.findByFkMovimiento_IdMovimientoAndFkProducto_IdProducto(idMovimiento, idProducto)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existePorMovimientoIdYProductoId(Long idMovimiento, Long idProducto) {
        // No existe método por ids en JPA repo, usamos el "ref"
        MovimientoJpa movRef = new MovimientoJpa();
        movRef.setIdMovimiento(idMovimiento);

        ProductoJpa prodRef = new ProductoJpa();
        prodRef.setIdProducto(idProducto);

        return repoJpa.existsByFkMovimientoAndFkProducto(movRef, prodRef);
    }

    @Override
    public long contarPorMovimientoId(Long idMovimiento) {
        MovimientoJpa movRef = new MovimientoJpa();
        movRef.setIdMovimiento(idMovimiento);
        return repoJpa.countByFkMovimiento(movRef);
    }

    @Override
    public long contarPorProductoId(Long idProducto) {
        ProductoJpa prodRef = new ProductoJpa();
        prodRef.setIdProducto(idProducto);
        return repoJpa.countByFkProducto(prodRef);
    }

    @Override
    public List<MovimientoDetalle> buscarPorMovimientoIdYCantidadMayorQue(Long idMovimiento, int cantidad) {
        MovimientoJpa movRef = new MovimientoJpa();
        movRef.setIdMovimiento(idMovimiento);

        return repoJpa.findByFkMovimientoAndCantidadGreaterThan(movRef, cantidad)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<MovimientoDetalle> buscarPorMovimientoIdYCantidadEntre(Long idMovimiento, int min, int max) {
        MovimientoJpa movRef = new MovimientoJpa();
        movRef.setIdMovimiento(idMovimiento);

        return repoJpa.findByFkMovimientoAndCantidadBetween(movRef, min, max)
                .stream().map(mapper::toDomain).toList();
    }
}
