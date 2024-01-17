package com.jacquis.jacquis_system.controllers;

import java.util.List;

import org.apache.coyote.ErrorState;
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
    private final VentaService venta;

    public VentaController(VentaService venta) {
        this.venta = venta;
    }

    @Autowired
    private VentaService ventaService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String nuevoVenta(Model modelo) {
        Venta venta = new Venta();
        List<Empleado> empleadoSelected = empleadoService.getEmpleados();
        List<Cliente> clienteSelected = clienteService.getClientes();
        modelo.addAttribute("venta", venta);
        modelo.addAttribute("empleadoSelected", empleadoSelected);
        modelo.addAttribute("clienteSelected", clienteSelected);

        return "nuevaVenta";
    }

    @PostMapping
    public String guardarVenta(@Valid @ModelAttribute("venta") Venta venta, 
        Errors errores) {
        if (errores.hasErrors()) {
            return "nueva";
        } else {
            ventaService.saveOrUpdate(venta);
            return "redirect:/venta";
        }
    }
}
