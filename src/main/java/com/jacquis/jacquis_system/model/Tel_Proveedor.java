package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_proveedor")
public class Tel_Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prov;
    
    private String telefono;

    public Tel_Proveedor() {
        super();
    }

    public Long getId_prov() {
        return id_prov;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId_prov(Long id_prov) {
        this.id_prov = id_prov;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
