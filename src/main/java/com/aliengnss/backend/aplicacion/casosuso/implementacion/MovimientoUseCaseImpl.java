package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;


public class MovimientoUseCaseImpl implements IMovimientoUseCase {

    private final IMovimientoRepositorio repo;
    private final IUbicacionRepositorio ubicacionRepositorio;
    private final IUsuarioRepositorio usuarioRepositorio;
    
    

	public MovimientoUseCaseImpl(IMovimientoRepositorio repo, IUbicacionRepositorio ubicacionRepositorio,
			IUsuarioRepositorio usuarioRepositorio) {
		super();
		this.repo = repo;
		this.ubicacionRepositorio = ubicacionRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
    public Movimiento crear(MovimientoRequestDto dto) {

        Ubicacion origen = ubicacionRepositorio.buscarPorId(dto.getIdUbicacionOrigen())
                .orElseThrow(() -> new RuntimeException("Ubicación origen no existe"));

        Ubicacion destino = ubicacionRepositorio.buscarPorId(dto.getIdUbicacionDestino())
                .orElseThrow(() -> new RuntimeException("Ubicación destino no existe"));

        Usuario usuario = usuarioRepositorio.buscarPorId(dto.getFkUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        Movimiento movimiento = new Movimiento(
                null,
                dto.getFechaMovimiento(),
                dto.getTipo(),
                dto.getObservaciones(),
                usuario,
                origen,
                destino
        );

        return repo.guardar(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento buscarPorId(Long idMovimiento) {
        return repo.buscarPorId(idMovimiento)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado: " + idMovimiento));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long idMovimiento) {
        repo.eliminar(idMovimiento);
    }

   
}
