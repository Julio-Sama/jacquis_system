package com.jacquis.jacquis_system.dto;

public class EmpleadoDTO {

    private Long id_empleado;
    private int duiEmpleado;
    private String nombre;
    private String apellido;
    private String apellido_dos;
    private String direccion;
    private String correo_empleado;
    private String estado_empleado;
    private int empleado_fk;
    
    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Long id_empleado, int duiEmpleado, String nombre, String apellido, String apellido_dos,
            String direccion, String correo_empleado, String estado_empleado, int empleado_fk) {
        this.id_empleado = id_empleado;
        this.duiEmpleado = duiEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido_dos = apellido_dos;
        this.direccion = direccion;
        this.correo_empleado = correo_empleado;
        this.estado_empleado = estado_empleado;
        this.empleado_fk = empleado_fk;
    }

    public EmpleadoDTO(int duiEmpleado, String nombre, String apellido, String apellido_dos, String direccion,
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

    public String getEstado_empleado() {
        return estado_empleado;
    }

    public int getEmpleado_fk() {
        return empleado_fk;
    }

    public void setEmpleado_fk(int empleado_fk) {
        this.empleado_fk = empleado_fk;
    }

    
}
