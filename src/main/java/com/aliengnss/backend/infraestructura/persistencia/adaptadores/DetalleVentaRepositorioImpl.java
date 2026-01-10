package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IDetalleVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IDetalleVentaJpaRepository;

import java.util.List;
import java.util.Optional;

public class DetalleVentaRepositorioImpl implements IDetalleVentaRepositorio {

    private final IDetalleVentaJpaRepository detalleVentaJpaRepository;
    private final IDetalleVentaJpaMapper mapper;

    public DetalleVentaRepositorioImpl(IDetalleVentaJpaRepository detalleVentaJpaRepository, IDetalleVentaJpaMapper mapper) {
        this.detalleVentaJpaRepository = detalleVentaJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        DetalleVentaJpa entity = mapper.toEntity(detalleVenta);
        DetalleVentaJpa guardar = detalleVentaJpaRepository.save(entity);
        return mapper.toDomain(guardar);
    }

    @Override
    public Optional<DetalleVenta> buscarPorId(Long idDetalleVenta) {
        return detalleVentaJpaRepository.findById(idDetalleVenta).map(mapper::toDomain);
    }

    @Override
    public List<DetalleVenta> listarTodos() {
        return detalleVentaJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idDetalleVenta) {
        detalleVentaJpaRepository.deleteById(idDetalleVenta);
    }
}
