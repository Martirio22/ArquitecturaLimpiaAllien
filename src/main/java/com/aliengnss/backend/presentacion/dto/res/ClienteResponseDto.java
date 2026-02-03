package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

@Data
public class ClienteResponseDto {
    private  Long idCliente;
    private  String primerNombre;
    private  String segundoNombre;
    private  String primerApellido;
    private  String segundoApellido;
    private  String documento;
    private  String telefono;
    private  String email;
    private  String direccion;
    private Boolean esActivo;
}
