package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleVentaUseCase;
import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DetalleVentaUseCaseImpl implements IDetalleVentaUseCase {

    private final IDetalleVentaRepositorio detalleVentaRepositorio;
    private final IProductoRepositorio productoRepositorio;
    private final IVentaRepositorio ventaRepositorio; // <--- AGREGAR ESTO

    // Actualiza el constructor para que reciba los 3
    public DetalleVentaUseCaseImpl(
        IDetalleVentaRepositorio detalleVentaRepositorio, 
        IProductoRepositorio productoRepositorio,
        IVentaRepositorio ventaRepositorio) {
        this.detalleVentaRepositorio = detalleVentaRepositorio;
        this.productoRepositorio = productoRepositorio;
        this.ventaRepositorio = ventaRepositorio;
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        Producto producto = productoRepositorio.buscarPorId(detalleVenta.getFkProducto().getIdProducto())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Cálculos de precio y subtotal
        BigDecimal precio = producto.getPrecioVenta();
        BigDecimal cantidad = new BigDecimal(detalleVenta.getCantidad());
        BigDecimal subtotalCalculado = precio.multiply(cantidad);

        DetalleVenta detalleParaGuardar;

        if (detalleVenta.getIdDetalleVenta() == null) {
            // --- LÓGICA PARA CREACIÓN ---
            detalleParaGuardar = new DetalleVenta(
                null,
                detalleVenta.getCantidad(),
                precio, // Usamos el precio del producto
                detalleVenta.getPorcentajeComision(),
                subtotalCalculado,
                true,   // <--- SIEMPRE TRUE AL CREAR
                detalleVenta.getFkVenta(),
                detalleVenta.getFkProducto(),
                detalleVenta.getFkUbicacion()
            );
        } else {
            // --- LÓGICA PARA EDICIÓN ---
            DetalleVenta existente = buscarPorId(detalleVenta.getIdDetalleVenta());
            
            detalleParaGuardar = new DetalleVenta(
                existente.getIdDetalleVenta(),
                detalleVenta.getCantidad(),
                precio, 
                detalleVenta.getPorcentajeComision(),
                subtotalCalculado,
                existente.getEsActivo(), // <--- PRESERVAR EL ESTADO ACTUAL
                detalleVenta.getFkVenta(),
                detalleVenta.getFkProducto(),
                detalleVenta.getFkUbicacion()
            );
        }

        DetalleVenta detalleGuardado = detalleVentaRepositorio.guardar(detalleParaGuardar);

        // Actualizar el total de la venta padre
        actualizarTotalVenta(detalleGuardado.getFkVenta().getIdVenta());

        return detalleGuardado;
    }

    private void actualizarTotalVenta(Long idVenta) {
        List<DetalleVenta> todosLosDetalles = detalleVentaRepositorio.listarTodos();
        
        // FILTRADO CLAVE: Solo sumamos los detalles que estén activos (true)
        BigDecimal nuevoTotal = todosLosDetalles.stream()
            .filter(d -> d.getFkVenta().getIdVenta().equals(idVenta))
            .filter(DetalleVenta::getEsActivo) // <--- Solo detalles activos
            .map(DetalleVenta::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        ventaRepositorio.buscarPorId(idVenta).ifPresent(venta -> {
            venta.setTotal(nuevoTotal);
            ventaRepositorio.guardar(venta);
        });
    }
    
    @Override
    public DetalleVenta buscarPorId(Long idDetalleVenta) {
        return detalleVentaRepositorio.buscarPorId(idDetalleVenta).orElseThrow(() -> new RuntimeException("DetalleVenta no encontrada"));
    }

    @Override
    public List<DetalleVenta> listarTodos() {
        return detalleVentaRepositorio.listarTodos();
    }

    @Override
    public void eliminar(Long idDetalleVenta) {
        // 1. Recuperamos el detalle existente
        DetalleVenta existente = buscarPorId(idDetalleVenta);

        // 2. Aplicamos borrado lógico: Creamos una copia con esActivo en false
        DetalleVenta detalleAnulado = new DetalleVenta(
            existente.getIdDetalleVenta(),
            existente.getCantidad(),
            existente.getPrecioUnitario(),
            existente.getPorcentajeComision(),
            existente.getSubtotal(),
            false, // <--- Desactivado
            existente.getFkVenta(),
            existente.getFkProducto(),
            existente.getFkUbicacion()
        );

        // 3. Guardamos el estado desactivado
        detalleVentaRepositorio.guardar(detalleAnulado);

        // 4. ¡IMPORTANTE! Recalcular el total de la venta restando este detalle
        actualizarTotalVenta(existente.getFkVenta().getIdVenta());
    }

	@Override
	public List<DetalleVenta> ventasPorProductoUbicacionYFecha(Long idProducto, Long idUbicacion,
			LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return detalleVentaRepositorio.ventasPorProductoUbicacionYFecha(idProducto, idUbicacion, fechaInicio, fechaFin);
	}
}
