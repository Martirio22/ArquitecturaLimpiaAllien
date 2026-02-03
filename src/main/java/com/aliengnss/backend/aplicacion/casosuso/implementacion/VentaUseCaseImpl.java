package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;
import com.aliengnss.backend.dominio.repositorios.IInventarioMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;


public class VentaUseCaseImpl implements IVentaUseCase {

    private final IVentaRepositorio repo;
    private final IDetalleVentaRepositorio detalleVentaRepositorio;
    private final IInventarioMovimientoRepositorio inventarioRepo;
    

    public VentaUseCaseImpl(IVentaRepositorio repo, IDetalleVentaRepositorio detalleVentaRepositorio,
            IInventarioMovimientoRepositorio inventarioRepo) {
		super();
		this.repo = repo;
		this.detalleVentaRepositorio = detalleVentaRepositorio;
		this.inventarioRepo = inventarioRepo;
	}
	@Override
    @Transactional
    public Venta guardar(Venta venta) {
        LocalDateTime fechaActual = LocalDateTime.now();
        
        // Si el ID es nulo, asumimos que es una venta NUEVA
        if (venta.getIdVenta() == null) {
            String nuevoNumero = generarProximoNumeroFactura();
            
            Venta ventaParaGuardar = new Venta(
                null, 
                nuevoNumero, 
                fechaActual, 
                venta.getTotal(), 
                venta.getObservaciones(),
                true, // <--- AQUÍ: Forzamos que sea true por defecto
                venta.getFkCliente(), 
                venta.getFkUsuario()
            );
            return repo.guardar(ventaParaGuardar);
        } else {
            // Lógica opcional para editar si fuera necesario, 
            // manteniendo el estado actual de 'esActivo'
            Venta existente = buscarPorId(venta.getIdVenta());
            Venta ventaParaActualizar = new Venta(
                existente.getIdVenta(),
                existente.getNumeroFactura(),
                existente.getFechaVenta(), // Mantenemos fecha original
                existente.getTotal(),
                venta.getObservaciones(),
                existente.getEsActivo(), 
                venta.getFkCliente(),
                venta.getFkUsuario()
            );
            return repo.guardar(ventaParaActualizar);
        }
    }
    private String generarProximoNumeroFactura() {
        return repo.listarTodos().stream()
            .map(Venta::getNumeroFactura)
            .max(String::compareTo)
            .map(ultimo -> {
                int num = Integer.parseInt(ultimo.split("-")[1]) + 1;
                return String.format("VNT-%04d", num);
            })
            .orElse("VNT-0001");
    }

    @Override
    @Transactional(readOnly = true)
    public Venta buscarPorId(Long idVenta) {
        return repo.buscarPorId(idVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada: " + idVenta));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    @Transactional
    public void eliminar(Long idVenta) {
        // 1. Anular la Venta (Cabecera)
        Venta v = buscarPorId(idVenta);
        Venta ventaAnulada = new Venta(
            v.getIdVenta(), v.getNumeroFactura(), v.getFechaVenta(),
            v.getTotal(), v.getObservaciones(), false, 
            v.getFkCliente(), v.getFkUsuario()
        );
        repo.guardar(ventaAnulada);

        // 2. Anular Detalles y sus Movimientos de Inventario
        // Buscamos todos los movimientos que tengan como referencia esta VENTA
        List<InventarioMovimiento> movimientos = inventarioRepo.listarTodos().stream()
                .filter(m -> "VENTA".equals(m.getReferenciaTipo()) && 
                             m.getReferenciaId() == idVenta.intValue())
                .toList();

        for (InventarioMovimiento mov : movimientos) {
            // Usamos el método eliminar que ya tienes en InventarioMovimientoUseCase
            // O simplemente lo guardamos como false aquí:
            InventarioMovimiento movDesactivado = new InventarioMovimiento(
                mov.getIdInventarioMovimiento(), mov.getFecha(), mov.getTipo(),
                mov.getCantidadEntrada(), mov.getCantidadSalida(),
                mov.getReferenciaTipo(), mov.getReferenciaId(),
                false, // <--- ESTO RECUPERA EL STOCK
                mov.getFkProducto(), mov.getFkProductoSerial(), mov.getFkUbicacion()
            );
            inventarioRepo.guardar(movDesactivado);
        }

        // 3. Opcional: Anular los DetalleVenta si los usas para reportes
        detalleVentaRepositorio.listarTodos().stream()
            .filter(d -> d.getFkVenta().getIdVenta().equals(idVenta))
            .forEach(d -> {
                // ... lógica para setear esActivo = false en detalle ...
            });
    }
}