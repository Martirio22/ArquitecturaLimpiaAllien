package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;

@Service
public class MovimientoUseCaseImpl implements IMovimientoUseCase {
	private final IMovimientoRepositorio movimientoRepositorio;
    private final IUbicacionRepositorio ubicacionRepositorio;
    private final IUsuarioRepositorio usuarioRepositorio;

	

	public MovimientoUseCaseImpl(IMovimientoRepositorio movimientoRepositorio,
			IUbicacionRepositorio ubicacionRepositorio, IUsuarioRepositorio usuarioRepositorio) {
		super();
		this.movimientoRepositorio = movimientoRepositorio;
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

        return movimientoRepositorio.guardar(movimiento);
    }


	@Override
	public Movimiento obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return movimientoRepositorio.buscarPorId(id)
				.orElseThrow(()-> new RuntimeException("Movimiento no encontrado"));
	}

	@Override
	public List<Movimiento> Listar() {
		// TODO Auto-generated method stub
		return movimientoRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long id) {
		movimientoRepositorio.eliminar(id);

	}
}
