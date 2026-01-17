package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.presentacion.dto.req.ClienteRequestDto;
import com.aliengnss.backend.presentacion.dto.res.ClienteResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IClienteDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
   private final IClienteUseCase clienteUseCase;
   private final IClienteDTOMapper mapper;

    public ClienteController(IClienteUseCase clienteUseCase, IClienteDTOMapper mapper) {
        this.clienteUseCase = clienteUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClienteResponseDto> listar() {
        return clienteUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto guardar(@Valid @RequestBody ClienteRequestDto clienteDto) {
        return mapper.toResponseDto(clienteUseCase.guardar(mapper.toDomain(clienteDto)));
    }
}
