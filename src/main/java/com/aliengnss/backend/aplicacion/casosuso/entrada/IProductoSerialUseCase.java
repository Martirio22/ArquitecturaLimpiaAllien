package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.ProductoSerial;

public interface IProductoSerialUseCase {
	ProductoSerial guardar(ProductoSerial productoSerial);
	ProductoSerial buscarPorId(Long idProductoSerial);
	List<ProductoSerial> listarTodos();
	void eliminar(Long idProductoSerial);
}
