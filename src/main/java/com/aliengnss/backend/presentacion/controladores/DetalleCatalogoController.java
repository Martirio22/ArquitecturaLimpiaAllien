package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleCatalogoUseCase;
import com.aliengnss.backend.presentacion.dto.req.DetalleCatalogoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.DetalleCatalogoResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IDetalleCatalogoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleCatalogo")
public class DetalleCatalogoController {

	private final IDetalleCatalogoUseCase useCase;
	private final IDetalleCatalogoDtoMapper mapper;

	public DetalleCatalogoController(IDetalleCatalogoUseCase useCase, IDetalleCatalogoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<DetalleCatalogoResponseDto> listarDetalleCatalogos() {
        return useCase.listarDetalleCatalogos().stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCatalogoResponseDto> buscarPorId(@PathVariable Long id) {
        var detalle = useCase.buscarDetalleCatalogoPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(detalle));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleCatalogoResponseDto guardar(@Valid @RequestBody DetalleCatalogoRequestDto dto) {
        var domain = mapper.toDomain(dto);
        var guardado = useCase.guardarDetalleCatalogo(domain);
        return mapper.toResponseDto(guardado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DetalleCatalogoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody DetalleCatalogoRequestDto dto
    ) {
        // 1) validar que existe (evita upsert accidental)
        useCase.buscarDetalleCatalogoPorId(id);

        // 2) poner el id del path en el DTO
        dto.setIdDetalleCatalogo(id);

        // 3) mapear y guardar
        var actualizado = useCase.guardarDetalleCatalogo(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        useCase.eliminar(id);
    }

    // ✅ Endpoint para SELECTs: trae detalles por nombre de catálogo
    // Ej: /api/detalleCatalogo/por-catalogo/MARCA
    @GetMapping("/por-catalogo/{nombreCatalogo}")
    public List<DetalleCatalogoResponseDto> listarPorNombreCatalogo(@PathVariable String nombreCatalogo) {
        return useCase.listarDetallesPorNombreCatalogo(nombreCatalogo).stream()
                .map(mapper::toResponseDto)
                .toList();
    }
}
