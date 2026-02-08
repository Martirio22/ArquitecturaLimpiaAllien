package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CambiarPasswordRequestDTO {
	@NotBlank
    private String claveActual;

    @NotBlank
    private String claveNueva;

}
