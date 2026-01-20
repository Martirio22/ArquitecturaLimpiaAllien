package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase{
	
	private final IUsuarioRepositorio usuarioRepositorio;

	public UsuarioUseCaseImpl(IUsuarioRepositorio usuarioRepositorio) {
		
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuarioRepositorio.guardar(usuario);
	}

	@Override
	public Usuario buscarPorId(Long idUsuario) {
		return usuarioRepositorio.buscarPorId(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idUsuario) {
		usuarioRepositorio.eliminar(idUsuario);
	}

	@Override
	public List<Usuario> buscarPorNombres(String nombre) {
		return usuarioRepositorio.buscarPorNombres(nombre);
	}

	
}
