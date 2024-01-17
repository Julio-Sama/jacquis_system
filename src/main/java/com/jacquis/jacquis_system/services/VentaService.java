package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Venta;
import com.jacquis.jacquis_system.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Venta venta) {
        ventaRepository.save(venta);
    }

    public boolean existsById(Long id) {
        return ventaRepository.existsById(id);
    }

    public void delete(Long id) {
        ventaRepository.deleteById(id);
    }

    
    
}
