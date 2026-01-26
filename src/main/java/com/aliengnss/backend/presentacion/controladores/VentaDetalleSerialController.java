package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaDetalleSerialUseCase;
import com.aliengnss.backend.presentacion.dto.req.VentaDetalleSerialRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.VentaDetalleSerialResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.IVentaDetalleSerialDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ventaDetalleSerial")
@CrossOrigin(origins = "http://localhost:4200")

public class VentaDetalleSerialController {

	private final IVentaDetalleSerialUseCase cpUseCase;
	private final IVentaDetalleSerialDtoMapper mapper;
	
	public VentaDetalleSerialController(IVentaDetalleSerialUseCase cpUseCase, IVentaDetalleSerialDtoMapper mapper) {
		super();
		this.cpUseCase = cpUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
    public List<VentaDetalleSerialResponseDTO> listar() {
        return cpUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaDetalleSerialResponseDTO guardar(@Valid @RequestBody VentaDetalleSerialRequestDTO ventaDetalleSerialDto) {
        return mapper.toResponseDto(cpUseCase.guardar(mapper.toDomain(ventaDetalleSerialDto)));
    }

	@DeleteMapping("/{idVentaDetalleSerial}")
	public ResponseEntity<Void> eliminar(@PathVariable Long idVentaDetalleSerial){
	    cpUseCase.eliminar(idVentaDetalleSerial);
	    return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<List<VentaDetalleSerialResponseDTO>> ventasPorClienteConSerial(
	        @PathVariable Long idCliente,
	        @RequestParam LocalDateTime fechaInicio,
	        @RequestParam LocalDateTime fechaFin) {

	    List<VentaDetalleSerialResponseDTO> lista = cpUseCase.ventasPorClienteConSerial(idCliente, fechaInicio, fechaFin)
	            .stream()
	            .map(mapper::toResponseDto)
	            .toList();
	    return ResponseEntity.ok(lista);
	}

}
