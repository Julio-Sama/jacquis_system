// package com.jacquis.jacquis_system.services;

// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.jacquis.jacquis_system.model.Usuario;

// public class CustomUserDetail implements UserDetails {

//     private Usuario usuario;

//     public CustomUserDetail(Usuario usuario) {
//         this.usuario = usuario;
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return List.of(() -> usuario.getRol_usuario());
//     }

//     @Override
//     public String getPassword() {
//         return usuario.getClave_usuario();
//     }

//     @Override
//     public String getUsername() {
//         return usuario.getNick_usuario();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true; // usuario.getEstado_usuario().equals("ACTIVO");
//     }

// }
