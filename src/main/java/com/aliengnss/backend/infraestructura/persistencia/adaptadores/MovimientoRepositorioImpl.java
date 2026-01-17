package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoJpaMapper;

import com.aliengnss.backend.infraestructura.repositorios.IMovimientoJpaRepository;

public class MovimientoRepositorioImpl implements IMovimientoRepositorio {
	private final IMovimientoJpaRepository repositorioJpa;
	private final IMovimientoJpaMapper entityMapper;

	public MovimientoRepositorioImpl(IMovimientoJpaRepository repositorioJpa, IMovimientoJpaMapper entityMapper) {

		this.repositorioJpa = repositorioJpa;
		this.entityMapper = entityMapper;
	}

	@Override
	public Movimiento guardar(Movimiento movimiento) {
		MovimientoJpa entity = entityMapper.toEntity(movimiento);
		MovimientoJpa guardado = repositorioJpa.save(entity);

		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Movimiento> buscarPorId(Long id) {

		return repositorioJpa.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Movimiento> listarTodos() {
		// TODO Auto-generated method stub
		return repositorioJpa.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long id) {
		repositorioJpa.deleteById(id);

	}
}
