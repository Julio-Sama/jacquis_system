package com.jacquis.jacquis_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nick_usuario;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "La contraseña debe tener al menos 8 caracteres, y debe contener al menos una letra mayúscula, una minúscula, un número y un caracter especial")
    private String clave_usuario;

    private String estado_usuario;

    private String rol_usuario;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String nick_usuario, String clave_usuario, String estado_usuario,
            String rol_usuario) {
        this.nick_usuario = nick_usuario;
        this.clave_usuario = clave_usuario;
        this.estado_usuario = estado_usuario;
        this.rol_usuario = rol_usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

}
