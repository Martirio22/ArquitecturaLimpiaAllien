package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IMovimientoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {

    private final IMovimientoUseCase useCase;
    private final IMovimientoDtoMapper mapper;

    public MovimientoController(IMovimientoUseCase useCase, IMovimientoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    // CRUD
    @GetMapping
	public List<MovimientoResponseDto> listar() {
		return useCase.listarTodos().stream().map(mapper::toResponseDTO).toList();

	}

    @GetMapping("/{idMovimiento}")
    public MovimientoResponseDto buscarPorId(@PathVariable Long idMovimiento) {
        return mapper.toResponseDTO(useCase.buscarPorId(idMovimiento));
    }

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MovimientoResponseDto crear(@Valid @RequestBody MovimientoRequestDto request) {
	    Movimiento movimiento = useCase.crear(request);
	    return mapper.toResponseDTO(movimiento);
	}
    
    @PutMapping("/{idMovimiento}")
    public MovimientoResponseDto actualizar(@PathVariable Long idMovimiento, @Valid @RequestBody MovimientoRequestDto request) {
        Movimiento actualizado = useCase.actualizar(idMovimiento, request);
        return mapper.toResponseDTO(actualizado);
    }

    @DeleteMapping("/{idMovimiento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idMovimiento) {
        useCase.eliminar(idMovimiento);
    }

    
}
