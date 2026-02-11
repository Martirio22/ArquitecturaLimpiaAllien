package com.aliengnss.backend.presentacion.dto.res;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class GuiaMovimientoResponseDto {
  private Long idMovimiento;
  private String tipo;
  private LocalDateTime fechaMovimiento;
  private String observaciones;

  private UsuarioDto usuario;
  private UbicacionDto ubicacionOrigen;
  private UbicacionDto ubicacionDestino;

  private List<DetalleDto> detalles;

  @Data
  public static class UsuarioDto {
    private Long idUsuario;
    private String nombreUsuario;
    private String primerNombre;
    private String primerApellido;
  }

  @Data
  public static class UbicacionDto {
    private Long idUbicacion;
    private String nombre;
  }

  @Data
  public static class DetalleDto {
    private Long idMovimientoDetalle;
    private Long idProducto;
    private String producto;
    private String marca;
    private String tipo;
    private Boolean esConSerial;

    private int cantidad;

    // si es serial, lista de seriales (si no, [])
    private List<String> seriales;
  }
}