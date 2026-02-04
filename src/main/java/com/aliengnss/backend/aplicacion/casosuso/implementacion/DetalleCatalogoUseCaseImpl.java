package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleCatalogoUseCase;
import com.aliengnss.backend.dominio.entidades.DetalleCatalogo;
import com.aliengnss.backend.dominio.repositorios.IDetalleCatalogoRepositorio;

public class DetalleCatalogoUseCaseImpl implements IDetalleCatalogoUseCase {
	private final IDetalleCatalogoRepositorio repo;

	public DetalleCatalogoUseCaseImpl(IDetalleCatalogoRepositorio repo) {
		super();
		this.repo = repo;
	}

	@Override
	public DetalleCatalogo guardarDetalleCatalogo(DetalleCatalogo detalleCatalogo) {
		return repo.guardarDetalleCatalogo(detalleCatalogo);
	}

	@Override
	public DetalleCatalogo buscarDetalleCatalogoPorId(Long idDetalleCatalogo) {
		return repo.buscarDetalleCatalogoPorId(idDetalleCatalogo).orElseThrow(() -> new RuntimeException("Detalle Ctalogo no encontrado: " + idDetalleCatalogo));
	}

	@Override
	public List<DetalleCatalogo> listarDetalleCatalogos() {
		return repo.listarDetalleCatalogos();
	}

	@Override
	public void eliminar(Long idDetalleCatalogo) {
		repo.eliminar(idDetalleCatalogo);
	}

	@Override
	public List<DetalleCatalogo> listarDetallesPorNombreCatalogo(String nombreCatalogo) {
		return repo.listarDetallesPorNombreCatalogo(nombreCatalogo);
	}

}
