package com.jacquis.jacquis_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jacquis.jacquis_system.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Usuario findUsuarioByNick_usuario(String nick_usuario);

    @Query("SELECT u FROM Usuario u WHERE u.nick_usuario = :nick_usuario")
    Usuario findUsuarioByNick_usuario(@Param("nick_usuario") String nick_usuario);
}
