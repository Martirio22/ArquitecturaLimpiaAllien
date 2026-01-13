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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.presentacion.dto.request.MovimientoRequestDto;
import com.aliengnss.backend.presentacion.dto.response.MovimientoResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoControlador {
	private final IMovimientoUseCase MovimientoUseCase;
	private final IMovimientoDtoMapper mapper;

	private MovimientoControlador(IMovimientoUseCase MovimientoUseCase, IMovimientoDtoMapper mapper) {
		super();
		this.MovimientoUseCase = MovimientoUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MovimientoResponseDto crear(@Valid @RequestBody MovimientoRequestDto request) {
		return mapper.toResponseDTO(MovimientoUseCase.crear(mapper.toDomain(request)));
	}

	@GetMapping
	public List<MovimientoResponseDto> listar() {
		return MovimientoUseCase.Listar().stream().map(mapper::toResponseDTO).toList();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		MovimientoUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
