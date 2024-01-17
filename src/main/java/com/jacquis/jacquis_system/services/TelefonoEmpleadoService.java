package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacquis.jacquis_system.model.TelefonoEmpleado;
import com.jacquis.jacquis_system.repository.TelefonoEmpleadoRepository;

@Service
public class TelefonoEmpleadoService {
    

    @Autowired
    private TelefonoEmpleadoRepository telefonoEmpleadoRepository;

    public List<TelefonoEmpleado> getTelefonoEmpleados() {
        return telefonoEmpleadoRepository.findAll();
    }

    public TelefonoEmpleado getTelefonoEmpleadoById(Integer id) {
        return telefonoEmpleadoRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(TelefonoEmpleado telefonoEmpleado) {
        telefonoEmpleadoRepository.save(telefonoEmpleado);
    }

    public boolean existsById(Integer id) {
        return telefonoEmpleadoRepository.existsById(id);
    }

    public void delete(Integer id) {
        telefonoEmpleadoRepository.deleteById(id);
    }
}
