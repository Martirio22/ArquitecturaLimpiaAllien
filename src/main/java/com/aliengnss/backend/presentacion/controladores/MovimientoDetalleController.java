package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
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

    
}
