package com.jacquis.jacquis_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class AuthController {

    // @Autowired
    // UserDetailsService userDetailsService;

    // @Autowired
    // private UsuarioService usuarioService;

    // @GetMapping("/registrar")
    // public String getRegistrarPage(@ModelAttribute("usuario") UsuarioDTO usuario) {
    //     return "register";
    // }

    // @PostMapping("/registrar")
    // public String registrar(@ModelAttribute("usuario") UsuarioDTO usuarioDTO, Model model) {
    //     usuarioService.crearUsuario(usuarioDTO);
    //     model.addAttribute("message", "Usuario creado exitosamente");
    //     return "register";
    // }

    @GetMapping("/index")
    public String getLoginPage() {
        return "index";
    }

    // @GetMapping("/user-page")
    // public String userPage (Model model, Principal principal) {
    //     UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    //     model.addAttribute("usuario", userDetails);
    //     return "user_page";
    // }

    // @GetMapping("/admin-page")
    // public String adminPage (Model model, Principal principal) {
    //     UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    //     model.addAttribute("usuario", userDetails);
    //     return "index";
    // }

    // @GetMapping("/empleados")
    // public String empleados(Model model) {
    //     model.addAttribute("contenido", "empleados");
    //     return "index";
    // }
    
    
}
