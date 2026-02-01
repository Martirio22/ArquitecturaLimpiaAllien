package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> feature/crudMartin

import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.presentacion.dto.req.UbicacionRequestDto;
import com.aliengnss.backend.presentacion.dto.res.UbicacionResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IUbicacionDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ubicacion")
@CrossOrigin(origins = "http://localhost:4200")

public class UbicacionControlador {
	private final IUbicacionUseCase UbicacionUseCase;
	private final IUbicacionDtoMapper mapper;


	public UbicacionControlador(IUbicacionUseCase ubicacionUseCase, IUbicacionDtoMapper mapper) {
		UbicacionUseCase = ubicacionUseCase;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<UbicacionResponseDto> obtenerPorId(@PathVariable Long id) {
		var ubicacion = UbicacionUseCase.obtenerPorId(id);
		return ResponseEntity.ok(mapper.toResponseDTO(ubicacion));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UbicacionResponseDto> actualizar (
			@PathVariable Long id,
			@Valid @RequestBody UbicacionRequestDto ubiacionDto
	) {
		UbicacionUseCase.obtenerPorId(id);
		ubiacionDto.setIdUbicacion(id);
		var actualizado = UbicacionUseCase.crear(mapper.toDomain(ubiacionDto));
		return ResponseEntity.ok(mapper.toResponseDTO(actualizado));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		UbicacionUseCase.eliminar(id);
	}
	
	
}
