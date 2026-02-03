package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;


public class MovimientoDetalleUseCaseImpl implements IMovimientoDetalleUseCase {

    private final IMovimientoDetalleRepositorio repo;

    public MovimientoDetalleUseCaseImpl(IMovimientoDetalleRepositorio repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public MovimientoDetalle guardar(MovimientoDetalle movimientoDetalle) {
        MovimientoDetalle detalleParaGuardar;

        if (movimientoDetalle.getIdMovimientoDetalle() == null) {
            // --- LÓGICA PARA CREACIÓN ---
            // Forzamos esActivo a true por defecto
            detalleParaGuardar = new MovimientoDetalle(
                null,
                movimientoDetalle.getCantidad(),
                true, // esActivo por defecto
                movimientoDetalle.getFkMovimiento(),
                movimientoDetalle.getFkProducto()
            );
        } else {
            // --- LÓGICA PARA EDICIÓN ---
            // Recuperamos el existente para no perder el estado actual (si está activo o no)
            MovimientoDetalle existente = buscarPorId(movimientoDetalle.getIdMovimientoDetalle());
            
            detalleParaGuardar = new MovimientoDetalle(
                existente.getIdMovimientoDetalle(),
                movimientoDetalle.getCantidad(),
                existente.getEsActivo(), // Mantenemos el estado que ya tenía
                movimientoDetalle.getFkMovimiento(),
                movimientoDetalle.getFkProducto()
            );
        }

        return repo.guardar(detalleParaGuardar);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDetalle buscarPorId(Long idMovimientoDetalle) {
        return repo.buscarPorId(idMovimientoDetalle)
                .orElseThrow(() -> new RuntimeException("MovimientoDetalle no encontrado: " + idMovimientoDetalle));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDetalle> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    @Transactional
    public void eliminar(Long idMovimientoDetalle) {
        // Borrado lógico: cambiamos el estado a false en lugar de eliminar la fila
        MovimientoDetalle existente = buscarPorId(idMovimientoDetalle);
        
        MovimientoDetalle detalleAnulado = new MovimientoDetalle(
            existente.getIdMovimientoDetalle(),
            existente.getCantidad(),
            false, // Desactivamos el registro
            existente.getFkMovimiento(),
            existente.getFkProducto()
        );
        
        repo.guardar(detalleAnulado);
    }

    
}
