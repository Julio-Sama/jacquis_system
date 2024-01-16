package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_pl")
public class Tel_prov_log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prov_log;

    private String telefono_pl;

    @ManyToOne
    @JoinColumn(name = "id_pl")
    private ProveedorLogistica proveedor_logistica;

    public Tel_prov_log() {
    }

    public Tel_prov_log(String telefono_pl) {
        this.telefono_pl = telefono_pl;
    }

    public Long getId_prov_log() {
        return id_prov_log;
    }

    public void setId_prov_log(Long id_prov_log) {
        this.id_prov_log = id_prov_log;
    }

    public String getTelefono_pl() {
        return telefono_pl;
    }

    public void setTelefono_pl(String telefono_pl) {
        this.telefono_pl = telefono_pl;
    }


}
