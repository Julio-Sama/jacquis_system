package com.jacquis.jacquis_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jacquis.jacquis_system.model.Cliente;
import com.jacquis.jacquis_system.model.Empleado;
import com.jacquis.jacquis_system.model.Venta;
import com.jacquis.jacquis_system.services.ClienteService;
import com.jacquis.jacquis_system.services.EmpleadoService;
import com.jacquis.jacquis_system.services.VentaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/nueva")
    public String nuevaVenta(Model modelo) {
        Venta venta = new Venta();
        modelo.addAttribute("venta", venta);

        System.out.println("venta: " + venta);

        List<Empleado> empleadoSelected = empleadoService.getEmpleados();
        List<Cliente> clienteSelected = clienteService.getClientes();

        System.out.println("empleadoSelected: " + empleadoSelected.size());
        System.out.println("clienteSelected: " + clienteSelected.size());

        modelo.addAttribute("empleadoSelected", empleadoSelected);
        modelo.addAttribute("clienteSelected", clienteSelected);

        return "nueva_venta";
    }

    // @PostMapping
    // public String guardarVenta(@Valid @ModelAttribute("ventas") Venta venta, 
    //     Errors errores) {
    //     if (errores.hasErrors()) {
    //         return "nueva";
    //     } else {
    //         ventaService.saveOrUpdate(venta);
    //         return "redirect:/nuevaVenta";
    //     }
    // }
}
