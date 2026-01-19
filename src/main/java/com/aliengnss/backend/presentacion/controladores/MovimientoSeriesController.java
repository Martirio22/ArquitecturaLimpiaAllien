package com.aliengnss.backend.presentacion.controladores;

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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleSerialRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleSerialResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoSeriesDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimiento-series")
public class MovimientoSeriesController {

    private final IMovimientoSeriesUseCase useCase;
    private final IMovimientoSeriesDTOMapper mapper;

    public MovimientoSeriesController(IMovimientoSeriesUseCase useCase, IMovimientoSeriesDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    // CRUD
    @GetMapping
    public List<MovimientoDetalleSerialResponseDto> listar() {
        return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{idMovimientoDetalleSerial}")
    public MovimientoDetalleSerialResponseDto buscarPorId(@PathVariable Long idMovimientoDetalleSerial) {
        return mapper.toResponseDto(useCase.buscarPorId(idMovimientoDetalleSerial));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovimientoDetalleSerialResponseDto guardar(@Valid @RequestBody MovimientoDetalleSerialRequestDto dto) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
    }

    @DeleteMapping("/{idMovimientoDetalleSerial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idMovimientoDetalleSerial) {
        useCase.eliminar(idMovimientoDetalleSerial);
    }

    // Búsquedas
    @GetMapping("/buscar/movimiento-detalle/{idMovimientoDetalle}")
    public List<MovimientoDetalleSerialResponseDto> buscarPorMovimientoDetalle(@PathVariable Long idMovimientoDetalle) {
        return useCase.buscarPorMovimientoDetalleId(idMovimientoDetalle)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/producto-serial/{idProductoSerial}")
    public List<MovimientoDetalleSerialResponseDto> buscarPorProductoSerial(@PathVariable Long idProductoSerial) {
        return useCase.buscarPorProductoSerialId(idProductoSerial)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/movimiento-detalle-producto-serial")
    public MovimientoDetalleSerialResponseDto buscarPorMovimientoDetalleYProductoSerial(@RequestParam Long idMovimientoDetalle,
                                                                                @RequestParam Long idProductoSerial) {
        return mapper.toResponseDto(useCase.buscarPorMovimientoDetalleIdYProductoSerialId(idMovimientoDetalle, idProductoSerial));
    }

    @GetMapping("/existe")
    public boolean existe(@RequestParam Long idMovimientoDetalle, @RequestParam Long idProductoSerial) {
        return useCase.existePorMovimientoDetalleIdYProductoSerialId(idMovimientoDetalle, idProductoSerial);
    }

    @DeleteMapping("/eliminar-por-movimiento-detalle/{idMovimientoDetalle}")
    public long eliminarPorMovimientoDetalle(@PathVariable Long idMovimientoDetalle) {
        return useCase.eliminarPorMovimientoDetalleId(idMovimientoDetalle);
    }

    @GetMapping("/contar/movimiento-detalle/{idMovimientoDetalle}")
    public long contarPorMovimientoDetalle(@PathVariable Long idMovimientoDetalle) {
        return useCase.contarPorMovimientoDetalleId(idMovimientoDetalle);
    }

    @GetMapping("/contar/producto-serial/{idProductoSerial}")
    public long contarPorProductoSerial(@PathVariable Long idProductoSerial) {
        return useCase.contarPorProductoSerialId(idProductoSerial);
    }
}
