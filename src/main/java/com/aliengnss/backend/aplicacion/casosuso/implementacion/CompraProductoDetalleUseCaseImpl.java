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
        CompraProductoDetalle detalleActivo = new CompraProductoDetalle(
            detalle.getIdCompraProductoDetalle(),
            detalle.getCantidad(),
            detalle.getCostoUnitario(),
            true, 
            detalle.getFkCompraProducto(),
            detalle.getFkProducto(),
            detalle.getFkUbicacion()
        );
        
        return repo.guardar(detalleActivo);
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
        // 1. Buscamos el registro actual
        CompraProductoDetalle detalleExistente = repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado con ID: " + id));

        CompraProductoDetalle detalleAnulado = new CompraProductoDetalle(
            detalleExistente.getIdCompraProductoDetalle(),
            detalleExistente.getCantidad(),
            detalleExistente.getCostoUnitario(),
            false,
            detalleExistente.getFkCompraProducto(),
            detalleExistente.getFkProducto(),
            detalleExistente.getFkUbicacion()
        );

        repo.guardar(detalleAnulado);
    }

	@Override
	public List<CompraProductoDetalle> buscarPorComprasUsuarioYProducto(Long idUsuario, Long idProducto) {
		return repo.buscarPorComprasUsuarioYProducto(idUsuario, idProducto);
	}

    
}
