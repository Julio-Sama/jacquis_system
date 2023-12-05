package com.jacquis.jacquis_system.model;

import java.util.Set;

import com.jacquis.jacquis_system.dto.TallaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "talla")
public class Talla {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_talla;

    @Column(name = "talla")
    private String nombre_talla;

    @OneToMany(mappedBy = "talla")
    private Set<Inventario> inventario;

    public Talla(TallaDTO tallaDTO) {
    }
    public Talla() {
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
