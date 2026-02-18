package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoSerialUseCase;
import com.aliengnss.backend.presentacion.dto.req.ProductoSerialRequestDto;
import com.aliengnss.backend.presentacion.dto.res.ProductoSerialResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IProductoSerialDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productoSerial")
public class ProductoSerialController {
	private final IProductoSerialUseCase productoSerialUseCase;
	private final IProductoSerialDTOMapper mapper;
	
	public ProductoSerialController(IProductoSerialUseCase productoSerialUseCase, IProductoSerialDTOMapper mapper) {
		this.productoSerialUseCase = productoSerialUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ProductoSerialResponseDto> listar() {
		return productoSerialUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoSerialResponseDto guardar(@Valid @RequestBody ProductoSerialRequestDto productoSerialDto) {
		return mapper.toResponseDto(productoSerialUseCase.guardar(mapper.toDomain(productoSerialDto)));
	}
	
}
