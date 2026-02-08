package com.aliengnss.backend.infraestructura.repositorios;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ProductoLiteProjection {
    Long getIdProducto();
    String getNombre();
    String getMarca();
    String getTipo();
    String getDescripcion();
    Boolean getEsConSerial();
    BigDecimal getPorcentajeComision();
    LocalDateTime getFechaCreacion();
    Boolean getEsActivo();
}