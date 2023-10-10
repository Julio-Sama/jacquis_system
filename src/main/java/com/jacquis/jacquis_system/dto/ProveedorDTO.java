package com.jacquis.jacquis_system.dto;

public class ProveedorDTO {
    private Long id_proveedor;
    private String nombre;
    private String correo;
    private String direccion;
    private String estado_prov;
    private String fecha_inicio_proveedor;

    public ProveedorDTO() {
    }

    public ProveedorDTO(Long id_proveedor, String nombre,  String correo,
            String direccion, String estado_prov, String fecha_inicio_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.estado_prov = estado_prov;
        this.fecha_inicio_proveedor = fecha_inicio_proveedor;
    }

    public ProveedorDTO(String nombre, String correo, String direccion,
            String estado_prov, String fecha_inicio_proveedor) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.estado_prov = estado_prov;
        this.fecha_inicio_proveedor = fecha_inicio_proveedor;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_inicio_proveedor() {
        return fecha_inicio_proveedor;
    }

    public void setFecha_inicio_proveedor(String fecha_inicio_proveedor) {
        this.fecha_inicio_proveedor = fecha_inicio_proveedor;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEstado_prov(String estado_prov) {
        this.estado_prov = estado_prov;
    }

    public String getEstado_prov() {
        return estado_prov;
    }

}