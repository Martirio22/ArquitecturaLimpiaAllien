package com.aliengnss.backend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long idMovimiento;
    private final LocalDateTime fechaMovimiento;
    private final String tipo;
    private final String observaciones;
    private final Usuario fkUsuario;
    private final Ubicacion fkUbicacionOrigen;
    private final Ubicacion fkUbicacionDestino;
    private final List<MovimientoDetalle> detalles;
    
    // ✅ Constructor privado para el Builder
    private Movimiento(Builder builder) {
        this.idMovimiento = builder.idMovimiento;
        this.fechaMovimiento = builder.fechaMovimiento;
        this.tipo = builder.tipo;
        this.observaciones = builder.observaciones;
        this.fkUsuario = builder.fkUsuario;
        this.fkUbicacionOrigen = builder.fkUbicacionOrigen;
        this.fkUbicacionDestino = builder.fkUbicacionDestino;
        this.detalles = builder.detalles != null ? builder.detalles : new ArrayList<>();
    }
    
    // ✅ Constructor público con todos los parámetros (incluyendo detalles)
    public Movimiento(Long idMovimiento, LocalDateTime fechaMovimiento, String tipo, 
                      String observaciones, Usuario fkUsuario, 
                      Ubicacion fkUbicacionOrigen, Ubicacion fkUbicacionDestino,
                      List<MovimientoDetalle> detalles) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.fkUsuario = fkUsuario;
        this.fkUbicacionOrigen = fkUbicacionOrigen;
        this.fkUbicacionDestino = fkUbicacionDestino;
        this.detalles = detalles != null ? detalles : new ArrayList<>();
    }
    
    // ✅ Constructor público sin detalles (para mantener compatibilidad)
    public Movimiento(Long idMovimiento, LocalDateTime fechaMovimiento, String tipo, 
                      String observaciones, Usuario fkUsuario, 
                      Ubicacion fkUbicacionOrigen, Ubicacion fkUbicacionDestino) {
        this(idMovimiento, fechaMovimiento, tipo, observaciones, 
             fkUsuario, fkUbicacionOrigen, fkUbicacionDestino, new ArrayList<>());
    }
    
    // ✅ Método para crear un builder desde la instancia actual
    public Builder toBuilder() {
        return new Builder()
            .idMovimiento(this.idMovimiento)
            .fechaMovimiento(this.fechaMovimiento)
            .tipo(this.tipo)
            .observaciones(this.observaciones)
            .fkUsuario(this.fkUsuario)
            .fkUbicacionOrigen(this.fkUbicacionOrigen)
            .fkUbicacionDestino(this.fkUbicacionDestino)
            .detalles(this.detalles);
    }
    
    // ✅ Getters
    public Long getIdMovimiento() { 
        return idMovimiento; 
    }
    
    public LocalDateTime getFechaMovimiento() { 
        return fechaMovimiento; 
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public String getObservaciones() { 
        return observaciones; 
    }
    
    public Usuario getFkUsuario() { 
        return fkUsuario; 
    }
    
    public Ubicacion getFkUbicacionOrigen() { 
        return fkUbicacionOrigen; 
    }
    
    public Ubicacion getFkUbicacionDestino() { 
        return fkUbicacionDestino; 
    }
    
    public List<MovimientoDetalle> getDetalles() { 
        return detalles; 
    }
    
    // ✅ Método estático para crear un builder
    public static Builder builder() {
        return new Builder();
    }
    
    // ✅ Clase Builder interna
    public static class Builder {
        private Long idMovimiento;
        private LocalDateTime fechaMovimiento;
        private String tipo;
        private String observaciones;
        private Usuario fkUsuario;
        private Ubicacion fkUbicacionOrigen;
        private Ubicacion fkUbicacionDestino;
        private List<MovimientoDetalle> detalles;
        
        public Builder idMovimiento(Long idMovimiento) {
            this.idMovimiento = idMovimiento;
            return this;
        }
        
        public Builder fechaMovimiento(LocalDateTime fechaMovimiento) {
            this.fechaMovimiento = fechaMovimiento;
            return this;
        }
        
        public Builder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }
        
        public Builder observaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }
        
        public Builder fkUsuario(Usuario fkUsuario) {
            this.fkUsuario = fkUsuario;
            return this;
        }
        
        public Builder fkUbicacionOrigen(Ubicacion fkUbicacionOrigen) {
            this.fkUbicacionOrigen = fkUbicacionOrigen;
            return this;
        }
        
        public Builder fkUbicacionDestino(Ubicacion fkUbicacionDestino) {
            this.fkUbicacionDestino = fkUbicacionDestino;
            return this;
        }
        
        public Builder detalles(List<MovimientoDetalle> detalles) {
            this.detalles = detalles;
            return this;
        }
        
        public Movimiento build() {
            return new Movimiento(this);
        }
    }
}