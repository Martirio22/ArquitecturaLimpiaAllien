package com.aliengnss.backend.presentacion.dto.res;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class FacturaVentaResponseDto {
  private Long idVenta;
  private String numeroFactura;
  private LocalDateTime fechaVenta;
  private BigDecimal total;
  private String observaciones;

  private ClienteFacturaDto cliente;
  private UsuarioFacturaDto usuario;

  private List<DetalleFacturaDto> detalles;

  @Data
  public static class ClienteFacturaDto {
    private Long idCliente;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;
  }

  @Data
  public static class UsuarioFacturaDto {
    private Long idUsuario;
    private String nombreUsuario;
    private String primerNombre;
    private String primerApellido;
  }

  @Data
  public static class DetalleFacturaDto {
    private Long idDetalleVenta;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    private ProductoDto producto;
    private UbicacionDto ubicacion;

    // opcional
    private List<String> seriales;
  }

  @Data
  public static class ProductoDto {
    private Long idProducto;
    private String nombre;
    private String marca;
    private String tipo;
    private Boolean esConSerial;
  }

  @Data
  public static class UbicacionDto {
    private Long idUbicacion;
    private String nombre;
  }
}