package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    // CRUD
    @GetMapping
    public List<ClienteResponseDto> listar() {
        return clienteUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{idCliente}")
    public ClienteResponseDto buscarPorId(@PathVariable Long idCliente) {
        return mapper.toResponseDto(clienteUseCase.buscarPorId(idCliente));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto guardar(@Valid @RequestBody ClienteRequestDto clienteDto) {
        return mapper.toResponseDto(clienteUseCase.guardar(mapper.toDomain(clienteDto)));
    }

    @DeleteMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idCliente) {
        clienteUseCase.eliminar(idCliente);
    }

}
