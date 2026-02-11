package com.aliengnss.backend.presentacion.consultas;

public record StockUbicacionDto(
		  Long idUbicacion,
		  String ubicacion,
		  Long idProducto,
		  String producto,
		  Long stock
		) {}