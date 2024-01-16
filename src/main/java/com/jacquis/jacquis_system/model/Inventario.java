package com.jacquis.jacquis_system.model;

import java.util.List;

import com.jacquis.jacquis_system.dto.InventarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "producto")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @NotBlank(message = "El código es obligatorio")
    @Column(name = "codigo_producto", columnDefinition = "VARCHAR(20)")
    private String codigo_producto;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(name = "descripcion", columnDefinition = "VARCHAR(200)")
    private String descripcion_producto;

    @Column(name = "estado_producto_p", columnDefinition = "VARCHAR(10)")
    private String estado_producto_p;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private Talla talla;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @OneToMany(mappedBy = "inventario")
    private List<DetalleVenta> detalle_venta;

    @OneToOne(mappedBy = "inventario")
    private EstadoProducto estado_producto;

    public Inventario() {
    }

    public Inventario(InventarioDTO inventarioDTO) {
    }

    public Inventario(String codigo_producto, String descripcion_producto, String estado_producto_p,
            Proveedor proveedor, Categoria categoria, Talla talla, Marca marca) {
        this.codigo_producto = codigo_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado_producto_p = estado_producto_p;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getEstado_producto_p() {
        return estado_producto_p;
    }

    public void setEstado_producto_p(String estado_producto_p) {
        this.estado_producto_p = estado_producto_p;
    }

}
