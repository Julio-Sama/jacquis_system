package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_representante")
public class TelefonoRepre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tel_representante;

    private String telefono_repre;

    @ManyToOne
    @JoinColumn(name = "dui_representante")
    private Representante representante;

    public TelefonoRepre() {
    }

    public TelefonoRepre(String telefono_repre, Representante representante) {
        this.telefono_repre = telefono_repre;
        this.representante = representante;
    }

    public Long getId_tel_representante() {
        return id_tel_representante;
    }

    public void setId_tel_representante(Long id_tel_representante) {
        this.id_tel_representante = id_tel_representante;
    }

    public String getTelefono_repre() {
        return telefono_repre;
    }

    public void setTelefono_repre(String telefono_repre) {
        this.telefono_repre = telefono_repre;
    }

    
}
