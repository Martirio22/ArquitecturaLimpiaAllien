package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICatalogoUseCase;
import com.aliengnss.backend.dominio.entidades.Catalogo;
import com.aliengnss.backend.dominio.repositorios.ICatalogoRepositorio;

public class CatalogoUseCaseImpl implements ICatalogoUseCase {
	private final ICatalogoRepositorio repo;

	public CatalogoUseCaseImpl(ICatalogoRepositorio repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Catalogo guargarCatalogo(Catalogo catalogo) {
		return repo.guargarCatalogo(catalogo);
	}

	@Override
	public Catalogo buscarCatalogoId(Long idCatalogo) {
		return repo.buscarCatalogoId(idCatalogo).orElseThrow(() -> new RuntimeException("Catalogo no encontrado: " + idCatalogo));
	}

	@Override
	public List<Catalogo> listarCatalogos() {
		return repo.listarCatalogos();
	}

	@Override
	public void eliminarCatalogo(Long idCatalogo) {
		repo.eliminarCatalogo(idCatalogo);
	}

}
