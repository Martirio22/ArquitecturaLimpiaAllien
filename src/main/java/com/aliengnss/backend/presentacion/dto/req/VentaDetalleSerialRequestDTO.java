package com.aliengnss.backend.presentacion.dto.req;

import lombok.Data;

@Data
public class VentaDetalleSerialRequestDTO {

private Long idVentaDetalleSerial;
    
    private DetalleVentaRef fkDetalleVenta;
    private ProductoSerialRef fkProductoSerial;

    @Data
    public static class DetalleVentaRef {
        private Long idDetalleVenta;
    }

    @Data
    public static class ProductoSerialRef {
        private Long idProductoSerial;
    }
}
