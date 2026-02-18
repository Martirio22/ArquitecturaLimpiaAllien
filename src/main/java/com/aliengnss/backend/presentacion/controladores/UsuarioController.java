package com.aliengnss.backend.presentacion.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.aliengnss.backend.presentacion.dto.req.UsuarioRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.UsuarioResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final IUsuarioUseCase usuarioUseCase;
	private final IUsuarioDtoMapper mapper;
	
	public UsuarioController(IUsuarioUseCase usuarioUseCase, IUsuarioDtoMapper mapper) {
		
		this.usuarioUseCase = usuarioUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO guardar(@Valid @RequestBody UsuarioRequestDTO usuarioDto) {
        return mapper.toResponseDto(usuarioUseCase.guardar(mapper.toDomain(usuarioDto)));
    }
    
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> eliminar(@PathVariable Long idUsuario){
		usuarioUseCase.eliminar(idUsuario);
		return ResponseEntity.noContent().build();
	}
}
