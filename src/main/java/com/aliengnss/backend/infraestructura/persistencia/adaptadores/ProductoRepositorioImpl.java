package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IProductoJpaRepository;

public class ProductoRepositorioImpl implements IProductoRepositorio {
	
	private final IProductoJpaRepository productoJpaRepository;
	private final IProductoJpaMapper mapper;
	
	public ProductoRepositorioImpl(IProductoJpaRepository productoJpaRepository, IProductoJpaMapper mapper) {
		this.productoJpaRepository = productoJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public Producto guardar(Producto producto) {
		ProductoJpa entity = mapper.toEntity(producto);
		ProductoJpa guardar = productoJpaRepository.save(entity);
		return mapper.toDomain(guardar);
	}

	@Override
	public Optional<Producto> buscarPorId(Long idProducto) {
		return productoJpaRepository.findById(idProducto).map(mapper::toDomain);
	}

	@Override
	public List<Producto> listarTodos() {
		return productoJpaRepository.findAll().stream().map(mapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idProducto) {
		productoJpaRepository.deleteById(idProducto);
	}

	@Override
	public List<Producto> buscarPorSerial(boolean esConSerial) {
		return productoJpaRepository.buscarPorSerial(esConSerial)
				.stream()
				.map(mapper::toDomain)
				.toList();
	}

	
}
