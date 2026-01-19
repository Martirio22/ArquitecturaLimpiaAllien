package com.aliengnss.backend.presentacion.controladores;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.presentacion.dto.req.VentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.VentaResponseDto;
import com.aliengnss.backend.presentacion.mapeadores.IVentaDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    private final IVentaUseCase ventaUseCase;
    private final IVentaDTOMapper mapper;

    public VentaController(IVentaUseCase ventaUseCase, IVentaDTOMapper mapper) {
        this.ventaUseCase = ventaUseCase;
        this.mapper = mapper;
    }

    // CRUD
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
    public VentaResponseDto guardar(@Valid @RequestBody VentaRequestDto dto) {
        return mapper.toResponseDto(ventaUseCase.guardar(mapper.toDomain(dto)));
    }

    @DeleteMapping("/{idVenta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idVenta) {
        ventaUseCase.eliminar(idVenta);
    }

    // Búsquedas

    @GetMapping("/buscar/factura/{numeroFactura}")
    public VentaResponseDto buscarPorNumeroFactura(@PathVariable String numeroFactura) {
        return mapper.toResponseDto(ventaUseCase.buscarPorNumeroFactura(numeroFactura));
    }

    @GetMapping("/buscar/cliente/{idCliente}")
    public List<VentaResponseDto> buscarPorCliente(@PathVariable Long idCliente) {
        return ventaUseCase.buscarPorClienteId(idCliente).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/usuario/{idUsuario}")
    public List<VentaResponseDto> buscarPorUsuario(@PathVariable Long idUsuario) {
        return ventaUseCase.buscarPorUsuarioId(idUsuario).stream().map(mapper::toResponseDto).toList();
    }

    // fechas en query params (ISO-8601): 2026-01-18T10:00:00
    @GetMapping("/buscar/fechas")
    public List<VentaResponseDto> buscarPorRangoFechas(@RequestParam LocalDateTime desde,
                                                      @RequestParam LocalDateTime hasta) {
        return ventaUseCase.buscarPorRangoFechas(desde, hasta).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/cliente-fechas")
    public List<VentaResponseDto> buscarPorClienteYRangoFechas(@RequestParam Long idCliente,
                                                               @RequestParam LocalDateTime desde,
                                                               @RequestParam LocalDateTime hasta) {
        return ventaUseCase.buscarPorClienteIdYRangoFechas(idCliente, desde, hasta)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/usuario-fechas")
    public List<VentaResponseDto> buscarPorUsuarioYRangoFechas(@RequestParam Long idUsuario,
                                                               @RequestParam LocalDateTime desde,
                                                               @RequestParam LocalDateTime hasta) {
        return ventaUseCase.buscarPorUsuarioIdYRangoFechas(idUsuario, desde, hasta)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/cliente-usuario")
    public List<VentaResponseDto> buscarPorClienteYUsuario(@RequestParam Long idCliente,
                                                           @RequestParam Long idUsuario) {
        return ventaUseCase.buscarPorClienteIdYUsuarioId(idCliente, idUsuario)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/cliente-usuario-fechas")
    public List<VentaResponseDto> buscarPorClienteYUsuarioYRangoFechas(@RequestParam Long idCliente,
                                                                       @RequestParam Long idUsuario,
                                                                       @RequestParam LocalDateTime desde,
                                                                       @RequestParam LocalDateTime hasta) {
        return ventaUseCase.buscarPorClienteIdYUsuarioIdYRangoFechas(idCliente, idUsuario, desde, hasta)
                .stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/total")
    public List<VentaResponseDto> buscarPorTotalEntre(@RequestParam BigDecimal min,
                                                      @RequestParam BigDecimal max) {
        return ventaUseCase.buscarPorTotalEntre(min, max).stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/buscar/observaciones")
    public List<VentaResponseDto> buscarPorObservaciones(@RequestParam String texto) {
        return ventaUseCase.buscarPorObservaciones(texto).stream().map(mapper::toResponseDto).toList();
    }
}
