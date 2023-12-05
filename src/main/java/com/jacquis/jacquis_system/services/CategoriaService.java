package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Categoria;
import com.jacquis.jacquis_system.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public boolean existsById(Long id) {
        return categoriaRepository.existsById(id);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    
}
