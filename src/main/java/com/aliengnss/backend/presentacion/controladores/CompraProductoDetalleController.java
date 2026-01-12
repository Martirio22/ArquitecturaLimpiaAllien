package com.aliengnss.backend.presentacion.controladores;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoDetalleRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoDetalleResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.ICompraProductoDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compraProductoDetalle")
public class CompraProductoDetalleController {

	private final ICompraProductoDetalleUseCase cpdUseCase;
	private final ICompraProductoDetalleDtoMapper mapper;
	
	public CompraProductoDetalleController(ICompraProductoDetalleUseCase cpdUseCase, ICompraProductoDetalleDtoMapper mapper) {
		
		this.cpdUseCase = cpdUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
    public List<CompraProductoDetalleResponseDTO> listar() {
        return cpdUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraProductoDetalleResponseDTO guardar(@Valid @RequestBody CompraProductoDetalleRequestDTO compraproductodDto) {
        return mapper.toResponseDto(cpdUseCase.guardar(mapper.toDomain(compraproductodDto)));
    }
    
	@DeleteMapping("/{idCPD}")
	public ResponseEntity<Void> eliminar(@PathVariable Long idCompraProductoDetalle){
		cpdUseCase.eliminar(idCompraProductoDetalle);
		return ResponseEntity.noContent().build();
	}
}
