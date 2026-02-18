package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.dominio.repositorios.IProductoSerialRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoSerialJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoSerialJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IProductoSerialJpaRepository;

public class ProductoSerialRepositorioImpl implements IProductoSerialRepositorio {
	
	private final IProductoSerialJpaRepository productoSerialJpaRepository;
	private final IProductoSerialJpaMapper mapper;
	
	public ProductoSerialRepositorioImpl(IProductoSerialJpaRepository productoSerialJpaRepository,
			IProductoSerialJpaMapper mapper) {
		this.productoSerialJpaRepository = productoSerialJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public ProductoSerial guardar(ProductoSerial productoSerial) {
		ProductoSerialJpa entity = mapper.toEntity(productoSerial);
		ProductoSerialJpa guardar = productoSerialJpaRepository.save(entity);
		return mapper.toDomain(guardar);
	}

	@Override
	public Optional<ProductoSerial> buscarPorId(Long idProductoSerial) {
		return productoSerialJpaRepository.findById(idProductoSerial).map(mapper::toDomain);
	}

	@Override
	public List<ProductoSerial> listarTodos() {
		return productoSerialJpaRepository.findAll().stream().map(mapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idProductoSerial) {
		productoSerialJpaRepository.deleteById(idProductoSerial);
	}

}
