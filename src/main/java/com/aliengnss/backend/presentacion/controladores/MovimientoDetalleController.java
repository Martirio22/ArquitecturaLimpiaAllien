package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimientoDetalle")
public class MovimientoDetalleController {

	private final IMovimientoDetalleUseCase useCase;
	private final IMovimientoDetalleDtoMapper mapper;

	public MovimientoDetalleController(IMovimientoDetalleUseCase useCase, IMovimientoDetalleDtoMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}

	// CRUD
	@GetMapping
	public List<MovimientoDetalleResponseDto> listar() {
		return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idMovimientoDetalle}")
	public MovimientoDetalleResponseDto buscarPorId(@PathVariable Long idMovimientoDetalle) {
		return mapper.toResponseDto(useCase.buscarPorId(idMovimientoDetalle));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MovimientoDetalleResponseDto guardar(@Valid @RequestBody MovimientoDetalleRequestDto dto) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
	}

	@DeleteMapping("/{idMovimientoDetalle}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long idMovimientoDetalle) {
		useCase.eliminar(idMovimientoDetalle);
	}

	// 1) Movimientos de un producto en rango
	// GET
	// /api/movimientoDetalle/producto/5?inicio=2026-01-01T00:00:00&fin=2026-01-19T23:59:59
	@GetMapping("/producto/{idProducto}")
	public List<MovimientoDetalleResponseDto> movimientosProducto(@PathVariable Long idProducto,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
		return useCase.movimientosDeProductoEnRango(idProducto, inicio, fin).stream().map(mapper::toResponseDto)
				.toList();
	}

	// 2) Movimientos desde ubicacion origen en rango
	// GET /api/movimientoDetalle/origen/2?inicio=...&fin=...
	@GetMapping("/origen/{idUbicacionOrigen}")
	public List<MovimientoDetalleResponseDto> movimientosDesdeOrigen(@PathVariable Long idUbicacionOrigen,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
		return useCase.movimientosDesdeUbicacionEnRango(idUbicacionOrigen, inicio, fin).stream()
				.map(mapper::toResponseDto).toList();
	}

	// 3) Movimientos hacia ubicacion destino en rango
	// GET /api/movimientoDetalle/destino/3?inicio=...&fin=...
	@GetMapping("/destino/{idUbicacionDestino}")
	public List<MovimientoDetalleResponseDto> movimientosHaciaDestino(@PathVariable Long idUbicacionDestino,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
		return useCase.movimientosHaciaUbicacionEnRango(idUbicacionDestino, inicio, fin).stream()
				.map(mapper::toResponseDto).toList();
	}

	// 4) (opcional) Detalles de un movimiento (para ver los productos movidos en
	// ese movimiento)
	// GET /api/movimientoDetalle/movimiento/10
	@GetMapping("/movimiento/{idMovimiento}")
	public List<MovimientoDetalleResponseDto> detallesDeMovimiento(@PathVariable Long idMovimiento) {
		return useCase.detallesDeMovimiento(idMovimiento).stream().map(mapper::toResponseDto).toList();
	}

}
