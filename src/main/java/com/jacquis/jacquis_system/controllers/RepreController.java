package com.jacquis.jacquis_system.controllers;

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
import com.jacquis.jacquis_system.model.Representante;
import com.jacquis.jacquis_system.services.ProveedorService;
import com.jacquis.jacquis_system.services.RepresentanteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("representantes")
public class RepreController {

    @Autowired
    private RepresentanteService representanteService;
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String mostrarRepresentantes(Model modelo) {
        modelo.addAttribute("representanteList", representanteService.getRepresentantes());
        return "provRepre";
    }

    @GetMapping("/filtro")
    public String filtroRepre(Model modelo,
            @RequestParam(name = "mostrarInactivosRepre", defaultValue = "false") boolean mostrarInactivosRepre) {
        List<Representante> representanteList = representanteService.getRepresentantes();

        if (!mostrarInactivosRepre) {
            representanteList = representanteList.stream()
                    .filter(repre -> !repre.getEstado_repre().equals("INACTIVO"))
                    .collect(Collectors.toList());
        }
        modelo.addAttribute("representanteList", representanteList);
        return "provRepre :: tablaRepre";// retorna al archivo index.html con los datos cargados en el modelo
    }

    @GetMapping("/nuevo")
    public String nuevoRepre(Model modelo) {
        Representante representante = new Representante();
        List<Proveedor> proveedorSelected = proveedorService.getProveedoreList();
        modelo.addAttribute("representantes", representante);
        modelo.addAttribute("proveedorSelected", proveedorSelected);
        return "nuevo_repre"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    @PostMapping
    public String guardarRepresentantes(@Valid @ModelAttribute("representantes") Representante representante,
            Errors errores) {

        if (errores.hasErrors()) {
            return "nuevo_repre";
        } else {
            representante.setEstado_repre("ACTIVO");
            representanteService.saveOrUpdate(representante);
            return "redirect:/representantes";
        }
    }

    // Muestra el formulario para editar un empleado
    @GetMapping("/editar/{id_repre}")
    public String editarRepre(@PathVariable("id_repre") Long idrepre, Model modelo) {
        Representante representante = representanteService.getRepresentanteById(idrepre);
        List<Proveedor> proveedorSelected = proveedorService.getProveedoreList();
        modelo.addAttribute("representantes", representante);
        modelo.addAttribute("proveedorSelected", proveedorSelected);
        return "edit_repre"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Actualiza un empleado
    @PostMapping("/{id_repre}")
    public String actualizarRepre(@PathVariable("id_repre") Long idrepre,
            @ModelAttribute("representantes") Representante representante) {
        Representante repreActual = representanteService.getRepresentanteById(idrepre);
        repreActual.setNombre(representante.getNombre());
        repreActual.setApellido(representante.getApellido());
        repreActual.setFecha_inicio_repre(representante.getFecha_inicio_repre());
        repreActual.setProveedor(representante.getProveedor());

        // empleadoActual.setEstado_empleado(empleado.getEstado_empleado());
        representanteService.saveOrUpdate(repreActual);
        return "redirect:/representantes";
    }

    // Dar de baja un empleado
    @GetMapping("/baja/{id_repre}")
    public String bajaRepre(@PathVariable("id_repre") Long idrepre, Model modelo) {
        Representante representante = representanteService.getRepresentanteById(idrepre);
        representanteService.getRepresentanteById(idrepre);
        representante.setEstado_repre("INACTIVO");
        representanteService.saveOrUpdate(representante);
        return "redirect:/representantes";
    }
}

// // Elimina un empleado
// @DeleteMapping("/empleados/{id_empleado}")
// public String eliminarEmpleado(@PathVariable("id_empleado") Long idEmpleado)
// {
// empleadoService.delete(idEmpleado);
// return "redirect:/index/empleados";
// }