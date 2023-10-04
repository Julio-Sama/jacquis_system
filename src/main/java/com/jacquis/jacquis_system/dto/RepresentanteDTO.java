package com.jacquis.jacquis_system.dto;

import java.sql.Date;

public class RepresentanteDTO {
    
    private Long id_repre;
    private String dui_repre;
    private String nombre;
    private String apellido;
    private Date fecha_inicio_repre;

    public RepresentanteDTO() {
        super();
    }

    public RepresentanteDTO(Long id_repre, String dui_repre, String nombre, String apellido, Date fecha_inicio_repre) {
        this.id_repre = id_repre;
        this.dui_repre = dui_repre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_inicio_repre = fecha_inicio_repre;
    }

    public RepresentanteDTO(String dui_repre, String nombre, String apellido, Date fecha_inicio_repre) {
        this.dui_repre = dui_repre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_inicio_repre = fecha_inicio_repre;
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
