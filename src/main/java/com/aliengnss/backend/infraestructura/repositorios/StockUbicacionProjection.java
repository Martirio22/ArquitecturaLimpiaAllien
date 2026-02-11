package com.aliengnss.backend.infraestructura.repositorios;

public interface StockUbicacionProjection {
	Long getIdUbicacion();

	String getUbicacion();

	Long getIdProducto();

	String getProducto();

	java.math.BigDecimal getStock();
}