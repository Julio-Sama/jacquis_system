package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Inventario;
import com.jacquis.jacquis_system.repository.InventarioRepository;

@Service
public class InventarioService {
    
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    public boolean existsById(Long id) {
        return inventarioRepository.existsById(id);
    }

    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }
}
