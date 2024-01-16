package com.jacquis.jacquis_system.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor_logistica")
public class ProveedorLogistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pl;

    @Column(name = "nombre", columnDefinition = "VARCHAR(100)")
    private String nombre_pl;
    @Column(name = "apellido", columnDefinition = "VARCHAR(100)")
    private String apellido_pl;
    @Column(name = "empresa", columnDefinition = "VARCHAR(100)")
    private String empresa_pl;
    @Column(name = "correo_empresa", columnDefinition = "VARCHAR(100)")
    private String correo_empresa_pl;
    @Column(name = "matricula", columnDefinition = "VARCHAR(100)")
    private String matricula_pl;
    @Column(name = "estado_pl")
    private String estado_pl;

    @OneToMany(mappedBy = "proveedor_logistica")
    private List<DetalleVentaOnline> detalle_venta_online;
    

    public ProveedorLogistica() {
    }

    public ProveedorLogistica(String nombre_pl, String apellido_pl, String empresa_pl, String correo_empresa_pl,
            String matricula_pl, String estado_pl) {
        this.nombre_pl = nombre_pl;
        this.apellido_pl = apellido_pl;
        this.empresa_pl = empresa_pl;
        this.correo_empresa_pl = correo_empresa_pl;
        this.matricula_pl = matricula_pl;
        this.estado_pl = estado_pl;
    }

    public Long getId_pl() {
        return id_pl;
    }

    public void setId_pl(Long id_pl) {
        this.id_pl = id_pl;
    }

    public String getNombre_pl() {
        return nombre_pl;
    }

    public void setNombre_pl(String nombre_pl) {
        this.nombre_pl = nombre_pl;
    }

    public String getApellido_pl() {
        return apellido_pl;
    }

    public void setApellido_pl(String apellido_pl) {
        this.apellido_pl = apellido_pl;
    }

    public String getEmpresa_pl() {
        return empresa_pl;
    }

    public void setEmpresa_pl(String empresa_pl) {
        this.empresa_pl = empresa_pl;
    }

    public String getCorreo_empresa_pl() {
        return correo_empresa_pl;
    }

    public void setCorreo_empresa_pl(String correo_empresa_pl) {
        this.correo_empresa_pl = correo_empresa_pl;
    }

    public String getMatricula_pl() {
        return matricula_pl;
    }

    public void setMatricula_pl(String matricula_pl) {
        this.matricula_pl = matricula_pl;
    }

    public String getEstado_pl() {
        return estado_pl;
    }

    public void setEstado_pl(String estado_pl) {
        this.estado_pl = estado_pl;
    }

    

}
