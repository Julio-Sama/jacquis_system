package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Talla;
import com.jacquis.jacquis_system.repository.TallaRepository;

@Service
public class TallaService {
    
    @Autowired
    private TallaRepository tallaRepository;

    public List<Talla> getTallas() {
        return tallaRepository.findAll();
    }

    public Talla getTallaById(Long id) {
        return tallaRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Talla talla) {
        tallaRepository.save(talla);
    }

    public boolean existsById(Long id) {
        return tallaRepository.existsById(id);
    }

    public void delete(Long id) {
        tallaRepository.deleteById(id);
    }
}
