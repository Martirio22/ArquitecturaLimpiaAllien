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

        // CORRECCIÓN: Usar métodos de BigDecimal para el cálculo
        BigDecimal precio = producto.getPrecioVenta();
        BigDecimal cantidad = new BigDecimal(detalleVenta.getCantidad());
        
        detalleVenta.setPrecioUnitario(precio);
        // Multiplicación: precio * cantidad
        detalleVenta.setSubtotal(precio.multiply(cantidad));
        
        DetalleVenta detalleGuardado = detalleVentaRepositorio.guardar(detalleVenta);

        actualizarTotalVenta(detalleVenta.getFkVenta().getIdVenta());

        return detalleGuardado;
    }

    private void actualizarTotalVenta(Long idVenta) {
        List<DetalleVenta> todosLosDetalles = detalleVentaRepositorio.listarTodos();
        
        // CORRECCIÓN: Sumar usando BigDecimal
        BigDecimal nuevoTotal = todosLosDetalles.stream()
            .filter(d -> d.getFkVenta().getIdVenta().equals(idVenta))
            .map(DetalleVenta::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        ventaRepositorio.buscarPorId(idVenta).ifPresent(venta -> {
            venta.setTotal(nuevoTotal); // Asegúrate que en la entidad Venta, 'total' sea BigDecimal
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
        detalleVentaRepositorio.eliminar(idDetalleVenta);
    }

	@Override
	public List<DetalleVenta> ventasPorProductoUbicacionYFecha(Long idProducto, Long idUbicacion,
			LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return detalleVentaRepositorio.ventasPorProductoUbicacionYFecha(idProducto, idUbicacion, fechaInicio, fechaFin);
	}
}
