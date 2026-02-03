package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;


public class CompraProductoUseCaseImpl implements ICompraProductoUseCase {

    private final ICompraProductoRepositorio repo;

    public CompraProductoUseCaseImpl(ICompraProductoRepositorio repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public CompraProducto guardar(CompraProducto compra) {
        CompraProducto compraParaGuardar;

        if (compra.getIdCompraProducto() == null) {
            // --- LÓGICA PARA CREAR ---
            compraParaGuardar = new CompraProducto(
                null,
                java.time.LocalDateTime.now(), // Sella la fecha de ingreso al momento de la creación
                compra.getObservaciones(),
                true, // Siempre activo al nacer
                compra.getFkUsuario()
            );
        } else {
            // --- LÓGICA PARA ACTUALIZAR ---
            CompraProducto existente = buscarPorId(compra.getIdCompraProducto());
            
            compraParaGuardar = new CompraProducto(
                existente.getIdCompraProducto(),
                existente.getFechaIngreso(), // Mantenemos la fecha original, no se debe editar
                compra.getObservaciones(),
                existente.getEsActivo(),     // Preservamos el estado de activación
                compra.getFkUsuario()
            );
        }

        return repo.guardar(compraParaGuardar);
    }

    @Override
    @Transactional(readOnly = true)
    public CompraProducto buscarPorId(Long idCompraProducto) {
        return repo.buscarPorId(idCompraProducto)
                .orElseThrow(() -> new RuntimeException("CompraProducto no encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraProducto> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    @Transactional
    public void eliminar(Long idCompraProducto) {
        // BORRADO LÓGICO
        CompraProducto existente = buscarPorId(idCompraProducto);
        
        CompraProducto compraAnulada = new CompraProducto(
            existente.getIdCompraProducto(),
            existente.getFechaIngreso(),
            existente.getObservaciones(),
            false, // <--- Marcamos como inactivo (anulado)
            existente.getFkUsuario()
        );

        repo.guardar(compraAnulada);
    }

}
