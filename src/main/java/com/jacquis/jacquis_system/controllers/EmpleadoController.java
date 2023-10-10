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

import com.jacquis.jacquis_system.model.Empleado;
import com.jacquis.jacquis_system.repository.EmpleadoRepository;
import com.jacquis.jacquis_system.services.EmpleadoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public String mostrarEmpleados(Model modelo) {
        modelo.addAttribute("empleadoList", empleadoService.getEmpleados());
        return "empleados"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    @GetMapping("/filtro")
    public String filtroEmpleado(Model modelo,
            @RequestParam(name = "mostrarInactivos", defaultValue = "false") boolean mostrarInactivos) {
        List<Empleado> empleadoList = empleadoService.getEmpleados();

        if (!mostrarInactivos) {
            empleadoList = empleadoList.stream()
                    .filter(empleado -> !empleado.getEstado_empleado().equals("INACTIVO"))
                    .collect(Collectors.toList());
        }
        modelo.addAttribute("empleadoList", empleadoList);
        return "empleados :: tablaEmpleados";// retorna al archivo index.html con los datos cargados en el modelo
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleado(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleados", empleado);

        return "nuevo_empleado"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Guarda o actualiza un empleado
    @PostMapping
    public String guardarEmpleado(@Valid @ModelAttribute("empleados") Empleado empleado, Errors errores) {

        if (errores.hasErrors()) {
            return "nuevo_empleado";
        } else {
            int count = empleadoRepository.countEmpleadosByDui(empleado.getDuiEmpleado());
            if (count > 0) {
                errores.rejectValue("duiEmpleado", "duiEmpleado.duplicate", "El DUI ya existe en la base de datos");
                return "nuevo_empleado";
            } else {
                empleado.setEstado_empleado("ACTIVO");
                empleadoService.saveOrUpdate(empleado);
                return "redirect:/empleados";
            }
        }

        // return "redirect:/empleados";
    }

    // Muestra el formulario para editar un empleado
    @GetMapping("/editar/{id_empleado}")
    public String editarEmpleado(@PathVariable("id_empleado") Long idEmpleado, Model modelo) {
        Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
        modelo.addAttribute("empleados", empleado);

        return "edit_empleados"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    // Actualiza un empleado
    @PostMapping("/{id_empleado}")
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
    @GetMapping("/baja/{id_empleado}")
    public String bajaEmpleado(@PathVariable("id_empleado") Long idEmpleado, Model modelo) {
        Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
        modelo.addAttribute("id_empleado", empleado.getId_empleado());
        empleado.setEstado_empleado("INACTIVO");

        empleadoService.saveOrUpdate(empleado);
        return "redirect:/empleados";
    }

    // // Elimina un empleado
    // @DeleteMapping("/empleados/{id_empleado}")
    // public String eliminarEmpleado(@PathVariable("id_empleado") Long idEmpleado)
    // {
    // empleadoService.delete(idEmpleado);
    // return "redirect:/index/empleados";
    // }

}