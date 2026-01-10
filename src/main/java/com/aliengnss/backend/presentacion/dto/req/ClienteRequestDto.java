package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDto {
    private  Long idCliente;
    @NotBlank
    private  String primerNombre;
    @NotBlank
    private  String segundoNombre;
    @NotBlank
    private  String primerApellido;
    @NotBlank
    private  String segundoApellido;
    @NotBlank
    private  String documento;
    @NotBlank
    private  String telefono;
    @NotBlank
    private  String email;
    @NotBlank
    private  String direccion;

}
