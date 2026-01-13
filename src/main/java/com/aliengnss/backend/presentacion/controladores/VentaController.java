package com.aliengnss.backend.presentacion.controladores;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.presentacion.dto.req.VentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.VentaResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IVentaDTOMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    private final IVentaUseCase ventaUseCase;
    private final IVentaDTOMapper mapper;

    public VentaController(IVentaUseCase ventaUseCase, IVentaDTOMapper mapper) {
        this.ventaUseCase = ventaUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<VentaResponseDto> listar() {
        return ventaUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto guardar(@Valid @RequestBody VentaRequestDto ventaDto) {
        return mapper.toResponseDto(ventaUseCase.guardar(mapper.toDomain(ventaDto)));
    }

}
