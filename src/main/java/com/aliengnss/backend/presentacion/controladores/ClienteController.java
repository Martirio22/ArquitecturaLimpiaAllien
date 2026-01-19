package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // =========================
    // BUSQUEDAS (3 básicas)
    // =========================

    @GetMapping("/buscar/documento/{documento}")
    public ClienteResponseDto buscarPorDocumento(@PathVariable String documento) {
        return mapper.toResponseDto(clienteUseCase.buscarPorDocumento(documento));
    }

    @GetMapping("/buscar/email/{email}")
    public ClienteResponseDto buscarPorEmail(@PathVariable String email) {
        return mapper.toResponseDto(clienteUseCase.buscarPorEmail(email));
    }

    @GetMapping("/buscar/telefono/{telefono}")
    public ClienteResponseDto buscarPorTelefono(@PathVariable String telefono) {
        return mapper.toResponseDto(clienteUseCase.buscarPorTelefono(telefono));
    }

    // =========================
    // BUSQUEDAS (7 compuestas)
    // =========================

    @GetMapping("/buscar/nombre")
    public List<ClienteResponseDto> buscarPorPrimerNombre(@RequestParam String primerNombre) {
        return clienteUseCase.buscarPorPrimerNombre(primerNombre)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/apellido")
    public List<ClienteResponseDto> buscarPorPrimerApellido(@RequestParam String primerApellido) {
        return clienteUseCase.buscarPorPrimerApellido(primerApellido)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/nombre-apellido")
    public List<ClienteResponseDto> buscarPorNombreYApellido(@RequestParam String primerNombre,
                                                            @RequestParam String primerApellido) {
        return clienteUseCase.buscarPorNombreYApellido(primerNombre, primerApellido)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/documento-apellido")
    public List<ClienteResponseDto> buscarPorDocumentoYApellido(@RequestParam String documento,
                                                               @RequestParam String primerApellido) {
        return clienteUseCase.buscarPorDocumentoYApellido(documento, primerApellido)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/telefono-documento")
    public List<ClienteResponseDto> buscarPorTelefonoYDocumento(@RequestParam String telefono,
                                                               @RequestParam String documento) {
        return clienteUseCase.buscarPorTelefonoYDocumento(telefono, documento)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/email-documento")
    public List<ClienteResponseDto> buscarPorEmailYDocumento(@RequestParam String email,
                                                            @RequestParam String documento) {
        return clienteUseCase.buscarPorEmailYDocumento(email, documento)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/texto")
    public List<ClienteResponseDto> buscarPorTexto(@RequestParam String texto) {
        return clienteUseCase.buscarPorNombreOApellidoODocumento(texto)
                .stream().map(mapper::toResponseDto).toList();
    }
}
