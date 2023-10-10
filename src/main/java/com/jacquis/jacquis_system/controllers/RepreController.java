package com.jacquis.jacquis_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacquis.jacquis_system.services.RepresentanteService;

@Controller
public class RepreController {

    @Autowired
    private RepresentanteService representanteService;
    
    private void representante(Model model) {
        model.addAttribute("contenido", "provRepre");
    } // carga la vista empleados.html

    @GetMapping("/representantes")
    public String mostrarRepresentante(Model modelo) {
        representante(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }
}
