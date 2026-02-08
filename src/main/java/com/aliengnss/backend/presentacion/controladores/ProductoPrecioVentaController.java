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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoPrecioVentaUseCase;
import com.aliengnss.backend.presentacion.dto.req.ProductoPrecioVentaRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.ProductoPrecioVentaResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.IProductoPrecioVentaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productoPrecioVenta")
public class ProductoPrecioVentaController {
	private final IProductoPrecioVentaUseCase useCase;
	private final IProductoPrecioVentaDtoMapper mapper;
	
	public ProductoPrecioVentaController(IProductoPrecioVentaUseCase useCase, IProductoPrecioVentaDtoMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}
	
	@GetMapping
    public List<ProductoPrecioVentaResponseDTO> listarDetalleCatalogos() {
        return useCase.listarProductoPrecioVentas().stream()
                .map(mapper::toResponseDto)
                .toList();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ProductoPrecioVentaResponseDTO> buscarProductoPrecioVentaPorId(@PathVariable Long id) {
        var detalle = useCase.buscarProductoPrecioVentaPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(detalle));
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoPrecioVentaResponseDTO guardarProductoPrecioVenta(@Valid @RequestBody ProductoPrecioVentaRequestDTO dto) {
        var domain = mapper.toDomain(dto);
        var guardado = useCase.guardarProductoPrecioVenta(domain);
        return mapper.toResponseDto(guardado);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<ProductoPrecioVentaResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoPrecioVentaRequestDTO dto
    ) {
        useCase.buscarProductoPrecioVentaPorId(id);

        dto.setIdPrecioVenta(id);

        // 3) mapear y guardar
        var actualizado = useCase.guardarProductoPrecioVenta(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        useCase.eliminarProductoPrecioVenta(id);
    }
}
