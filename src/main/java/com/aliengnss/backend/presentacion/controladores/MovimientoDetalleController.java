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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimiento-detalle")
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

    // Búsquedas
    @GetMapping("/buscar/movimiento/{idMovimiento}")
    public List<MovimientoDetalleResponseDto> buscarPorMovimiento(@PathVariable Long idMovimiento) {
        return useCase.buscarPorMovimientoId(idMovimiento).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/producto/{idProducto}")
    public List<MovimientoDetalleResponseDto> buscarPorProducto(@PathVariable Long idProducto) {
        return useCase.buscarPorProductoId(idProducto).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/movimiento-producto")
    public MovimientoDetalleResponseDto buscarPorMovimientoYProducto(@RequestParam Long idMovimiento,
            @RequestParam Long idProducto) {
        return mapper.toResponseDto(useCase.buscarPorMovimientoIdYProductoId(idMovimiento, idProducto));
    }

    @GetMapping("/existe")
    public boolean existe(@RequestParam Long idMovimiento, @RequestParam Long idProducto) {
        return useCase.existePorMovimientoIdYProductoId(idMovimiento, idProducto);
    }

    @GetMapping("/contar/movimiento/{idMovimiento}")
    public long contarPorMovimiento(@PathVariable Long idMovimiento) {
        return useCase.contarPorMovimientoId(idMovimiento);
    }

    @GetMapping("/contar/producto/{idProducto}")
    public long contarPorProducto(@PathVariable Long idProducto) {
        return useCase.contarPorProductoId(idProducto);
    }

    @GetMapping("/buscar/movimiento-cantidad-mayor")
    public List<MovimientoDetalleResponseDto> buscarMovimientoCantidadMayor(@RequestParam Long idMovimiento,
            @RequestParam int cantidad) {
        return useCase.buscarPorMovimientoIdYCantidadMayorQue(idMovimiento, cantidad)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/movimiento-cantidad-entre")
    public List<MovimientoDetalleResponseDto> buscarMovimientoCantidadEntre(@RequestParam Long idMovimiento,
            @RequestParam int min,
            @RequestParam int max) {
        return useCase.buscarPorMovimientoIdYCantidadEntre(idMovimiento, min, max)
                .stream().map(mapper::toResponseDto).toList();
    }
}
