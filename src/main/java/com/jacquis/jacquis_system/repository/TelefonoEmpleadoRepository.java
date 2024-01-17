package com.jacquis.jacquis_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacquis.jacquis_system.model.TelefonoEmpleado;

@Repository
public interface TelefonoEmpleadoRepository extends JpaRepository<TelefonoEmpleado, Integer> {
    
}
