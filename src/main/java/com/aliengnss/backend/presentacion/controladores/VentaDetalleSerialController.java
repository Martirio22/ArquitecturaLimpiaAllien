package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaDetalleSerialUseCase;
import com.aliengnss.backend.presentacion.dto.req.VentaDetalleSerialRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.VentaDetalleSerialResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.IVentaDetalleSerialDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ventaDetalleSerial")
public class VentaDetalleSerialController {

    private final IVentaDetalleSerialUseCase useCase;
    private final IVentaDetalleSerialDtoMapper mapper;

    public VentaDetalleSerialController(IVentaDetalleSerialUseCase useCase, IVentaDetalleSerialDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<VentaDetalleSerialResponseDTO> listar() {
        return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{idVentaDetalleSerial}")
    public ResponseEntity<VentaDetalleSerialResponseDTO> buscarPorId(@PathVariable Long idVentaDetalleSerial) {
        var entidad = useCase.buscarPorId(idVentaDetalleSerial);
        return ResponseEntity.ok(mapper.toResponseDto(entidad));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaDetalleSerialResponseDTO guardar(@Valid @RequestBody VentaDetalleSerialRequestDTO dto) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(dto)));
    }

    @PutMapping("/{idVentaDetalleSerial}")
    public ResponseEntity<VentaDetalleSerialResponseDTO> actualizar(
            @PathVariable Long idVentaDetalleSerial,
            @Valid @RequestBody VentaDetalleSerialRequestDTO dto
    ) {
        // 1) validar que existe
        useCase.buscarPorId(idVentaDetalleSerial);

        // 2) set id del path
        dto.setIdVentaDetalleSerial(idVentaDetalleSerial);

        // 3) guardar
        var actualizado = useCase.guardar(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }

    @DeleteMapping("/{idVentaDetalleSerial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idVentaDetalleSerial) {
        useCase.eliminar(idVentaDetalleSerial);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<VentaDetalleSerialResponseDTO>> ventasPorClienteConSerial(
            @PathVariable Long idCliente,
            @RequestParam LocalDateTime fechaInicio,
            @RequestParam LocalDateTime fechaFin
    ) {
        List<VentaDetalleSerialResponseDTO> lista = useCase.ventasPorClienteConSerial(idCliente, fechaInicio, fechaFin)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(lista);
    }
}