// package com.jacquis.jacquis_system.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.jacquis.jacquis_system.dto.UsuarioDTO;
// import com.jacquis.jacquis_system.model.Usuario;
// import com.jacquis.jacquis_system.repository.UsuarioRepository;

// @Service
// public class UsuarioServiceImpl implements UsuarioService {

//     // @Autowired
//     // private PasswordEncoder passwordEncoder;

//     @Autowired
//     private UsuarioRepository usuarioRepository;

//     @Override
//     public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
//         Usuario usuario = new Usuario(usuarioDTO.getNick_usuario(),
//                 passwordEncoder.encode(usuarioDTO.getClave_usuario()), usuarioDTO.getEstado_usuario(),
//                 usuarioDTO.getRol_usuario());
//         return usuarioRepository.save(usuario);
//     }

// }