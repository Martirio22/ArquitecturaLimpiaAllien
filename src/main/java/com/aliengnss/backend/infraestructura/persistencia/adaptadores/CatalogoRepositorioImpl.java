package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Catalogo;
import com.aliengnss.backend.dominio.repositorios.ICatalogoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CatalogoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICatalogoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICatalogoJpaRepository;

public class CatalogoRepositorioImpl implements ICatalogoRepositorio {
	
	private final ICatalogoJpaRepository catalogoJpaRepository;
	private final ICatalogoJpaMapper mapper;
	
	public CatalogoRepositorioImpl(ICatalogoJpaRepository catalogoJpaRepository, ICatalogoJpaMapper mapper) {
		super();
		this.catalogoJpaRepository = catalogoJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public Catalogo guargarCatalogo(Catalogo catalogo) {
		CatalogoJpa entity = mapper.toEntity(catalogo);
		CatalogoJpa guardar = catalogoJpaRepository.save(entity);
		return mapper.toDomain(guardar);
	}

	@Override
	public Optional<Catalogo> buscarCatalogoId(Long idCatalogo) {
		return catalogoJpaRepository.findById(idCatalogo).map(mapper::toDomain);
	}

	@Override
	public List<Catalogo> listarCatalogos() {
		return catalogoJpaRepository.findAll().stream().map(mapper::toDomain).toList();
	}

	@Override
	public void eliminarCatalogo(Long idCatalogo) {
		catalogoJpaRepository.deleteById(idCatalogo);
	}

}
