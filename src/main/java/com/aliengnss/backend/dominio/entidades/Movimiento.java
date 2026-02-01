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
    // ✅ Nuevo campo agregado
    private final List<MovimientoDetalle> detalles; 
    
    // Constructor privado actualizado
    private Movimiento(Builder builder) {
        this.idMovimiento = builder.idMovimiento;
        this.fechaMovimiento = builder.fechaMovimiento;
        this.tipo = builder.tipo;
        this.observaciones = builder.observaciones;
        this.fkUsuario = builder.fkUsuario;
        this.fkUbicacionOrigen = builder.fkUbicacionOrigen;
        this.fkUbicacionDestino = builder.fkUbicacionDestino;
        // ✅ Inicialización de detalles
        this.detalles = builder.detalles != null ? builder.detalles : new ArrayList<>();
    }
    
    // Constructor público actualizado para mantener compatibilidad
    public Movimiento(Long idMovimiento, LocalDateTime fechaMovimiento, String tipo, 
                      String observaciones, Usuario fkUsuario, 
                      Ubicacion fkUbicacionOrigen, Ubicacion fkUbicacionDestino) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.fkUsuario = fkUsuario;
        this.fkUbicacionOrigen = fkUbicacionOrigen;
        this.fkUbicacionDestino = fkUbicacionDestino;
        this.detalles = new ArrayList<>(); // ✅ Default vacío
    }
    
    // Método para crear un builder desde la instancia actual
    public Builder toBuilder() {
        return new Builder()
            .idMovimiento(this.idMovimiento)
            .fechaMovimiento(this.fechaMovimiento)
            .tipo(this.tipo)
            .observaciones(this.observaciones)
            .fkUsuario(this.fkUsuario)
            .fkUbicacionOrigen(this.fkUbicacionOrigen)
            .fkUbicacionDestino(this.fkUbicacionDestino)
            .detalles(this.detalles); // ✅ Pasa los detalles al builder
    }
    
    // Getters
    public Long getIdMovimiento() { return idMovimiento; }
    public LocalDateTime getFechaMovimiento() { return fechaMovimiento; }
    public String getTipo() { return tipo; }
    public String getObservaciones() { return observaciones; }
    public Usuario getFkUsuario() { return fkUsuario; }
    public Ubicacion getFkUbicacionOrigen() { return fkUbicacionOrigen; }
    public Ubicacion getFkUbicacionDestino() { return fkUbicacionDestino; }
    // ✅ Getter para detalles
    public List<MovimientoDetalle> getDetalles() { return detalles; }
    
    // Builder estático
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private Long idMovimiento;
        private LocalDateTime fechaMovimiento;
        private String tipo;
        private String observaciones;
        private Usuario fkUsuario;
        private Ubicacion fkUbicacionOrigen;
        private Ubicacion fkUbicacionDestino;
        // ✅ Campo detalles en el builder
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

        // ✅ Método para agregar detalles en el builder
        public Builder detalles(List<MovimientoDetalle> detalles) {
            this.detalles = detalles;
            return this;
        }
        
        public Movimiento build() {
            return new Movimiento(this);
        }
    }
}