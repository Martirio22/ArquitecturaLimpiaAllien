package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoDetalleJpaRepository;

@Repository
public class MovimientoDetalleRepositorioImpl implements IMovimientoDetalleRepositorio {
	private final IMovimientoDetalleJpaRepository repositorioJpa;
	private final IMovimientoDetalleJpaMapper entityMapper;

	public MovimientoDetalleRepositorioImpl(IMovimientoDetalleJpaRepository repositorioJpa, IMovimientoDetalleJpaMapper entityMapper) {

		this.repositorioJpa = repositorioJpa;
		this.entityMapper = entityMapper;
	}

	@Override
	public MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle) {
		MovimientoDetalleJpa entity = entityMapper.toEntity(movimientoDetalle);
		MovimientoDetalleJpa guardado = repositorioJpa.save(entity);

		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<MovimientoDetalle> buscarPorId(Long id) {

		return repositorioJpa.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<MovimientoDetalle> listarTodos() {
		// TODO Auto-generated method stub
		return repositorioJpa.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long id) {
		repositorioJpa.deleteById(id);

	}
}
