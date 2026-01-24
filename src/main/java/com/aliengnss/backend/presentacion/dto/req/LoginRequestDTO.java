package com.aliengnss.backend.presentacion.dto.req;

import lombok.Data;

@Data
public class LoginRequestDTO {
	private String correoElectronico;
    private String clave;
}
