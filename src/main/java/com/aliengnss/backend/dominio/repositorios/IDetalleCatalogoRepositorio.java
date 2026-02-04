package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.DetalleCatalogo;

public interface IDetalleCatalogoRepositorio {
	DetalleCatalogo guardarDetalleCatalogo(DetalleCatalogo detalleCatalogo);
	Optional<DetalleCatalogo> buscarDetalleCatalogoPorId(Long idDetalleCatalogo);
	List<DetalleCatalogo> listarDetalleCatalogos();
	void eliminar(Long idDetalleCatalogo);
	
	List<DetalleCatalogo> listarDetallesPorNombreCatalogo(String nombreCatalogo);
}
