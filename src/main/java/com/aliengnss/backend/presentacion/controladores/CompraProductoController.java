package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.ICompraProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compraProducto")
public class CompraProductoController {

	private final ICompraProductoUseCase cpUseCase;
	private final ICompraProductoDtoMapper mapper;
	
	public CompraProductoController(ICompraProductoUseCase cpUseCase, ICompraProductoDtoMapper mapper) {
		
		this.cpUseCase = cpUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
    public List<CompraProductoResponseDTO> listar() {
        return cpUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraProductoResponseDTO guardar(@Valid @RequestBody CompraProductoRequestDTO compraproductoDto) {
        return mapper.toResponseDto(cpUseCase.guardar(mapper.toDomain(compraproductoDto)));
    }
    
	@DeleteMapping("/{idCompraProducto}")
	public ResponseEntity<Void> eliminar(@PathVariable Long idCompraProducto){
		cpUseCase.eliminar(idCompraProducto);
		return ResponseEntity.noContent().build();
	}
}
