package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.presentacion.dto.req.CambiarPrecioRequestDto;
import com.aliengnss.backend.presentacion.dto.req.ProductoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.ProductoPrecioVentaResponseDTO;
import com.aliengnss.backend.presentacion.dto.res.ProductoResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IProductoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	private final IProductoUseCase productoUseCase;
	private final IProductoDTOMapper mapper;
	
	public ProductoController(IProductoUseCase productoUseCase, IProductoDTOMapper mapper) {
		this.productoUseCase = productoUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ProductoResponseDto> listar() {
        return productoUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> obtenerPorId(@PathVariable Long id) {
        var producto = productoUseCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(producto));
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public ProductoResponseDto guardar(@Valid @RequestBody ProductoRequestDto productoDto) {
        return mapper.toResponseDto(productoUseCase.guardar(mapper.toDomain(productoDto)));
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoResponseDto> actualizar(
	        @PathVariable Long id,
	        @Valid @RequestBody ProductoRequestDto productoDto
	) {
	    // 1) validar que existe (evita upsert accidental)
	    productoUseCase.buscarPorId(id);

	    // 2) poner el id del path en el DTO
	    productoDto.setIdProducto(id);

	    // 3) mapear y guardar
	    var actualizado = productoUseCase.guardar(mapper.toDomain(productoDto));
	    return ResponseEntity.ok(mapper.toResponseDto(actualizado));
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoUseCase.eliminar(id);
    }
	
	@GetMapping("/serial/{esConSerial}")
	public ResponseEntity<List<ProductoResponseDto>> buscarPorSerial(@PathVariable boolean esConSerial){
		List<ProductoResponseDto> lista = productoUseCase.buscarPorSerial(esConSerial)
				.stream()
				.map(mapper::toResponseDto)
				.toList();
		return ResponseEntity.ok(lista);
	}
	
	@PatchMapping("/{id}/precio")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cambiarPrecio(@PathVariable Long id,
	                          @Valid @RequestBody CambiarPrecioRequestDto dto) {
	    productoUseCase.cambiarPrecio(id, dto.getPrecioVenta());
	}

	@GetMapping("/{id}/historial-precios")
	public List<ProductoPrecioVentaResponseDTO> historial(@PathVariable Long id) {
	    return productoUseCase.historialPrecios(id).stream()
	        .map(pp -> {
	            ProductoPrecioVentaResponseDTO dto = new ProductoPrecioVentaResponseDTO();
	            dto.setIdPrecioVenta(pp.getIdPrecioVenta());
	            dto.setIdProducto(pp.getIdProducto());
	            dto.setPrecioVenta(pp.getPrecioVenta());
	            dto.setDesde(pp.getDesde());
	            dto.setHasta(pp.getHasta());
	            return dto;
	        })
	        .toList();
	}

}
