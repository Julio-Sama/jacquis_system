package com.jacquis.jacquis_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacquis.jacquis_system.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
