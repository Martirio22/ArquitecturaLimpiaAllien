package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Usuario;

public interface IUsuarioUseCase {

	Usuario guardar(Usuario usuario);
	Usuario buscarPorId(Long idUsuario);
	List<Usuario> listarTodos();
	void eliminar(Long idUsuario);
	
	List<Usuario> buscarPorNombres(String nombre);
	void cambiarPassword(Long idUsuario, String claveActual, String claveNueva);
	void resetPassword(Long idUsuario, String claveTemporal);

}
