package com.jacquis.jacquis_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_venta_online")
public class DetalleVentaOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta_online;
    
    @Column(name = "direccion")
    private String direccion;

    // Relacion con la tabla proveedor_logistica
    @ManyToOne
    @JoinColumn(name = "id_prov_log")
    private ProveedorLogistica proveedor_logistica;

    // Relacion con la tabla venta
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta detalle_venta_online;

    public DetalleVentaOnline() {
    }

    public DetalleVentaOnline(Long id_venta_online, String direccion, ProveedorLogistica proveedor_logistica,
            Venta detalle_venta_online) {
        this.id_venta_online = id_venta_online;
        this.direccion = direccion;
        this.proveedor_logistica = proveedor_logistica;
        this.detalle_venta_online = detalle_venta_online;
    }

    public Long getId_venta_online() {
        return id_venta_online;
    }

    public void setId_venta_online(Long id_venta_online) {
        this.id_venta_online = id_venta_online;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ProveedorLogistica getProveedor_logistica() {
        return proveedor_logistica;
    }

    public void setProveedor_logistica(ProveedorLogistica proveedor_logistica) {
        this.proveedor_logistica = proveedor_logistica;
    }

    public Venta getDetalle_venta_online() {
        return detalle_venta_online;
    }

    public void setDetalle_venta_onlinea(Venta detalle_venta_online) {
        this.detalle_venta_online = detalle_venta_online;
    }

    

}
