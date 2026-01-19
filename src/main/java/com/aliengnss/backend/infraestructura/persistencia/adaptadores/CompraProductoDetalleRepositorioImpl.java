package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoDetalleJpaRepository;


public class CompraProductoDetalleRepositorioImpl implements ICompraProductoDetalleRepositorio {

    private final ICompraProductoDetalleJpaRepository repo;
    private final ICompraProductoDetalleJpaMapper mapper;

    public CompraProductoDetalleRepositorioImpl(ICompraProductoDetalleJpaRepository repo,
                                               ICompraProductoDetalleJpaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CompraProductoDetalle guardar(CompraProductoDetalle detalle) {
        CompraProductoDetalleJpa saved = repo.save(mapper.toEntity(detalle));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CompraProductoDetalle> buscarPorId(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<CompraProductoDetalle> listarTodos() {
        return repo.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<CompraProductoDetalle> buscarPorCompraProductoId(Long idCompraProducto) {
        return repo.findByFkCompraProducto_IdCompraProducto(idCompraProducto)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<CompraProductoDetalle> buscarPorCompraProductoIdYProductoId(Long idCompraProducto, Long idProducto) {
        return repo.findByFkCompraProducto_IdCompraProductoAndFkProducto_IdProducto(idCompraProducto, idProducto)
                .map(mapper::toDomain);
    }

    @Override
    public List<CompraProductoDetalle> buscarPorCompraProductoIdYCantidadMayor(Long idCompraProducto, int cantidad) {
        CompraProductoJpa compraRef = new CompraProductoJpa();
        compraRef.setIdCompraProducto(idCompraProducto);

        return repo.findByFkCompraProductoAndCantidadGreaterThan(compraRef, cantidad)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<CompraProductoDetalle> buscarPorCompraProductoIdYCostoEntre(Long idCompraProducto,
                                                                           BigDecimal min,
                                                                           BigDecimal max) {
        CompraProductoJpa compraRef = new CompraProductoJpa();
        compraRef.setIdCompraProducto(idCompraProducto);

        return repo.findByFkCompraProductoAndCostoUnitarioBetween(compraRef, min, max)
                .stream().map(mapper::toDomain).toList();
    }
}
