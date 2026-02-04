package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Catalogo;

public interface ICatalogoUseCase {

	Catalogo guargarCatalogo(Catalogo catalogo);
	Catalogo buscarCatalogoId(Long idCatalogo);
	List<Catalogo> listarCatalogos();
	void eliminarCatalogo(Long idCatalogo);
}
