package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleVentaUseCase;
import com.aliengnss.backend.presentacion.dto.req.DetalleVentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.DetalleVentaResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IDetalleVentaDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {
    private final IDetalleVentaUseCase detalleVentaUseCase;
    private final IDetalleVentaDTOMapper mapper;

    public DetalleVentaController(IDetalleVentaUseCase detalleVentaUseCase, IDetalleVentaDTOMapper mapper) {
        this.detalleVentaUseCase = detalleVentaUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<DetalleVentaResponseDto> listar() {
        return detalleVentaUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleVentaResponseDto guardar(@Valid @RequestBody DetalleVentaRequestDto detalleVentaDto) {
        return mapper.toResponseDto(detalleVentaUseCase.guardar(mapper.toDomain(detalleVentaDto)));
    }
}
