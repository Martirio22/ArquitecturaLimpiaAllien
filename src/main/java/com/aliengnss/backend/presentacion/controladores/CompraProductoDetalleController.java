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

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoDetalleRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoDetalleResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.ICompraProductoDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compraProductoDetalle")
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
    public ResponseEntity<CompraProductoDetalleResponseDTO> obtenerPorId(
            @PathVariable Long idCompraProductoDetalle
    ) {
        var detalle = useCase.buscarPorId(idCompraProductoDetalle);
        return ResponseEntity.ok(mapper.toResponseDto(detalle));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraProductoDetalleResponseDTO guardar(
            @Valid @RequestBody CompraProductoDetalleRequestDTO dto
    ) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
    }

    @PutMapping("/{idCompraProductoDetalle}")
    public ResponseEntity<CompraProductoDetalleResponseDTO> actualizar(
            @PathVariable Long idCompraProductoDetalle,
            @Valid @RequestBody CompraProductoDetalleRequestDTO dto
    ) {
        // 1) validar que existe (evita upsert accidental)
        useCase.buscarPorId(idCompraProductoDetalle);

        // 2) poner el id del path en el DTO
        // AJUSTA ESTE SETTER al nombre real de tu DTO:
        dto.setIdCompraProductoDetalle(idCompraProductoDetalle);

        // 3) mapear y guardar
        var actualizado = useCase.guardar(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }

    @DeleteMapping("/{idCompraProductoDetalle}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idCompraProductoDetalle) {
        useCase.eliminar(idCompraProductoDetalle);
    }

    @GetMapping("/usuario/{idUsuario}/producto/{idProducto}")
    public ResponseEntity<List<CompraProductoDetalleResponseDTO>> buscarPorComprasUsuarioYProducto(
            @PathVariable Long idUsuario,
            @PathVariable Long idProducto
    ) {
        List<CompraProductoDetalleResponseDTO> lista =
                useCase.buscarPorComprasUsuarioYProducto(idUsuario, idProducto)
                        .stream()
                        .map(mapper::toResponseDto)
                        .toList();

        return ResponseEntity.ok(lista);
    }
}