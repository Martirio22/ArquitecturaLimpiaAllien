package com.aliengnss.backend.presentacion.mapeadores;

import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.presentacion.dto.req.VentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.VentaResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface IVentaDTOMapper {
	// De DTO a Dominio (Para GUARDAR)
    // Ignoramos fkUsuario porque lo seteamos manualmente en el Controller
    @Mapping(target = "fkUsuario", ignore = true)
    @Mapping(target = "idVenta", ignore = true)
    @Mapping(target = "numeroFactura", ignore = true)
    @Mapping(target = "fechaVenta", ignore = true)
    Venta toDomain(VentaRequestDto dto);

    // De Dominio a DTO (Para LISTAR/MOSTRAR)
    // Aquí sí usamos fkUsuario y fkCliente porque ya existen en el objeto Venta
    VentaResponseDto toResponseDto(Venta venta);
}
