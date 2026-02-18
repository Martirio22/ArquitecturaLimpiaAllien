package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IUsuarioJpaRepository;

public class UsuarioRepositorioImpl implements IUsuarioRepositorio{

	private final IUsuarioJpaRepository usuarioJpaRepository;
	private final IUsuarioJpaMapper entityMapper;
	
	
	public UsuarioRepositorioImpl(IUsuarioJpaRepository usuarioJpaRepository, IUsuarioJpaMapper entityMapper) {
		
		this.usuarioJpaRepository = usuarioJpaRepository;
		this.entityMapper = entityMapper;
	}
	
	@Override
	public Usuario guardar(Usuario usuario) {
		UsuarioJpa entity = entityMapper.toEntity(usuario);
		UsuarioJpa guardado = usuarioJpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}
	
	@Override
	public Optional<Usuario> buscarPorId(Long idUsuario){
		return usuarioJpaRepository.findById(idUsuario).map(entityMapper::toDomain);
	}
	
	@Override
	public List<Usuario> listarTodos(){
		return usuarioJpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}
	
	@Override
	public void eliminar(Long idUsuario) {
		usuarioJpaRepository.deleteById(idUsuario);
	}

}
