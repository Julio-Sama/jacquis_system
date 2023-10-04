package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Representante;
import com.jacquis.jacquis_system.repository.RepreRepository;

@Service
public class RepresentanteService {
    
    @Autowired
    private RepreRepository repreRepository;

    public List<Representante> getRepresentantes() {
        return repreRepository.findAll();
    }

    public Representante getRepresentanteById(Long id) {
        return repreRepository.findById(id).orElse(null);
    }

    public void guardarActualizar(Representante representante) {
        repreRepository.save(representante);
    }

    public void eliminar(Long id) {
        repreRepository.deleteById(id);
    }
}
