package com.aliengnss.backend.presentacion.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ILoginUseCase;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.presentacion.dto.req.LoginRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.UsuarioResponseDTO;
import com.aliengnss.backend.presentacion.mapeadores.IUsuarioDtoMapper;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	private final ILoginUseCase loginUseCase;
    private final IUsuarioDtoMapper mapper;
    
	public LoginController(ILoginUseCase loginUseCase, IUsuarioDtoMapper mapper) {
		this.loginUseCase = loginUseCase;
		this.mapper = mapper;
	}
	@PostMapping("/login")
	public ResponseEntity<UsuarioResponseDTO> login(@RequestBody LoginRequestDTO loginDto) {

	    Usuario usuario = loginUseCase.autenticar(loginDto.getCorreoElectronico(), loginDto.getClave());
	    return ResponseEntity.ok(mapper.toResponseDto(usuario));
	}
    
}
