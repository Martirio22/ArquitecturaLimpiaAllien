package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {

    private final IMovimientoUseCase useCase;
    private final IMovimientoDtoMapper mapper;

    public MovimientoController(IMovimientoUseCase useCase, IMovimientoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    // CRUD
    @GetMapping
    public List<MovimientoResponseDto> listar() {
        return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{idMovimiento}")
    public MovimientoResponseDto buscarPorId(@PathVariable Long idMovimiento) {
        return mapper.toResponseDto(useCase.buscarPorId(idMovimiento));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovimientoResponseDto guardar(@Valid @RequestBody MovimientoRequestDto dto) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
    }

    @DeleteMapping("/{idMovimiento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idMovimiento) {
        useCase.eliminar(idMovimiento);
    }

    // Búsquedas
    @GetMapping("/buscar/tipo/{tipo}")
    public List<MovimientoResponseDto> buscarPorTipo(@PathVariable String tipo) {
        return useCase.buscarPorTipo(tipo).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/usuario/{idUsuario}")
    public List<MovimientoResponseDto> buscarPorUsuario(@PathVariable Long idUsuario) {
        return useCase.buscarPorUsuarioId(idUsuario).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/fechas")
    public List<MovimientoResponseDto> buscarPorRangoFechas(@RequestParam LocalDateTime desde,
                                                           @RequestParam LocalDateTime hasta) {
        return useCase.buscarPorRangoFechas(desde, hasta).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/tipo-fechas")
    public List<MovimientoResponseDto> buscarPorTipoYRango(@RequestParam String tipo,
                                                          @RequestParam LocalDateTime desde,
                                                          @RequestParam LocalDateTime hasta) {
        return useCase.buscarPorTipoYRangoFechas(tipo, desde, hasta).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/usuario-fechas")
    public List<MovimientoResponseDto> buscarPorUsuarioYRango(@RequestParam Long idUsuario,
                                                             @RequestParam LocalDateTime desde,
                                                             @RequestParam LocalDateTime hasta) {
        return useCase.buscarPorUsuarioIdYRangoFechas(idUsuario, desde, hasta)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/origen/{idUbicacionOrigen}")
    public List<MovimientoResponseDto> buscarPorOrigen(@PathVariable Long idUbicacionOrigen) {
        return useCase.buscarPorUbicacionOrigenId(idUbicacionOrigen).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/destino/{idUbicacionDestino}")
    public List<MovimientoResponseDto> buscarPorDestino(@PathVariable Long idUbicacionDestino) {
        return useCase.buscarPorUbicacionDestinoId(idUbicacionDestino).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/origen-destino")
    public List<MovimientoResponseDto> buscarPorOrigenYDestino(@RequestParam Long idUbicacionOrigen,
                                                              @RequestParam Long idUbicacionDestino) {
        return useCase.buscarPorUbicacionOrigenIdYDestinoId(idUbicacionOrigen, idUbicacionDestino)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/observaciones")
    public List<MovimientoResponseDto> buscarPorObservaciones(@RequestParam String texto) {
        return useCase.buscarPorObservaciones(texto).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/usuario-tipo-fechas")
    public List<MovimientoResponseDto> buscarUsuarioTipoFechas(@RequestParam Long idUsuario,
                                                              @RequestParam String tipo,
                                                              @RequestParam LocalDateTime desde,
                                                              @RequestParam LocalDateTime hasta) {
        return useCase.buscarPorUsuarioIdTipoYRangoFechas(idUsuario, tipo, desde, hasta)
                .stream().map(mapper::toResponseDto).toList();
    }
}
