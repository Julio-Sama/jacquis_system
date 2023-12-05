package com.jacquis.jacquis_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventario")
public class InventarioController {
    
    // @Autowired
    // private InventarioService inventarioService;

    // @Autowired
    // private InventarioRepository inventarioRepository;

    // @GetMapping
    // public String mostrarInventario(Model modelo) {
    //     modelo.addAttribute("inventarioList", inventarioService.getInventario());
    //     return "inventario"; // retorna al archivo index.html con los datos cargados en el modelo
    // }

    @GetMapping
    public String mostrarInventario() {
        return "inventario"; // retorna al archivo index.html con los datos cargados en el modelo
    }
}
