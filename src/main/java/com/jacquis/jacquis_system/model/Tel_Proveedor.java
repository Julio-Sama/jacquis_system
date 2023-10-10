package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_proveedor")
public class Tel_Proveedor {

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
