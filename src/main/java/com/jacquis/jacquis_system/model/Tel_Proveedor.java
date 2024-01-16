package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_proveedor")
public class Tel_Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tel_prov;
    
    private String tel_proveedor;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    public Tel_Proveedor() {
        super();
    }

    public Tel_Proveedor(Long id_tel_prov, String tel_proveedor, Proveedor proveedor) {
        super();
        this.id_tel_prov = id_tel_prov;
        this.tel_proveedor = tel_proveedor;
        this.proveedor = proveedor;
    }

    public Long getId_tel_prov() {
        return id_tel_prov;
    }

    public void setId_tel_prov(Long id_tel_prov) {
        this.id_tel_prov = id_tel_prov;
    }

    public String getTel_proveedor() {
        return tel_proveedor;
    }

    public void setTel_proveedor(String tel_proveedor) {
        this.tel_proveedor = tel_proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
}
