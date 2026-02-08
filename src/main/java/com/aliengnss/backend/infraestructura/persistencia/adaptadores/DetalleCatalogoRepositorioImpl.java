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

	  // UPDATE
	  if (detalleCatalogo.getIdDetalleCatalogo() != null) {

	    DetalleCatalogoJpa entity = detalleCatalogoJpaRepository
	        .findById(detalleCatalogo.getIdDetalleCatalogo())
	        .orElseThrow(() -> new RuntimeException("Detalle no encontrado: " + detalleCatalogo.getIdDetalleCatalogo()));

	    entity.setCodigoDetalle(detalleCatalogo.getCodigoDetalle());
	    entity.setDescripcion(detalleCatalogo.getDescripcion());
	    entity.setValorNumerico(detalleCatalogo.getValorNumerico());
	    entity.setOrden(detalleCatalogo.getOrden());
	    entity.setEsActivo(detalleCatalogo.isEsActivo());

	    // si permites cambiar catálogo:
	    entity.getCatalogo().setIdCatalogo(detalleCatalogo.getIdCatalogo());

	    DetalleCatalogoJpa saved = detalleCatalogoJpaRepository.save(entity);
	    return mapper.toDomain(saved);
	  }

	  // CREATE
	  DetalleCatalogoJpa entity = mapper.toEntity(detalleCatalogo);
	  DetalleCatalogoJpa saved = detalleCatalogoJpaRepository.save(entity);
	  return mapper.toDomain(saved);
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
