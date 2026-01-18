package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoJpaRepository;

public class CompraProductoRepositorioImpl implements ICompraProductoRepositorio{

	private final ICompraProductoJpaRepository cpJpaRepository;
	private final ICompraProductoJpaMapper entityMapper;
	
	
	
	public CompraProductoRepositorioImpl(ICompraProductoJpaRepository cpJpaRepository,
			ICompraProductoJpaMapper entityMapper) {
		
		this.cpJpaRepository = cpJpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public CompraProducto guardar(CompraProducto compraproducto) {
		CompraProductoJpa entity = entityMapper.toEntity(compraproducto);
		CompraProductoJpa guardado = cpJpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<CompraProducto> buscarPorId(Long idCompraProducto) {
		return cpJpaRepository.findById(idCompraProducto).map(entityMapper::toDomain);
	}

	@Override
	public List<CompraProducto> listarTodos() {
		return cpJpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idCompraProducto) {
		cpJpaRepository.deleteById(idCompraProducto);
		
	}

}
