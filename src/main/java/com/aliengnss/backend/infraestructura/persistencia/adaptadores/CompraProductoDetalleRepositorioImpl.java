package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoDetalleJpaRepository;

public class CompraProductoDetalleRepositorioImpl implements ICompraProductoDetalleRepositorio{

	private final ICompraProductoDetalleJpaRepository cpdJpaRepository;
	private final ICompraProductoDetalleJpaMapper entityMapper;
	
	
	
	public CompraProductoDetalleRepositorioImpl(ICompraProductoDetalleJpaRepository cpdJpaRepository,
			ICompraProductoDetalleJpaMapper entityMapper) {
		
		this.cpdJpaRepository = cpdJpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public CompraProductoDetalle guardar(CompraProductoDetalle compraproductodetalle) {
		CompraProductoDetalleJpa entity = entityMapper.toEntity(compraproductodetalle);
		CompraProductoDetalleJpa guardado = cpdJpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<CompraProductoDetalle> buscarPorId(Long idCompraProductoDetalle) {
		return cpdJpaRepository.findById(idCompraProductoDetalle).map(entityMapper::toDomain);
	}

	@Override
	public List<CompraProductoDetalle> listarTodos() {
		return cpdJpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idCompraProductoDetalle) {
		cpdJpaRepository.deleteById(idCompraProductoDetalle);
		
	}

}
