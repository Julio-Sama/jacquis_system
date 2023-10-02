package com.jacquis.jacquis_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jacquis.jacquis_system.model.Empleado;
import com.jacquis.jacquis_system.services.EmpleadoService;

@Controller
// @RequestMapping("empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    private void empleados(Model model) {
        model.addAttribute("contenido", "empleados");
    } // carga la vista empleados.html

    @GetMapping("/empleados")
    public String mostrarEmpleados(Model modelo) {
        modelo.addAttribute("empleadoList", empleadoService.getEmpleados());
        empleados(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Muestra el formulario para crear un nuevo empleado
    private void nuevoEmpleadoVista(Model model) {
        model.addAttribute("contenido", "nuevo_empleado");
    } // carga la vista nuevo_empleado.html

    @GetMapping("/empleados/nuevo")
    public String nuevoEmpleado(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleados", empleado);
        nuevoEmpleadoVista(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Guarda o actualiza un empleado
    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleados") Empleado empleado) {
        empleadoService.saveOrUpdate(empleado);
        return "redirect:/index";
    }

    // Muestra el formulario para editar un empleado
    @GetMapping("/empleados/{id_empleado}")
    public Empleado getEmpleado(@PathVariable("id_empleado") Long idEmpleado) {
        return empleadoService.getEmpleadoById(idEmpleado);
    }

    // Elimina un empleado
    @DeleteMapping("/{id_empleado}")
    public void eliminar(@PathVariable("id_empleado") Long idEmpleado) {
        empleadoService.delete(idEmpleado);
    }

}
