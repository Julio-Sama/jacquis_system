package com.jacquis.jacquis_system.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.services.ProveedorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String mostrarProveedor(Model modelo) {
        modelo.addAttribute("proveedorList", proveedorService.getProveedores());
        return "prov"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    @GetMapping("/filtro")
    public String filtroProveedor(Model modelo,
            @RequestParam(name = "mostrarInactivosProv", defaultValue = "false") boolean mostrarInactivosProv) {
        List<Proveedor> proveedorList = proveedorService.getProveedores();

        if (!mostrarInactivosProv) {
            proveedorList = proveedorList.stream()
                    .filter(proveedor -> !proveedor.getEstado_prov().equals("INACTIVO"))
                    .collect(Collectors.toList());
        }
        modelo.addAttribute("proveedorList", proveedorList);
        return "prov :: tablaProveedores";
    }

    @GetMapping("/nuevo")
    public String nuevoProveedor(Model modelo) {
        Proveedor proveedor = new Proveedor();
        modelo.addAttribute("proveedores", proveedor);
        return "nuevo_proveedor";
    }

    // Guarda o actualiza un proveedor
    @PostMapping
    public String guardarProveedor(@Valid @ModelAttribute("proveedores") Proveedor proveedor) {
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


    // Muestra el formulario para editar un proveedor
    @GetMapping("/editar/{id_proveedor}")
    public String editarProveedor(@PathVariable("id_proveedor") Long idProveedor, Model modelo) {
        Proveedor proveedor = proveedorService.getProveedorById(idProveedor);
        modelo.addAttribute("proveedores", proveedor);
        return "edit_proveedores";
    }

    // Actualiza un proveedor
    @PostMapping("/{id_proveedor}")
    public String actualizarProveedor(@PathVariable("id_proveedor") Long idProveedor,
            @ModelAttribute("proveedores") Proveedor proveedor) {
        Proveedor proveedorActual = proveedorService.getProveedorById(idProveedor);
        proveedorActual.setNombre(proveedor.getNombre());
        proveedorActual.setDireccion(proveedor.getDireccion());
        proveedorActual.setCorreo(proveedor.getCorreo());
        proveedorService.guardarActualizar(proveedorActual);
        return "redirect:/proveedores";
    }

    // Dar de baja un proveedor
    @GetMapping("/baja/{id_proveedor}")
    public String bajaProveedor(@PathVariable("id_proveedor") Long idProveedor, Model modelo) {
        Proveedor proveedor = proveedorService.getProveedorById(idProveedor);
        modelo.addAttribute("id_proveedor", proveedor.getId_proveedor());
        proveedor.setEstado_prov("INACTIVO");
        
        proveedorService.guardarActualizar(proveedor);
        return "redirect:/proveedores";
    }

}
