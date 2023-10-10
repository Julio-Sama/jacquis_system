package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }  

    public void guardarActualizar(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }

}