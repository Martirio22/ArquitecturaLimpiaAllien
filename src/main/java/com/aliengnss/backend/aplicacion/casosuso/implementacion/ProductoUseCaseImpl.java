package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase {
	
	private final IProductoRepositorio productoRepositorio;

	public ProductoUseCaseImpl(IProductoRepositorio productoRepositorio) {
		this.productoRepositorio = productoRepositorio;
	}

	@Override
	@Transactional
	public Producto guardar(Producto producto) {
	    Producto productoParaGuardar;

	    if (producto.getIdProducto() == null) {
	        // --- LÓGICA PARA CREAR ---
	        productoParaGuardar = new Producto(
	            null,
	            producto.getNombre(),
	            producto.getMarca(),
	            producto.getTipo(),
	            producto.getFoto(),
	            producto.getDescripcion(),
	            producto.getPrecioVenta(),
	            producto.getEsConSerial(),
	            producto.getPorcentajeComision(),
	            LocalDateTime.now(), // Sella la fecha de creación actual
	            true // esActivo por defecto
	        );
	    } else {
	        // --- LÓGICA PARA ACTUALIZAR ---
	        Producto existente = buscarPorId(producto.getIdProducto());
	        
	        productoParaGuardar = new Producto(
	            existente.getIdProducto(),
	            producto.getNombre(),
	            producto.getMarca(),
	            producto.getTipo(),
	            producto.getFoto(),
	            producto.getDescripcion(),
	            producto.getPrecioVenta(),
	            producto.getEsConSerial(),
	            producto.getPorcentajeComision(),
	            existente.getFechaCreacion(), // Mantenemos la fecha original
	            existente.getEsActivo()      // Mantenemos el estado de activación
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

	
}
