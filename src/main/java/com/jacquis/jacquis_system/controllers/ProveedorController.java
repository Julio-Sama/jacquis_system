package com.jacquis.jacquis_system.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.services.ProveedorService;

import jakarta.validation.Valid;

@Controller
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    private void proveedor(Model model) {
        model.addAttribute("contenido", "prov");
    } // carga la vista proveedor.html
    
    @GetMapping("/proveedores") 
    public String mostrarProveedor(Model modelo) {
        modelo.addAttribute("proveedorList", proveedorService.getProveedores());
        proveedor(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Muestra el formulario para crear un nuevo proveedor
    //private void nuevoProveedorVista(Model model) {
       // model.addAttribute("contenido", "nuevo_proveedor");
    //} // carga la vista nuevo_proveedor.html

    @GetMapping("/proveedores/nuevo")
    public String nuevoProveedor(Model modelo) {
        Proveedor proveedor = new Proveedor();
        modelo.addAttribute("contenido", "nuevo_proveedor");
        modelo.addAttribute("proveedores", proveedor);
        return "index";
    }

    // Guarda o actualiza un proveedor
    @PostMapping("/proveedores")
    public String guardarProveedor(@Valid @ModelAttribute("proveedores") Proveedor proveedor, Errors errors) {
        
        if (errors.hasErrors()){
            return "nuevo_proveedor";
        } else {
            proveedor.setEstado_prov("ACTIVO");

            Date fechaActual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            String fechaFormateada = sdf.format(fechaActual);

            // Convierte la cadena formateada de nuevo a Date
            try {
                Date fechaInicioProveedorUtil = sdf.parse(fechaFormateada);
                java.sql.Date fechaInicioProveedor = new java.sql.Date(fechaInicioProveedorUtil.getTime());
                proveedor.setFecha_inicio_proveedor(fechaInicioProveedor);
            } catch (java.text.ParseException e) {
            // Maneja la excepción si ocurre un error de formato
            e.printStackTrace();    
            }
        
        proveedorService.guardarActualizar(proveedor);
        return "redirect:/proveedores";
        }
    }

    private void editarProveedorVista(Model model) {
        model.addAttribute("contenido", "edit_proveedores");
    } // carga la vista editar_prov.html

    // Muestra el formulario para editar un proveedor
    @GetMapping("/proveedores/editar/{id_proveedor}")
    public String editarProveedor(@PathVariable("id_proveedor") Long idProveedor, Model modelo) {
        Proveedor proveedor = proveedorService.getProveedorById(idProveedor);
        modelo.addAttribute("proveedores", proveedor);
        editarProveedorVista(modelo);
        return "index";
    }

    //Actualiza un proveedor
    @PostMapping("/proveedores/{id_proveedor}")
    public String actualizarProveedor(@PathVariable("id_proveedor") Long idProveedor, 
            @ModelAttribute("proveedores") Proveedor proveedor) {
        Proveedor proveedorActual = proveedorService.getProveedorById(idProveedor);
        proveedorActual.setNombre(proveedor.getNombre());
        proveedorActual.setDireccion(proveedor.getDireccion());
        proveedorActual.setCorreo(proveedor.getCorreo());
        proveedorService.guardarActualizar(proveedorActual);
        return "redirect:/proveedores";
    }

    //Dar de baja un proveedor
    @GetMapping("/proveedores/baja/{id_proveedor}")
    public String bajaProveedor(@PathVariable("id_proveedor") Long idProveedor, Model modelo) {
        Proveedor proveedor = proveedorService.getProveedorById(idProveedor);
        proveedor.setEstado_prov("INACTIVO");
        proveedorService.guardarActualizar(proveedor);
        return "redirect:/index/proveedores";
    }

}
