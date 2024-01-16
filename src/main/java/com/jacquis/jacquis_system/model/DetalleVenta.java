package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_venta;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta detalle_venta;

    private int cantidad_productos;
    private double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(Inventario inventario, int cantidad_productos, double subtotal) {
        this.inventario = inventario;
        this.cantidad_productos = cantidad_productos;
        this.subtotal = subtotal;
    }

    public Long getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(Long id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Venta getDetalle_venta() {
        return detalle_venta;
    }

    public void setDetalle_venta(Venta detalle_venta) {
        this.detalle_venta = detalle_venta;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    

    
}
