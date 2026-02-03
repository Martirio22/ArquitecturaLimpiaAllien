package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{idDetalleVenta}")
    public DetalleVentaResponseDto actualizar(@PathVariable Long idDetalleVenta, @Valid @RequestBody DetalleVentaRequestDto dto) {
        // 1. Seteamos el ID al DTO para que el mapper lo incluya al crear la entidad de dominio
        dto.setIdDetalleVenta(idDetalleVenta); 
        
        // 2. Mapeamos (MapStruct usará tu constructor con ID) y mandamos al UseCase
        return mapper.toResponseDto(detalleVentaUseCase.guardar(mapper.toDomain(dto)));
    }

    // ✅ MÉTODO ELIMINAR
    @DeleteMapping("/{idDetalleVenta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idDetalleVenta) {
        detalleVentaUseCase.eliminar(idDetalleVenta);
    }
    
    
    @GetMapping("/ventas/ubicacion/{idUbicacion}/producto/{idProducto}/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<DetalleVentaResponseDto>> ventasPorProductoUbicacionYFechas(
            @PathVariable Long idUbicacion,
            @PathVariable Long idProducto,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {

        return ResponseEntity.ok(
                detalleVentaUseCase.ventasPorProductoUbicacionYFecha(idProducto, idUbicacion, fechaInicio, fechaFin)
                        .stream()
                        .map(mapper::toResponseDto)
                        .toList()
        );
    }

}
