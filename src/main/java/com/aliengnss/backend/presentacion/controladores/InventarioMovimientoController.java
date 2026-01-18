package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IInventarioMovimientoUseCase;
import com.aliengnss.backend.presentacion.dto.req.InventarioMovimientoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.InventarioMovimientoResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.IInventarioMovimientoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inventarioMovimiento")
public class InventarioMovimientoController {

	private final IInventarioMovimientoUseCase cpUseCase;
	private final IInventarioMovimientoDTOMapper mapper;
	

	
	public InventarioMovimientoController(IInventarioMovimientoUseCase cpUseCase,
			IInventarioMovimientoDTOMapper mapper) {
		super();
		this.cpUseCase = cpUseCase;
		this.mapper = mapper;
	}

	@GetMapping
    public List<InventarioMovimientoResponseDTO> listar() {
        return cpUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioMovimientoResponseDTO guardar(@Valid @RequestBody InventarioMovimientoRequestDTO inventarioMovimientoDto) {
        return mapper.toResponseDto(cpUseCase.guardar(mapper.toDomain(inventarioMovimientoDto)));
    }
    
	@DeleteMapping("/{idCompraProducto}")
	public ResponseEntity<Void> eliminar(@PathVariable Long idInventarioMovimiento){
		cpUseCase.eliminar(idInventarioMovimiento);
		return ResponseEntity.noContent().build();
	}
}
