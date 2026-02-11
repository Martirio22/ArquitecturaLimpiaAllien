package com.aliengnss.backend.presentacion.consultas;

public record SerialEnStockDto(
		  Long idUbicacion,
		  String ubicacion,
		  Long idProducto,
		  String producto,
		  Long idProductoSerial,
		  String serial
		) {}