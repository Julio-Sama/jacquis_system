package com.jacquis.jacquis_system.dto;

import com.jacquis.jacquis_system.model.Empleado;

public class UsuarioDTO {

    private String nick_usuario;
    private String clave_usuario;
    private String estado_usuario;
    private String rol_usuario;
    private Empleado empleado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nick_usuario, String clave_usuario, String estado_usuario, String rol_usuario,
            Empleado empleado) {
        this.nick_usuario = nick_usuario;
        this.clave_usuario = clave_usuario;
        this.estado_usuario = estado_usuario;
        this.rol_usuario = rol_usuario;
        this.empleado = empleado;
    }

    public String getNick_usuario() {
        return nick_usuario;
    }

    public void setNick_usuario(String nick_usuario) {
        this.nick_usuario = nick_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
