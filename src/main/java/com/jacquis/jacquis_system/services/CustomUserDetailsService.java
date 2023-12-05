// package com.jacquis.jacquis_system.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.jacquis.jacquis_system.model.Usuario;
// import com.jacquis.jacquis_system.repository.UsuarioRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService{

//     @Autowired
//     private UsuarioRepository usuarioRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Usuario usuario = usuarioRepository.findUsuarioByNick_usuario(username);
//         if(usuario == null) {
//             throw new UsernameNotFoundException("Usuario no encontrado");
//         }
//         return new CustomUserDetail(usuario);
//     }
    
// }
