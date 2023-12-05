package com.jacquis.jacquis_system.dto;

public class EstadoProductoDTO {
    
    private Long id_estado_producto;
    private int stock;
    private double precio_compra;
    private double ganancia;
    private String estado_producto;
    private double precioUventa;
    private String color;

    public EstadoProductoDTO() {
    }

    public EstadoProductoDTO(Long id_estado_producto, int stock, double precio_compra, double ganancia, String estado_producto, double precioUventa, String color) {
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

    
}
