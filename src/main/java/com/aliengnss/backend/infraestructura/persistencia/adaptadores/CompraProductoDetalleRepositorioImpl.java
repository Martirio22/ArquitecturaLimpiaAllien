package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoDetalleJpaRepository;


public class CompraProductoDetalleRepositorioImpl implements ICompraProductoDetalleRepositorio {

    private final ICompraProductoDetalleJpaRepository repo;
    private final ICompraProductoDetalleJpaMapper mapper;

    public CompraProductoDetalleRepositorioImpl(ICompraProductoDetalleJpaRepository repo,
                                               ICompraProductoDetalleJpaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CompraProductoDetalle guardar(CompraProductoDetalle detalle) {
        CompraProductoDetalleJpa saved = repo.save(mapper.toEntity(detalle));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CompraProductoDetalle> buscarPorId(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<CompraProductoDetalle> listarTodos() {
        return repo.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

	@Override
	public List<CompraProductoDetalle> buscarPorComprasUsuarioYProducto(Long idUsuario, Long idProducto) {
		return repo.buscarPorComprasUsuarioYProducto(idUsuario, idProducto)
				.stream()
				.map(mapper::toDomain)
				.toList();
	}

    
}
