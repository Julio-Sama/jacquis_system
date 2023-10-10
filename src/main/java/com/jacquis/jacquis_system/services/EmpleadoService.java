package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.Empleado;
import com.jacquis.jacquis_system.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public boolean existsById(Long id) {
        return empleadoRepository.existsById(id);
    }

    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }
}
