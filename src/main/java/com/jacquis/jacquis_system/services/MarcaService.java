package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Marca;
import com.jacquis.jacquis_system.repository.MarcaRepository;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getMarcas() {
        return marcaRepository.findAll();
    }

    public Marca getMarcaById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Marca marca) {
        marcaRepository.save(marca);
    }

    public boolean existsById(Long id) {
        return marcaRepository.existsById(id);
    }

    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }
}
