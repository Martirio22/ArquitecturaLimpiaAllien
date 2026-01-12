package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {

	Usuario guardar(Usuario usuario);
	Optional<Usuario> buscarPorId(Long idUsuario);
	List<Usuario> listarTodos();
	void eliminar(Long idUsuario);
}
