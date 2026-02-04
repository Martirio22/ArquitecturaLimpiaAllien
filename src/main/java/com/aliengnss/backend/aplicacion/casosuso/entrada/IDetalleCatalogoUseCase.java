package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.DetalleCatalogo;

public interface IDetalleCatalogoUseCase {

	DetalleCatalogo guardarDetalleCatalogo(DetalleCatalogo detalleCatalogo);
	DetalleCatalogo buscarDetalleCatalogoPorId(Long idDetalleCatalogo);
	List<DetalleCatalogo> listarDetalleCatalogos();
	void eliminar(Long idDetalleCatalogo);
	
	List<DetalleCatalogo> listarDetallesPorNombreCatalogo(String nombreCatalogo);
}
