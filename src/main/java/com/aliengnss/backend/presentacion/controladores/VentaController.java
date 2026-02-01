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
import com.aliengnss.backend.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.presentacion.dto.req.VentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.VentaResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IVentaDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    private final IVentaUseCase ventaUseCase;
    private final IUsuarioUseCase usuarioUseCase;
    private final IClienteUseCase clienteUseCase;
    private final IVentaDTOMapper mapper;

    

    public VentaController(IVentaUseCase ventaUseCase, IUsuarioUseCase usuarioUseCase, IClienteUseCase clienteUseCase,
			IVentaDTOMapper mapper) {
		this.ventaUseCase = ventaUseCase;
		this.usuarioUseCase = usuarioUseCase;
		this.clienteUseCase = clienteUseCase;
		this.mapper = mapper;
	}

	@GetMapping
    public List<VentaResponseDto> listar() {
        return ventaUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{idVenta}")
    public VentaResponseDto buscarPorId(@PathVariable Long idVenta) {
        return mapper.toResponseDto(ventaUseCase.buscarPorId(idVenta));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto guardar(
        @Valid @RequestBody VentaRequestDto dto, @RequestParam Long idUsuario) { 
        
        //buscamos al usuario directamente por su ID único
        Usuario usuario = usuarioUseCase.buscarPorId(idUsuario);

        //mapeamos el DTO al modelo de dominio
        Venta ventaDominio = mapper.toDomain(dto);
        
        //le asignamos el usuario encontrado
        ventaDominio.setFkUsuario(usuario);

        //guardamos (La lógica de fecha y factura sigue en el UseCase)
        return mapper.toResponseDto(ventaUseCase.guardar(ventaDominio));
    }
    
    @DeleteMapping("/{idVenta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idVenta) {
        ventaUseCase.eliminar(idVenta);
    }

}
