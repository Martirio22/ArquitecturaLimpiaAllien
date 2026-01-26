package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.presentacion.dto.req.ProductoRequestDto;
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
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public ProductoResponseDto guardar(@Valid @RequestBody ProductoRequestDto productoDto) {
        return mapper.toResponseDto(productoUseCase.guardar(mapper.toDomain(productoDto)));
    }
	
	@GetMapping("/serial/{esConSerial}")
	public ResponseEntity<List<ProductoResponseDto>> buscarPorSerial(@PathVariable boolean esConSerial){
		List<ProductoResponseDto> lista = productoUseCase.buscarPorSerial(esConSerial)
				.stream()
				.map(mapper::toResponseDto)
				.toList();
		return ResponseEntity.ok(lista);
	}
}
