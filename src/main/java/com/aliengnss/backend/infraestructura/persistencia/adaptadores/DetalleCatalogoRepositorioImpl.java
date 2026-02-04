package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.DetalleCatalogo;
import com.aliengnss.backend.dominio.repositorios.IDetalleCatalogoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleCatalogoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IDetalleCatalogoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IDetalleCatalogoJpaRepository;

public class DetalleCatalogoRepositorioImpl implements IDetalleCatalogoRepositorio {

	private final IDetalleCatalogoJpaRepository detalleCatalogoJpaRepository;
	private final IDetalleCatalogoJpaMapper mapper;
	
	public DetalleCatalogoRepositorioImpl(IDetalleCatalogoJpaRepository detalleCatalogoJpaRepository,
			IDetalleCatalogoJpaMapper mapper) {
		super();
		this.detalleCatalogoJpaRepository = detalleCatalogoJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public DetalleCatalogo guardarDetalleCatalogo(DetalleCatalogo detalleCatalogo) {
		DetalleCatalogoJpa entity = mapper.toEntity(detalleCatalogo);
		DetalleCatalogoJpa guardar = detalleCatalogoJpaRepository.save(entity);
		return mapper.toDomain(guardar);
	}

	@Override
	public Optional<DetalleCatalogo> buscarDetalleCatalogoPorId(Long idDetalleCatalogo) {
		return detalleCatalogoJpaRepository.findById(idDetalleCatalogo).map(mapper::toDomain);
	}

	@Override
	public List<DetalleCatalogo> listarDetalleCatalogos() {
		return detalleCatalogoJpaRepository.findAll().stream().map(mapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idDetalleCatalogo) {
		detalleCatalogoJpaRepository.deleteById(idDetalleCatalogo);
	}

	@Override
	public List<DetalleCatalogo> listarDetallesPorNombreCatalogo(String nombreCatalogo) {
		return detalleCatalogoJpaRepository
	            .listarDetallesPorNombreCatalogo(nombreCatalogo)
	            .stream()
	            .map(mapper::toDomain)
	            .toList();
	}

}
