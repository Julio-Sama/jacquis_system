package com.jacquis.jacquis_system.model;

import java.util.Set;

import com.jacquis.jacquis_system.dto.CategoriaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "estado_categoria")
    private String estado_categoria;

    @OneToMany(mappedBy = "categoria")
    private Set<Inventario> inventario;

    public Categoria(CategoriaDTO categoriaDTO) {

    }

    public Categoria() {
        super();
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