package com.jacquis.jacquis_system.dto;

public class MarcaDTO {
    
    private Long id_marca;
    private String nombre_marca;

    public MarcaDTO() {
    }

    public MarcaDTO(Long id_marca, String nombre_marca) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
    }

    public MarcaDTO(String nombre_marca, boolean estado_marca) {
        this.nombre_marca = nombre_marca;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }
}
