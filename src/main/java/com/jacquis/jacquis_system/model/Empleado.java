package com.jacquis.jacquis_system.model;

import java.util.List;

import com.jacquis.jacquis_system.dto.EmpleadoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "empleado")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;

    @NotNull
    @Column(name = "dui_empleado", columnDefinition = "BIGINT")
    // @ Size(min = 9, message = "El DUI debe tener 9 dígitos")
    private int duiEmpleado;

    private String nombre;
    private String apellido;
    private String apellido_dos;
    private String direccion;
    private String correo_empleado;
    private String estado_empleado;
    private int empleado_fk;

    @OneToMany(mappedBy = "empleado")
    @Size(min = 1, message = "Debe tener al menos un teléfono")
    private List<TelefonoEmpleado> telefonos;
    
    public Empleado(EmpleadoDTO empleadoDTO){

    }

    public Empleado() {
        super();
    }

    public Empleado(int duiEmpleado, String nombre, String apellido, String apellido_dos, String direccion,
            String correo_empleado, String estado_empleado, int empleado_fk) {
        this.duiEmpleado = duiEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido_dos = apellido_dos;
        this.direccion = direccion;
        this.correo_empleado = correo_empleado;
        this.estado_empleado = estado_empleado;
        this.empleado_fk = empleado_fk;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }



    public int getDuiEmpleado() {
        return duiEmpleado;
    }

    public void setDuiEmpleado(int duiEmpleado) {
        this.duiEmpleado = duiEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido_dos() {
        return apellido_dos;
    }

    public void setApellido_dos(String apellido_dos) {
        this.apellido_dos = apellido_dos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }

    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public int getEmpleado_fk() {
        return empleado_fk;
    }

    public void setEmpleado_fk(int empleado_fk) {
        this.empleado_fk = empleado_fk;
    }

    public String getEstado_empleado() {
        return estado_empleado;
    }

    public void setEstado_empleado(String estado_empleado) {
        this.estado_empleado = estado_empleado;
    }

}
