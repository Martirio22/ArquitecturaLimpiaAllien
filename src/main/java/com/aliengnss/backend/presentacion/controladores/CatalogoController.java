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

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICatalogoUseCase;
import com.aliengnss.backend.presentacion.dto.req.CatalogoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.CatalogoResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.ICatalogoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

	private final ICatalogoUseCase useCase;
	private final ICatalogoDtoMapper mapper;
	
	public CatalogoController(ICatalogoUseCase useCase, ICatalogoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CatalogoResponseDto> listarCatalogos() {
        return useCase.listarCatalogos().stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoResponseDto> buscarCatalogoId(@PathVariable Long id) {
        var catalogo = useCase.buscarCatalogoId(id);
        return ResponseEntity.ok(mapper.toResponseDto(catalogo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogoResponseDto guardarCatalogo(@Valid @RequestBody CatalogoRequestDto dto) {
        var domain = mapper.toDomain(dto);
        var guardado = useCase.guargarCatalogo(domain);
        return mapper.toResponseDto(guardado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CatalogoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CatalogoRequestDto dto
    ) {
        // 1) validar que existe (evita upsert accidental)
        useCase.buscarCatalogoId(id);

        // 2) poner el id del path en el DTO
        dto.setIdCatalogo(id);

        // 3) mapear y guardar
        var actualizado = useCase.guargarCatalogo(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCatalogo(@PathVariable Long id) {
        useCase.eliminarCatalogo(id);
    }
	
}
