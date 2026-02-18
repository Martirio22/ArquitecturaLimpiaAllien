package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleSerialRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleSerialResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoSeriesDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimientoSeries")
public class MovimientoSeriesController {
	private final IMovimientoSeriesUseCase movimientoSeriesUseCase;
	private final IMovimientoSeriesDTOMapper mapper;
	
	public MovimientoSeriesController(IMovimientoSeriesUseCase movimientoSeriesUseCase,
			IMovimientoSeriesDTOMapper mapper) {
		this.movimientoSeriesUseCase = movimientoSeriesUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<MovimientoDetalleSerialResponseDto> listar() {
		return movimientoSeriesUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MovimientoDetalleSerialResponseDto guardar(@Valid @RequestBody MovimientoDetalleSerialRequestDto movimientoSeriesDto) {
		return mapper.toResponseDto(movimientoSeriesUseCase.guardar(mapper.toDomain(movimientoSeriesDto)));
	}
	
}
