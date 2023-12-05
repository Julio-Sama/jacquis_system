package com.jacquis.jacquis_system.services;

import com.jacquis.jacquis_system.dto.UsuarioDTO;
import com.jacquis.jacquis_system.model.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(UsuarioDTO usuarioDTO);
}
