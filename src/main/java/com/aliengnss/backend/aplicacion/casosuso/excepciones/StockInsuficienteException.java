package com.aliengnss.backend.aplicacion.casosuso.excepciones;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
