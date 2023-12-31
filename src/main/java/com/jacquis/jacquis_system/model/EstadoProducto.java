package com.jacquis.jacquis_system.model;

import com.jacquis.jacquis_system.dto.EstadoProductoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_producto")
public class EstadoProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado_producto;

    @Column(name = "stock")
    private int stock;
    @Column(name = "precio_compra")
    private double precio_compra;
    @Column(name = "ganancia")
    private double ganancia;
    @Column(name = "estado_producto")
    private String estado_producto;
    @Column(name = "precioUventa")
    private double precioUventa;
    @Column(name = "color")
    private String color;

    @OneToOne(mappedBy = "estado_producto")
    private Inventario inventario;

    public EstadoProducto() {
    }

    public EstadoProducto(EstadoProductoDTO estadoProductoDTO){

    }

    public EstadoProducto(Long id_estado_producto, int stock, double precio_compra, double ganancia, String estado_producto, double precioUventa, String color) {
        this.id_estado_producto = id_estado_producto;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.ganancia = ganancia;
        this.estado_producto = estado_producto;
        this.precioUventa = precioUventa;
        this.color = color;
    }

    public Long getId_estado_producto() {
        return id_estado_producto;
    }

    public void setId_estado_producto(Long id_estado_producto) {
        this.id_estado_producto = id_estado_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public double getPrecioUventa() {
        return precioUventa;
    }

    public void setPrecioUventa(double precioUventa) {
        this.precioUventa = precioUventa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    

}
