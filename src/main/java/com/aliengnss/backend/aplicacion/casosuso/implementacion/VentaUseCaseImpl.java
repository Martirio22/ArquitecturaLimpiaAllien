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
	// En VentaUseCaseImpl.java

	@Override
	@Transactional
	public Venta guardar(Venta venta) {

	    // ✅ DEBUG: lo primero que se ejecuta
	    System.out.println(">>> DEBUG VentaUseCase.guardar");
	    System.out.println("idVenta = " + venta.getIdVenta());
	    System.out.println("numeroFactura = " + venta.getNumeroFactura());
	    System.out.println("subtotal = " + venta.getSubtotal());
	    System.out.println("ivaPorcentaje = " + venta.getIvaPorcentaje());
	    System.out.println("ivaValor = " + venta.getIvaValor());
	    System.out.println("total = " + venta.getTotal());

	    if (venta.getIdVenta() == null) {

	        String numero = venta.getNumeroFactura();
	        if (numero == null || numero.isBlank()) {
	            throw new RuntimeException("El número de factura es obligatorio");
	        }

	        if (repo.existeNumeroFactura(numero)) {
	            throw new RuntimeException("El número de factura ya existe");
	        }

	        Venta ventaParaGuardar = new Venta(
	            null,
	            numero,
	            LocalDateTime.now(),

	            venta.getSubtotal(),
	            venta.getIvaPorcentaje(),
	            venta.getIvaValor(),

	            venta.getTotal(),
	            venta.getObservaciones(),
	            true,
	            venta.getFkCliente(),
	            venta.getFkUsuario()
	        );

	        // ✅ (opcional) otro debug para confirmar lo que realmente guardas
	        System.out.println(">>> DEBUG ventaParaGuardar.total = " + ventaParaGuardar.getTotal());

	        return repo.guardar(ventaParaGuardar);

	    } else {

	        Venta existente = buscarPorId(venta.getIdVenta());

	        Venta ventaParaActualizar = new Venta(
	            existente.getIdVenta(),
	            existente.getNumeroFactura(),  // no cambiar
	            existente.getFechaVenta(),     // no cambiar

	            // NUEVOS (opcionales) -> se actualizan con lo que manda UI
	            venta.getSubtotal(),
	            venta.getIvaPorcentaje(),
	            venta.getIvaValor(),

	            // total también viene desde UI
	            venta.getTotal(),

	            venta.getObservaciones(),
	            existente.getEsActivo(),
	            venta.getFkCliente(),
	            existente.getFkUsuario()
	        );

	        return repo.guardar(ventaParaActualizar);
	    }
	}

	private String generarProximoNumeroFactura() {
		return repo.listarTodos().stream().map(Venta::getNumeroFactura).max(String::compareTo).map(ultimo -> {
			int num = Integer.parseInt(ultimo.split("-")[1]) + 1;
			return String.format("VNT-%04d", num);
		}).orElse("VNT-0001");
	}

	@Override
	@Transactional(readOnly = true)
	public Venta buscarPorId(Long idVenta) {
		return repo.buscarPorId(idVenta).orElseThrow(() -> new RuntimeException("Venta no encontrada: " + idVenta));
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
	        v.getIdVenta(),
	        v.getNumeroFactura(),
	        v.getFechaVenta(),

	        // nuevos (copiar)
	        v.getSubtotal(),
	        v.getIvaPorcentaje(),
	        v.getIvaValor(),

	        v.getTotal(),
	        v.getObservaciones(),
	        false,
	        v.getFkCliente(),
	        v.getFkUsuario()
	    );

	    repo.guardar(ventaAnulada);

	    // 2. Anular Movimientos de Inventario (igual que antes)
	    List<InventarioMovimiento> movimientos = inventarioRepo.listarTodos().stream()
	        .filter(m -> "VENTA".equals(m.getReferenciaTipo()) && m.getReferenciaId() == idVenta.intValue())
	        .toList();

	    for (InventarioMovimiento mov : movimientos) {
	        InventarioMovimiento movDesactivado = new InventarioMovimiento(
	            mov.getIdInventarioMovimiento(),
	            mov.getFecha(),
	            mov.getTipo(),
	            mov.getCantidadEntrada(),
	            mov.getCantidadSalida(),
	            mov.getReferenciaTipo(),
	            mov.getReferenciaId(),
	            false,
	            mov.getFkProducto(),
	            mov.getFkProductoSerial(),
	            mov.getFkUbicacion()
	        );
	        inventarioRepo.guardar(movDesactivado);
	    }

	    // 3. Opcional: Anular los DetalleVenta (dejas igual)
	    detalleVentaRepositorio.listarTodos().stream()
	        .filter(d -> d.getFkVenta().getIdVenta().equals(idVenta))
	        .forEach(d -> {
	            // ... lógica para setear esActivo = false en detalle ...
	        });
	}

}