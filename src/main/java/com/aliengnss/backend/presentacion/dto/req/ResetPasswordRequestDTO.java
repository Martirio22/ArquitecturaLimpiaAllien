package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResetPasswordRequestDTO {
	@NotBlank
    @Size(min = 6, message = "La clave temporal debe tener al menos 6 caracteres")
    private String claveTemporal;
}
