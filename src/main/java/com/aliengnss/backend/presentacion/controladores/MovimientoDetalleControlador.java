package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimientoDetalle")
public class MovimientoDetalleControlador {
	private final IMovimientoDetalleUseCase MovimientoDetalleUseCase;
	private final IMovimientoDetalleDtoMapper mapper;
	
	private MovimientoDetalleControlador(IMovimientoDetalleUseCase MovimientoDetalleUseCase, IMovimientoDetalleDtoMapper mapper) {
		super();
		this.MovimientoDetalleUseCase = MovimientoDetalleUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MovimientoDetalleResponseDto crear(@Valid @RequestBody MovimientoDetalleRequestDto request) {
		return mapper.toResponseDTO(MovimientoDetalleUseCase.crear(mapper.toDomain(request)));
	}

	@GetMapping
	public List<MovimientoDetalleResponseDto> listar() {
		return MovimientoDetalleUseCase.Listar().stream().map(mapper::toResponseDTO).toList();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		MovimientoDetalleUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
