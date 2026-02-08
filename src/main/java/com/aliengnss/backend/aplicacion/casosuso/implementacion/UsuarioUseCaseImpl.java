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

	    boolean esNuevo = (usuario.getIdUsuario() == null);

	    if (esNuevo) {
	        // Validar únicos
	        usuarioRepositorio.buscarPorCorreo(usuario.getCorreoElectronico())
	            .ifPresent(u -> { throw new RuntimeException("El correo ya está registrado"); });

	        usuarioRepositorio.buscarPorCedula(usuario.getCedula())
	            .ifPresent(u -> { throw new RuntimeException("La cédula ya está registrada"); });

	        // Defaults para nuevo
	        usuario = new Usuario(
	            null,
	            usuario.getPrimerNombre(), usuario.getSegundoNombre(),
	            usuario.getPrimerApellido(), usuario.getSegundoApellido(),
	            usuario.getNombreUsuario(), usuario.getCorreoElectronico(),
	            usuario.getCedula(), usuario.getClave(),
	            0, null, usuario.getRol(),
	            true,  // esActivo
	            true   // esNuevo (por ejemplo: true al crear)
	        );

	    } else {
	        Usuario existente = buscarPorId(usuario.getIdUsuario());

	        // Si cambió correo => validar que no exista en otro
	        if (!existente.getCorreoElectronico().equalsIgnoreCase(usuario.getCorreoElectronico())) {
	            usuarioRepositorio.buscarPorCorreo(usuario.getCorreoElectronico())
	                .ifPresent(u -> { throw new RuntimeException("El correo ya está registrado"); });
	        }

	        // Si cambió cédula => validar que no exista en otro
	        if (!existente.getCedula().equals(usuario.getCedula())) {
	            usuarioRepositorio.buscarPorCedula(usuario.getCedula())
	                .ifPresent(u -> { throw new RuntimeException("La cédula ya está registrada"); });
	        }

	        usuario = new Usuario(
	            existente.getIdUsuario(),
	            usuario.getPrimerNombre(), usuario.getSegundoNombre(),
	            usuario.getPrimerApellido(), usuario.getSegundoApellido(),
	            usuario.getNombreUsuario(), usuario.getCorreoElectronico(),
	            usuario.getCedula(), usuario.getClave(),
	            existente.getIntentosActual(),
	            existente.getUltimoAcceso(),
	            usuario.getRol(),
	            existente.getEsActivo(),
	            existente.getEsNuevo() // conservar el valor actual
	        );
	    }

	    return usuarioRepositorio.guardar(usuario);
	}

	// Algoritmo para validar cédula de Ecuador
	private boolean validarCedula(String cedula) {
	    if (cedula == null || cedula.length() != 10) return false;
	    try {
	        int provincia = Integer.parseInt(cedula.substring(0, 2));
	        if (provincia < 1 || provincia > 24) return false;
	        int d10 = Integer.parseInt(cedula.substring(9, 10));
	        int suma = 0;
	        for (int i = 0; i < 9; i++) {
	            int d = Integer.parseInt(cedula.substring(i, i + 1));
	            if (i % 2 == 0) {
	                d = d * 2;
	                if (d > 9) d -= 9;
	            }
	            suma += d;
	        }
	        int residuo = suma % 10;
	        int verificado = (residuo == 0) ? 0 : 10 - residuo;
	        return verificado == d10;
	    } catch (NumberFormatException e) { return false; }
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

	@Override
	public void cambiarPassword(Long idUsuario, String claveActual, String claveNueva) {

	    Usuario existente = buscarPorId(idUsuario);

	    // Validar clave actual
	    if (!existente.getClave().equals(claveActual)) {
	        throw new RuntimeException("La clave actual no es correcta");
	    }

	    // Update parcial: clave nueva + esNuevo=false
	    usuarioRepositorio.actualizarPassword(idUsuario, claveNueva);
	}

	@Override
	public void resetPassword(Long idUsuario, String claveTemporal) {

	    buscarPorId(idUsuario);

	    usuarioRepositorio.resetPassword(idUsuario, claveTemporal);
	}

	
}
