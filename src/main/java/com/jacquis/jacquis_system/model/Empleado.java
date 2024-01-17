package com.jacquis.jacquis_system.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;

    @NotNull
    @Column(name = "dui_empleado", unique = true)
    @Size(min = 9, max = 9, message = "El DUI debe tener 9 dígitos, sin guiones")
    private String duiEmpleado;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    private String apellido_dos;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @Email(message = "No es un correo válido")
    private String correo_empleado;

    private String estado_empleado;
    private int empleado_fk;

    @OneToMany(mappedBy = "empleado")
    private List<Venta> ventas;

    @OneToOne(mappedBy = "empleado")
    private Usuario usuario;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    @Size(min = 1, message = "Debe ingresar al menos un teléfono")
    private List<TelefonoEmpleado> telefono_empleado;

    public Empleado() {
        this.telefono_empleado = new ArrayList<>();
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDuiEmpleado() {
        return duiEmpleado;
    }

    public void setDuiEmpleado(String duiEmpleado) {
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

    public List<TelefonoEmpleado> getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(List<TelefonoEmpleado> telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_empleado == null) ? 0 : id_empleado.hashCode());
        result = prime * result + ((duiEmpleado == null) ? 0 : duiEmpleado.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((apellido_dos == null) ? 0 : apellido_dos.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
        result = prime * result + ((correo_empleado == null) ? 0 : correo_empleado.hashCode());
        result = prime * result + ((estado_empleado == null) ? 0 : estado_empleado.hashCode());
        result = prime * result + empleado_fk;
        result = prime * result + ((ventas == null) ? 0 : ventas.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((telefono_empleado == null) ? 0 : telefono_empleado.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (id_empleado == null) {
            if (other.id_empleado != null)
                return false;
        } else if (!id_empleado.equals(other.id_empleado))
            return false;
        if (duiEmpleado == null) {
            if (other.duiEmpleado != null)
                return false;
        } else if (!duiEmpleado.equals(other.duiEmpleado))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (apellido_dos == null) {
            if (other.apellido_dos != null)
                return false;
        } else if (!apellido_dos.equals(other.apellido_dos))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        if (correo_empleado == null) {
            if (other.correo_empleado != null)
                return false;
        } else if (!correo_empleado.equals(other.correo_empleado))
            return false;
        if (estado_empleado == null) {
            if (other.estado_empleado != null)
                return false;
        } else if (!estado_empleado.equals(other.estado_empleado))
            return false;
        if (empleado_fk != other.empleado_fk)
            return false;
        if (ventas == null) {
            if (other.ventas != null)
                return false;
        } else if (!ventas.equals(other.ventas))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (telefono_empleado == null) {
            if (other.telefono_empleado != null)
                return false;
        } else if (!telefono_empleado.equals(other.telefono_empleado))
            return false;
        return true;
    }

    
}
