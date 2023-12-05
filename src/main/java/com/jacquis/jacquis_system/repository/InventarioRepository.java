package com.jacquis.jacquis_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jacquis.jacquis_system.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    @Query(value = "SELECT COUNT(*) FROM producto WHERE codigo_producto = :codigo_producto", nativeQuery = true)
    int countByCodigo_producto(@Param("codigo_producto") String codigo_producto);
    // int countEmpleadosByDui(@Param("dui") String dui);
}
