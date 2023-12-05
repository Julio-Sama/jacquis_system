package com.jacquis.jacquis_system.dto;

import com.jacquis.jacquis_system.model.Proveedor;

public class InventarioDTO {
    private Long id_producto;

    private String codigo_producto;
    private String descripcion_producto;
    private boolean estado_producto;

    private Proveedor proveedor;
    private CategoriaDTO categoria;
    private TallaDTO talla;
    private MarcaDTO marca;

    public InventarioDTO() {
    }

    public InventarioDTO(Long id_producto, String codigo_producto, String descripcion_producto, boolean estado_producto, Proveedor proveedor, CategoriaDTO categoria, TallaDTO talla, MarcaDTO marca) {
        this.id_producto = id_producto;
        this.codigo_producto = codigo_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.talla = talla;
        this.marca = marca;
    }

    public InventarioDTO(String codigo_producto, String descripcion_producto, boolean estado_producto, Proveedor proveedor, CategoriaDTO categoria, TallaDTO talla, MarcaDTO marca) {
        this.codigo_producto = codigo_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto = estado_producto;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.talla = talla;
        this.marca = marca;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public boolean isEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(boolean estado_producto) {
        this.estado_producto = estado_producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public TallaDTO getTalla() {
        return talla;
    }

    public void setTalla(TallaDTO talla) {
        this.talla = talla;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    

}
