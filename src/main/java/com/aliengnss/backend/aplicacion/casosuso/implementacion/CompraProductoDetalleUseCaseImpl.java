package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;


import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;



public class CompraProductoDetalleUseCaseImpl implements ICompraProductoDetalleUseCase {

    private final ICompraProductoDetalleRepositorio repo;

    public CompraProductoDetalleUseCaseImpl(ICompraProductoDetalleRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public CompraProductoDetalle guardar(CompraProductoDetalle detalle) {
    	
        return repo.guardar(detalle);
    }

    @Override
    public CompraProductoDetalle buscarPorId(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Override
    public List<CompraProductoDetalle> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long id) {
        repo.eliminar(id);
    }

	@Override
	public List<CompraProductoDetalle> buscarPorComprasUsuarioYProducto(Long idUsuario, Long idProducto) {
		return repo.buscarPorComprasUsuarioYProducto(idUsuario, idProducto);
	}

    
}
