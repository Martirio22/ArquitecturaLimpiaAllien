package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoPrecioVentaJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IProductoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IProductoPrecioVentaJpaRepository;

public class ProductoRepositorioImpl implements IProductoRepositorio {

	private final IProductoJpaRepository productoJpaRepository;
	private final IProductoPrecioVentaJpaRepository precioRepo;
	private final IProductoJpaMapper mapper;

	public ProductoRepositorioImpl(IProductoJpaRepository productoJpaRepository,
			IProductoPrecioVentaJpaRepository precioRepo, IProductoJpaMapper mapper) {
		this.productoJpaRepository = productoJpaRepository;
		this.precioRepo = precioRepo;
		this.mapper = mapper;
	}

	@Override
	public Producto guardar(Producto producto) {
		// guardamos datos fijos
		ProductoJpa entity = mapper.toEntity(producto);
		ProductoJpa guardado = productoJpaRepository.save(entity);

		// si es nuevo, insertamos precio inicial
		if (producto.getIdProducto() == null) {
			ProductoPrecioVentaJpa precio = new ProductoPrecioVentaJpa();
			precio.setProducto(guardado);
			precio.setPrecioVenta(producto.getPrecioVenta());
			precio.setDesde(LocalDateTime.now());
			precio.setHasta(null);
			precioRepo.save(precio);
		}

		// devolvemos producto con precio vigente
		BigDecimal precioVigente = precioRepo.findFirstByProductoIdProductoAndHastaIsNull(guardado.getIdProducto())
				.map(ProductoPrecioVentaJpa::getPrecioVenta).orElse(BigDecimal.ZERO);

		Producto dom = mapper.toDomain(guardado);

		return new Producto(dom.getIdProducto(), dom.getNombre(), dom.getMarca(), dom.getTipo(), dom.getFoto(),
				dom.getDescripcion(), precioVigente, dom.getEsConSerial(), dom.getPorcentajeComision(),
				dom.getFechaCreacion(), dom.getEsActivo());
	}

	@Override
	public Optional<Producto> buscarPorId(Long idProducto) {
		return productoJpaRepository.findById(idProducto).map(p -> {
			BigDecimal precioVigente = precioRepo.findFirstByProductoIdProductoAndHastaIsNull(p.getIdProducto())
					.map(ProductoPrecioVentaJpa::getPrecioVenta).orElse(BigDecimal.ZERO);

			Producto dom = mapper.toDomain(p);

			return new Producto(dom.getIdProducto(), dom.getNombre(), dom.getMarca(), dom.getTipo(), dom.getFoto(),
					dom.getDescripcion(), precioVigente, dom.getEsConSerial(), dom.getPorcentajeComision(),
					dom.getFechaCreacion(), dom.getEsActivo());
		});
	}

	@Override
	public List<Producto> listarTodos() {
		return productoJpaRepository.listarSinFoto().stream().map(p -> {

			BigDecimal precioVigente = precioRepo.findFirstByProductoIdProductoAndHastaIsNull(p.getIdProducto())
					.map(ProductoPrecioVentaJpa::getPrecioVenta).orElse(BigDecimal.ZERO);

			// Aquí foto = null porque no la listamos (así no pesa)
			return new Producto(p.getIdProducto(), p.getNombre(), p.getMarca(), p.getTipo(), null, // ✅ NO FOTO EN
																									// LISTADO
					p.getDescripcion(), precioVigente, p.getEsConSerial(), p.getPorcentajeComision(),
					p.getFechaCreacion(), p.getEsActivo());
		}).toList();
	}

	@Override
	public Optional<Producto> buscarPorNombreMarcaTipo(String nombre, String marca, String tipo) {
		return productoJpaRepository
				.findByNombreIgnoreCaseAndMarcaIgnoreCaseAndTipoIgnoreCase(nombre.trim(), marca.trim(), tipo.trim())
				.map(mapper::toDomain);
	}

	@Override
	public void cambiarPrecio(Long idProducto, BigDecimal nuevoPrecio) {
		ProductoJpa producto = productoJpaRepository.findById(idProducto)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		LocalDateTime ahora = LocalDateTime.now();
		precioRepo.cerrarPrecioActual(idProducto, ahora);

		ProductoPrecioVentaJpa nuevo = new ProductoPrecioVentaJpa();
		nuevo.setProducto(producto);
		nuevo.setPrecioVenta(nuevoPrecio);
		nuevo.setDesde(ahora);
		nuevo.setHasta(null);

		precioRepo.save(nuevo);
	}

	@Override
	public void eliminar(Long idProducto) {
		productoJpaRepository.deleteById(idProducto);
	}

	@Override
	public List<Producto> buscarPorSerial(boolean esConSerial) {
		return productoJpaRepository.buscarPorSerial(esConSerial).stream().map(p -> {
			BigDecimal precioVigente = precioRepo.findFirstByProductoIdProductoAndHastaIsNull(p.getIdProducto())
					.map(ProductoPrecioVentaJpa::getPrecioVenta).orElse(BigDecimal.ZERO);

			Producto dom = mapper.toDomain(p);

			return new Producto(dom.getIdProducto(), dom.getNombre(), dom.getMarca(), dom.getTipo(), dom.getFoto(),
					dom.getDescripcion(), precioVigente, dom.getEsConSerial(), dom.getPorcentajeComision(),
					dom.getFechaCreacion(), dom.getEsActivo());
		}).toList();
	}

	@Override
	public List<ProductoPrecioVenta> historialPrecios(Long idProducto) {
		return precioRepo.findByProductoIdProductoOrderByDesdeDesc(idProducto).stream()
				.map(p -> new ProductoPrecioVenta(p.getIdPrecioVenta(), p.getProducto().getIdProducto(),
						p.getPrecioVenta(), p.getDesde(), p.getHasta()))
				.toList();
	}

}
