package com.jacquis.jacquis_system.dto;

public class CategoriaDTO {
    
    private Long id_categoria;
    private String nombre;
    private int nivel;
    private String estado_categoria;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id_categoria, String nombre, int nivel, String estado_categoria) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.nivel = nivel;
        this.estado_categoria = estado_categoria;
    }

    public CategoriaDTO(String nombre, int nivel, String estado_categoria) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.estado_categoria = estado_categoria;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getEstado_categoria() {
        return estado_categoria;
    }

    public void setEstado_categoria(String estado_categoria) {
        this.estado_categoria = estado_categoria;
    }

    

    
}
