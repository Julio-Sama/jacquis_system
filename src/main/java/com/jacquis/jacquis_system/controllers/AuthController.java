package com.jacquis.jacquis_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
// @RequestMapping("/")
public class AuthController {

    @GetMapping({"/index", "/"})
    public String dashboard(Model model) {
        model.addAttribute("contenido", "layout");
        return "index";
    }

    // @GetMapping("/empleados")
    // public String empleados(Model model) {
    //     model.addAttribute("contenido", "empleados");
    //     return "index";
    // }
    
    
}
