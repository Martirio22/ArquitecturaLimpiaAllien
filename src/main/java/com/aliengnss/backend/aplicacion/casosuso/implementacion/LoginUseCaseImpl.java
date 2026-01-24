package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ILoginUseCase;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;

public class LoginUseCaseImpl implements ILoginUseCase{

	private final IUsuarioRepositorio usuarioRepositorio;

	public LoginUseCaseImpl(IUsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	@Override
	public Usuario autenticar(String correoElectronico, String clave) {
		Usuario usuario = usuarioRepositorio.buscarPorCorreo(correoElectronico)
				.orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
		
		if (!usuario.getClave().equals(clave)) {
            throw new RuntimeException("Credenciales inválidas");
        }
        
        if (!usuario.getEsActivo()) {
            throw new RuntimeException("Usuario inactivo");
        }

        return usuario;
	}
	
}
