package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;
import com.aliengnss.backend.dominio.repositorios.IProductoPrecioVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoPrecioVentaJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoPrecioVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IProductoPrecioVentaJpaRepository;

public class ProductoPrecioVentaRepositorioImpl implements IProductoPrecioVentaRepositorio {
	private final IProductoPrecioVentaJpaRepository productoPrecioVentaJpaRepository;
	private final IProductoPrecioVentaJpaMapper mapper;
	
	public ProductoPrecioVentaRepositorioImpl(IProductoPrecioVentaJpaRepository productoPrecioVentaJpaRepository,
			IProductoPrecioVentaJpaMapper mapper) {
		super();
		this.productoPrecioVentaJpaRepository = productoPrecioVentaJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public ProductoPrecioVenta guardarProductoPrecioVenta(ProductoPrecioVenta productoPrecioVenta) {
		ProductoPrecioVentaJpa entity = mapper.toEntity(productoPrecioVenta);
		ProductoPrecioVentaJpa guardar = productoPrecioVentaJpaRepository.save(entity);
		return mapper.toDomain(guardar);
	}

	@Override
	public Optional<ProductoPrecioVenta> buscarProductoPrecioVentaPorId(Long idPrecioVenta) {
		return productoPrecioVentaJpaRepository.findById(idPrecioVenta).map(mapper::toDomain);
	}

	@Override
	public List<ProductoPrecioVenta> listarProductoPrecioVentas() {
		return productoPrecioVentaJpaRepository.findAll().stream().map(mapper::toDomain).toList();
	}

	@Override
	public void eliminarProductoPrecioVenta(Long idPrecioVenta) {
		productoPrecioVentaJpaRepository.deleteById(idPrecioVenta);
	}

}
