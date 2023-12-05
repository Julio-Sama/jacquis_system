package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.EstadoProducto;
import com.jacquis.jacquis_system.repository.EstadoProductoRepository;

@Service
public class EstadoProductoService {
    
    @Autowired
    private EstadoProductoRepository estadoProductoRepository;

    public List<EstadoProducto> getEstadoProductos() {
        return estadoProductoRepository.findAll();
    }

    public EstadoProducto getEstadoProductoById(Long id) {
        return estadoProductoRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(EstadoProducto estadoProducto) {
        estadoProductoRepository.save(estadoProducto);
    }

    public boolean existsById(Long id) {
        return estadoProductoRepository.existsById(id);
    }

    public void delete(Long id) {
        estadoProductoRepository.deleteById(id);
    }
}
