package com.jacquis.jacquis_system.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre", columnDefinition = "VARCHAR(100)")
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    @Column(name = "direccion, columnDefinition = VARCHAR(200)")
    private String direccion;

    @Column(name = "correo", columnDefinition = "VARCHAR(50)")
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(name = "estado_prov")
    private String estado_prov;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha_inicio_proveedor;

    @OneToMany(mappedBy = "proveedor")
    private List<Representante> representantes;

    @OneToMany(mappedBy = "proveedor")
    private Set<Inventario> inventario;

    public String getNombre() {
        return nombre;
    }

    public Proveedor(Long id_proveedor, String nombre, String correo, String direccion, String estado_prov,
            Date fecha_inicio_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.estado_prov = estado_prov;
        this.fecha_inicio_proveedor = fecha_inicio_proveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado_prov() {
        return estado_prov;
    }

    public void setEstado_prov(String estado_prov) {
        this.estado_prov = estado_prov;
    }

    public Date getFecha_inicio_proveedor() {
        return fecha_inicio_proveedor;
    }

    public void setFecha_inicio_proveedor(Date fecha_inicio_proveedor) {
        this.fecha_inicio_proveedor = fecha_inicio_proveedor;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Proveedor() {
        super();
    }

}
