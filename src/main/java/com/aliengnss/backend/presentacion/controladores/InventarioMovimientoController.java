package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
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
	
	@GetMapping("/producto/{idProducto}/tipo/{tipo}")
	public ResponseEntity<List<InventarioMovimientoResponseDTO>>
    buscarPorProductoYTipo(
            @PathVariable Long idProducto,
            @PathVariable String tipo) {

        return ResponseEntity.ok(
                cpUseCase.buscarPorProductoYTipo(idProducto, tipo)
                        .stream()
                        .map(mapper::toResponseDto)
                        .toList()
        );
    }
	
	@GetMapping("/ubicacion/{idUbicacion}/tipo/{tipo}")
	public ResponseEntity<List<InventarioMovimientoResponseDTO>>
    buscarPorUbicacionTipoYFechas(
            @PathVariable Long idUbicacion,
            @PathVariable String tipo,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    LocalDateTime inicio,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    LocalDateTime fin) {

        return ResponseEntity.ok(
                cpUseCase.buscarPorUbicacionTipoYFecha(
                                idUbicacion, tipo, inicio, fin)
                        .stream()
                        .map(mapper::toResponseDto)
                        .toList()
        );
    }
	
	@GetMapping("/serial/{serial}")
	public ResponseEntity<List<InventarioMovimientoResponseDTO>>
    buscarPorSerial(@PathVariable String serial) {

return ResponseEntity.ok(
        cpUseCase.buscarMovimientoPorSerial(serial)
                .stream()
                .map(mapper::toResponseDto)
                .toList()
);
}
	
	@GetMapping("/stock/producto/{idProducto}/ubicacion/{idUbicacion}")
	public ResponseEntity<Integer> obtenerStock(
	        @PathVariable Long idProducto, 
	        @PathVariable Long idUbicacion) {
	    
	    Integer stock = cpUseCase.obtenerStockPorProductoYUbicacion(idProducto, idUbicacion);
	    return ResponseEntity.ok(stock);
	}
}
