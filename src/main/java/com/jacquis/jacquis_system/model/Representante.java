package com.jacquis.jacquis_system.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "representante")
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_repre;

    @NotNull
    @Column(name = "dui_repre", unique = true)
    @Size(min = 9, max = 9, message = "El DUI debe tener 9 dígitos, sin guiones")
    private String dui_repre;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    private Date fecha_inicio_repre;

    private String estado_repre;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @OneToMany(mappedBy = "representante")
    private List<TelefonoRepre> telefono_representante;


    public String getEstado_repre() {
        return estado_repre;
    }

    public void setEstado_repre(String estado_repre) {
        this.estado_repre = estado_repre;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Representante() {
        super();
    }

    public Long getId_repre() {
        return id_repre;
    }

    public void setId_repre(Long id_repre) {
        this.id_repre = id_repre;
    }

    public String getDui_repre() {
        return dui_repre;
    }

    public void setDui_repre(String dui_repre) {
        this.dui_repre = dui_repre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_inicio_repre() {
        return fecha_inicio_repre;
    }

    public void setFecha_inicio_repre(Date fecha_inicio_repre) {
        this.fecha_inicio_repre = fecha_inicio_repre;
    }

}
