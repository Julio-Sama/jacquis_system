package com.jacquis.jacquis_system.model;

import java.util.List;
import com.jacquis.jacquis_system.dto.MarcaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_marca;

    @Column(name = "marca")
    private String nombre_marca;

    @OneToMany(mappedBy = "marca")
    private List<Inventario> inventario;

    public Marca(MarcaDTO marcaDTO) {
    }

    public Marca() {
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
