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

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoDetalleRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoDetalleResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.ICompraProductoDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compra-producto-detalle")
public class CompraProductoDetalleController {

    private final ICompraProductoDetalleUseCase useCase;
    private final ICompraProductoDetalleDtoMapper mapper;

    public CompraProductoDetalleController(ICompraProductoDetalleUseCase useCase,
                                           ICompraProductoDetalleDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CompraProductoDetalleResponseDTO> listar() {
        return useCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/{idCompraProductoDetalle}")
    public CompraProductoDetalleResponseDTO buscarPorId(
            @PathVariable Long idCompraProductoDetalle) {
        return mapper.toResponseDto(
                useCase.buscarPorId(idCompraProductoDetalle)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraProductoDetalleResponseDTO guardar(
            @Valid @RequestBody CompraProductoDetalleRequestDTO dto) {
        return mapper.toResponseDto(
                useCase.guardar(mapper.toDomain(dto))
        );
    }

    @DeleteMapping("/{idCompraProductoDetalle}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idCompraProductoDetalle) {
        useCase.eliminar(idCompraProductoDetalle);
    }

}
