package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.ProductoSerial;

public interface IProductoSerialRepositorio {
	ProductoSerial guardar(ProductoSerial productoSerial);
    Optional<ProductoSerial> buscarPorId(Long idProductoSerial);
    List<ProductoSerial> listarTodos();
    void eliminar(Long idProductoSerial);
}
