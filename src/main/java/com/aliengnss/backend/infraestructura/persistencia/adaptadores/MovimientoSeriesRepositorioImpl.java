package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoSeries;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoSeriesJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoSeriesJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoSeriesJpaRepository;

public class MovimientoSeriesRepositorioImpl implements IMovimientoSeriesRepositorio {
	
	private final IMovimientoSeriesJpaRepository movimientoSeriesJpaRepository;
	private final IMovimientoSeriesJpaMapper mapper;
	
	public MovimientoSeriesRepositorioImpl(IMovimientoSeriesJpaRepository movimientoSeriesJpaRepository,
			IMovimientoSeriesJpaMapper mapper) {
		this.movimientoSeriesJpaRepository = movimientoSeriesJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public MovimientoSeries guardar(MovimientoSeries movimientoSeries) {
		MovimientoSeriesJpa entity = mapper.toEntity(movimientoSeries);
		MovimientoSeriesJpa guardar = movimientoSeriesJpaRepository.save(entity);
		return mapper.toDomain(guardar);
	}

	@Override
	public Optional<MovimientoSeries> buscarPorId(Long idMovimientoSeries) {
		return movimientoSeriesJpaRepository.findById(idMovimientoSeries).map(mapper::toDomain);
	}

	@Override
	public List<MovimientoSeries> listarTodos() {
		return movimientoSeriesJpaRepository.findAll().stream().map(mapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idMovimientoSeries) {
		movimientoSeriesJpaRepository.deleteById(idMovimientoSeries);
	}

}
