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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.presentacion.dto.request.UbicacionRequestDto;
import com.aliengnss.backend.presentacion.dto.response.UbicacionResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IUbicacionDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionControlador {
	private final IUbicacionUseCase UbicacionUseCase;
	private final IUbicacionDtoMapper mapper;

	private UbicacionControlador(IUbicacionUseCase UbicacionUseCase, IUbicacionDtoMapper mapper) {
		super();
		this.UbicacionUseCase = UbicacionUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UbicacionResponseDto crear(@Valid @RequestBody UbicacionRequestDto request) {
		return mapper.toResponseDTO(UbicacionUseCase.crear(mapper.toDomain(request)));
	}

	@GetMapping
	public List<UbicacionResponseDto> listar() {
		return UbicacionUseCase.Listar().stream().map(mapper::toResponseDTO).toList();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		UbicacionUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
