package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.dominio.repositorios.IInventarioMovimientoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.InventarioMovimientoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IInventarioMovimientoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IInventarioMovimientoJpaRepository;

public class InventarioMovimientoRepositorioImpl implements IInventarioMovimientoRepositorio {
	
	private final IInventarioMovimientoJpaRepository cpJpaRepository;
	private final IInventarioMovimientoJpaMapper entityMapper;

	public InventarioMovimientoRepositorioImpl(IInventarioMovimientoJpaRepository cpJpaRepository,
			IInventarioMovimientoJpaMapper entityMapper) {
		super();
		this.cpJpaRepository = cpJpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public InventarioMovimiento guardar(InventarioMovimiento inventarioMovimiento) {
		InventarioMovimientoJpa entity = entityMapper.toEntity(inventarioMovimiento);
		InventarioMovimientoJpa guardado = cpJpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<InventarioMovimiento> buscarPorId(Long idInventarioMovimiento) {
		return cpJpaRepository.findById(idInventarioMovimiento).map(entityMapper::toDomain);
	}

	@Override
	public List<InventarioMovimiento> listarTodos() {
		return cpJpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idInventarioMovimiento) {
		cpJpaRepository.deleteById(idInventarioMovimiento);
		
	}

}
