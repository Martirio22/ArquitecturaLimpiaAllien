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

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.ICompraProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compraProducto")
public class CompraProductoController {

    private final ICompraProductoUseCase useCase;
    private final ICompraProductoDtoMapper mapper;

    public CompraProductoController(ICompraProductoUseCase useCase,
                                    ICompraProductoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CompraProductoResponseDTO> listar() {
        return useCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraProductoResponseDTO> obtenerPorId(@PathVariable Long id) {
        var compraProducto = useCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(compraProducto));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraProductoResponseDTO guardar(@Valid @RequestBody CompraProductoRequestDTO dto) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraProductoResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CompraProductoRequestDTO dto
    ) {
        // 1) validar que existe (evita upsert accidental)
        useCase.buscarPorId(id);

        // 2) poner el id del path en el DTO
        // AJUSTA ESTE SETTER al nombre real de tu DTO:
        // ej: setIdCompraProducto, setId, setIdCompra, etc.
        dto.setIdCompraProducto(id);

        // 3) mapear y guardar
        var actualizado = useCase.guardar(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        useCase.eliminar(id);
    }
}