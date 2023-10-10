package com.jacquis.jacquis_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.model.Representante;
import com.jacquis.jacquis_system.services.ProveedorService;
import com.jacquis.jacquis_system.services.RepresentanteService;

@Controller
// @RequestMapping("representantes")
public class RepreController {

    @Autowired
    private RepresentanteService representanteService;
    @Autowired
    private ProveedorService proveedorService;

    private void representantes(Model model) {
        model.addAttribute("contenido", "provRepre");
    } // carga la vista empleados.html

    @GetMapping("/representantes")
    public String mostrarRepresentantes(Model modelo) {
        modelo.addAttribute("representanteList", representanteService.getRepresentantes());
        representantes(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Muestra el formulario para crear un nuevo empleado
    private void nuevoRepreVista(Model model) {
        model.addAttribute("contenido", "nuevo_repre");
    } // carga la vista nuevo_repre.html

    @GetMapping("/representantes/nuevo")
    public String nuevoRepre(Model modelo) {
        Representante representante = new Representante();
        List<Proveedor> proveedorSelected = proveedorService.getProveedoreList();
        modelo.addAttribute("representantes", representante);
        modelo.addAttribute("proveedorSelected", proveedorSelected);
        nuevoRepreVista(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    private void editarRepreVista(Model model) {
        model.addAttribute("contenido", "edit_repre");
    } // carga la vista editar_empleado.html

    @PostMapping("/representantes")
    public String guardarRepresentantes(@ModelAttribute("representantes") Representante representante) {
        representante.setEstado_repre("ACTIVO");
        representanteService.saveOrUpdate(representante);
        return "redirect:/representantes";
    }

    // Muestra el formulario para editar un empleado
    @GetMapping("/representantes/editar/{id_repre}")
    public String editarRepre(@PathVariable("id_repre") Long idrepre, Model modelo) {
        Representante representante = representanteService.getRepresentanteById(idrepre);
        List<Proveedor> proveedorSelected = proveedorService.getProveedoreList();
        modelo.addAttribute("representantes", representante);
        modelo.addAttribute("proveedorSelected", proveedorSelected);
        editarRepreVista(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Actualiza un empleado
    @PostMapping("/representantes/{id_repre}")
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
     @GetMapping("/representates/baja/{id_repre}")
     public String bajaRepre(@PathVariable("id_repre") Long idrepre,Model modelo)
    {
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
