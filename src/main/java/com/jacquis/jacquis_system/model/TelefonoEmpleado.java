package com.jacquis.jacquis_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_empleado")
public class TelefonoEmpleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id__tel_empleado;
    
    @ManyToOne
    @JoinColumn(name = "dui_empleado")
    private Empleado empleado;

    @Column(name = "telefono")
    private String telefono;

    public TelefonoEmpleado() {
    }

    public TelefonoEmpleado(Empleado empleado, String telefono) {
        this.empleado = empleado;
        this.telefono = telefono;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
