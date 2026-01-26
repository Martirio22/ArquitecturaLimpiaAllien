package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IUbicacionJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IUbicacionJpaRepository;


public class UbicacionRepositorioImpl implements IUbicacionRepositorio {
	private final IUbicacionJpaRepository repositorioJpa;
	private final IUbicacionJpaMapper entityMapper;

	public UbicacionRepositorioImpl(IUbicacionJpaRepository repositorioJpa, IUbicacionJpaMapper entityMapper) {

		this.repositorioJpa = repositorioJpa;
		this.entityMapper = entityMapper;
	}

	@Override
	public Ubicacion guardar(Ubicacion ubicacion) {
		UbicacionJpa entity = entityMapper.toEntity(ubicacion);
		UbicacionJpa guardado = repositorioJpa.save(entity);

		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Ubicacion> buscarPorId(Long id) {

		return repositorioJpa.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Ubicacion> listarTodos() {
		// TODO Auto-generated method stub
		return repositorioJpa.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long id) {
		repositorioJpa.deleteById(id);

	}
	@Override
	public Optional<Ubicacion> buscarPorNombreExacto(String nombre) {
	    return repositorioJpa.buscarPorNombreExacto(nombre)
	            .map(entityMapper::toDomain);
	}

	

	  

		
}
