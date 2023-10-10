package com.jacquis.jacquis_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jacquis.jacquis_system.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
 //@Query("SELECT p FROM proveedor p WHERE p.id_proveedor NOT IN (SELECT r.id_proveedor FROM Representante r WHERE r.id_proveedor IS NOT NULL)")
    
}
