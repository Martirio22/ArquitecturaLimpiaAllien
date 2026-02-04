package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Catalogo;

public interface ICatalogoRepositorio {
	Catalogo guargarCatalogo(Catalogo catalogo);
	Optional<Catalogo> buscarCatalogoId(Long idCatalogo);
	List<Catalogo> listarCatalogos();
	void eliminarCatalogo(Long idCatalogo);
}
