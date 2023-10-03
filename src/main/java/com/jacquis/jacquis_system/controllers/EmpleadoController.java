package com.jacquis.jacquis_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        empleado.setEstado_empleado("ACTIVO");
        empleadoService.saveOrUpdate(empleado);
        return "redirect:/index/empleados";
    }

    private void editarEmpleadoVista(Model model) {
        model.addAttribute("contenido", "edit_empleados");
    } // carga la vista editar_empleado.html

    // Muestra el formulario para editar un empleado
    @GetMapping("/empleados/editar/{id_empleado}")
    public String editarEmpleado(@PathVariable("id_empleado") Long idEmpleado, Model modelo) {
        Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
        modelo.addAttribute("empleados", empleado);
        editarEmpleadoVista(modelo);
        return "index"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Actualiza un empleado
    @PostMapping("/empleados/{id_empleado}")
    public String actualizarEmpleado(@PathVariable("id_empleado") Long idEmpleado,
            @ModelAttribute("empleados") Empleado empleado) {
        Empleado empleadoActual = empleadoService.getEmpleadoById(idEmpleado);
        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setDireccion(empleado.getDireccion());
        empleadoActual.setCorreo_empleado(empleado.getCorreo_empleado());
        // empleadoActual.setEstado_empleado(empleado.getEstado_empleado());
        empleadoService.saveOrUpdate(empleadoActual);
        return "redirect:/empleados";
    }

    // Dar de baja un empleado
    @GetMapping("/empleados/baja/{id_empleado}")
    public String bajaEmpleado(@PathVariable("id_empleado") Long idEmpleado, Model modelo) {
        Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
        empleado.setEstado_empleado("INACTIVO");
        empleadoService.saveOrUpdate(empleado);
        return "redirect:/empleados";
    }

    // // Elimina un empleado
    // @DeleteMapping("/empleados/{id_empleado}")
    // public String eliminarEmpleado(@PathVariable("id_empleado") Long idEmpleado) {
    //     empleadoService.delete(idEmpleado);
    //     return "redirect:/index/empleados";
    // }

}