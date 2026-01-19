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

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.ICompraProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compra-producto")
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
        return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{id}")
    public CompraProductoResponseDTO buscarPorId(@PathVariable Long id) {
        return mapper.toResponseDto(useCase.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraProductoResponseDTO guardar(@Valid @RequestBody CompraProductoRequestDTO dto) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        useCase.eliminar(id);
    }

}
