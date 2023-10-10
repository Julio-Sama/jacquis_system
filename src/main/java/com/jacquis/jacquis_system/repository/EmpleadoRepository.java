package com.jacquis.jacquis_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jacquis.jacquis_system.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
    @Query(value = "SELECT COUNT(*) FROM empleado WHERE dui_empleado = :dui", nativeQuery = true)
    int countEmpleadosByDui(@Param("dui") String dui);
}
