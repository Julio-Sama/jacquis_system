package com.jacquis.jacquis_system.dto;

public class TallaDTO {
    
    private Long id_talla;
    private String nombre_talla;

    public TallaDTO() {
    }

    public TallaDTO(Long id_talla, String nombre_talla) {
        this.id_talla = id_talla;
        this.nombre_talla = nombre_talla;
    }

    public TallaDTO(String nombre_talla) {
        this.nombre_talla = nombre_talla;
    
    }

    public Long getId_talla() {
        return id_talla;
    }

    public void setId_talla(Long id_talla) {
        this.id_talla = id_talla;
    }

    public String getNombre_talla() {
        return nombre_talla;
    }

    public void setNombre_talla(String nombre_talla) {
        this.nombre_talla = nombre_talla;
    }
}
