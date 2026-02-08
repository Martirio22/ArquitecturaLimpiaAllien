package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase {
	
	private final IProductoRepositorio productoRepositorio;

	public ProductoUseCaseImpl(IProductoRepositorio productoRepositorio) {
		this.productoRepositorio = productoRepositorio;
	}

	@Override
	@Transactional
	public Producto guardar(Producto producto) {

	    boolean esNuevo = (producto.getIdProducto() == null);

	    Producto existente = null;
	    if (!esNuevo) {
	        existente = buscarPorId(producto.getIdProducto());
	    }

	    // 1) Validar duplicado por (nombre, marca, tipo)
	    if (esNuevo) {
	        productoRepositorio.buscarPorNombreMarcaTipo(producto.getNombre(), producto.getMarca(), producto.getTipo())
	            .ifPresent(p -> { throw new RuntimeException("Ya existe un producto con ese nombre, marca y tipo"); });
	    } else {
	        boolean cambiaClave =
	            !existente.getNombre().equalsIgnoreCase(producto.getNombre()) ||
	            !existente.getMarca().equalsIgnoreCase(producto.getMarca()) ||
	            !existente.getTipo().equalsIgnoreCase(producto.getTipo());

	        if (cambiaClave) {
	            productoRepositorio.buscarPorNombreMarcaTipo(producto.getNombre(), producto.getMarca(), producto.getTipo())
	                .ifPresent(p -> { throw new RuntimeException("Ya existe un producto con ese nombre, marca y tipo"); });
	        }
	    }

	    // 2) Construir objeto a guardar
	    Producto productoParaGuardar;

	    if (esNuevo) {
	        // Crear: el precio inicial sí se usa (para crear el primer histórico)
	        productoParaGuardar = new Producto(
	            null,
	            producto.getNombre(),
	            producto.getMarca(),
	            producto.getTipo(),
	            producto.getFoto(),
	            producto.getDescripcion(),
	            producto.getPrecioVenta(),            // ✅ solo aquí
	            producto.getEsConSerial(),
	            producto.getPorcentajeComision(),
	            LocalDateTime.now(),
	            true
	        );
	    } else {
	        // Update: NO cambiar precio por aquí (se cambia con PATCH precio)
	        productoParaGuardar = new Producto(
	            existente.getIdProducto(),
	            producto.getNombre(),
	            producto.getMarca(),
	            producto.getTipo(),
	            producto.getFoto(),
	            producto.getDescripcion(),
	            existente.getPrecioVenta(),            // ✅ conservar vigente
	            producto.getEsConSerial(),
	            producto.getPorcentajeComision(),
	            existente.getFechaCreacion(),
	            existente.getEsActivo()
	        );
	    }

	    return productoRepositorio.guardar(productoParaGuardar);
	}

	@Override
	public Producto buscarPorId(Long idProducto) {
		return productoRepositorio.buscarPorId(idProducto).orElseThrow(() -> new RuntimeException("No existe el producto con el id " + idProducto));
	}

	@Override
	public List<Producto> listarTodos() {
		return productoRepositorio.listarTodos();
	}

	@Override
	@Transactional
	public void eliminar(Long idProducto) {
	    // BORRADO LÓGICO
	    Producto existente = buscarPorId(idProducto);
	    
	    Producto desactivado = new Producto(
	        existente.getIdProducto(),
	        existente.getNombre(),
	        existente.getMarca(),
	        existente.getTipo(),
	        existente.getFoto(),
	        existente.getDescripcion(),
	        existente.getPrecioVenta(),
	        existente.getEsConSerial(),
	        existente.getPorcentajeComision(),
	        existente.getFechaCreacion(),
	        false // <--- Desactivamos el producto
	    );

	    productoRepositorio.guardar(desactivado);
	}

	@Override
	public List<Producto> buscarPorSerial(boolean esConSerial) {
		return productoRepositorio.buscarPorSerial(esConSerial);
	}

	@Override
	@Transactional
	public void cambiarPrecio(Long idProducto, BigDecimal precioVenta) {
	    buscarPorId(idProducto); // valida existe
	    productoRepositorio.cambiarPrecio(idProducto, precioVenta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoPrecioVenta> historialPrecios(Long idProducto) {
	    buscarPorId(idProducto); // valida existe
	    return productoRepositorio.historialPrecios(idProducto);
	}

}
