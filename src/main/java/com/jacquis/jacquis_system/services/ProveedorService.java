package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.repository.ProveedorRepository;


@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedoreList() {
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Proveedor proveedor) {
       proveedorRepository.save(proveedor);
    }

}