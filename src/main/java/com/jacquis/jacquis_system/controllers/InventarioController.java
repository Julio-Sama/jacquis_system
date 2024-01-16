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

import com.jacquis.jacquis_system.model.Categoria;
import com.jacquis.jacquis_system.model.Inventario;
import com.jacquis.jacquis_system.model.Marca;
import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.model.Talla;
import com.jacquis.jacquis_system.repository.InventarioRepository;
import com.jacquis.jacquis_system.services.BarcodeService;
import com.jacquis.jacquis_system.services.CategoriaService;
import com.jacquis.jacquis_system.services.InventarioService;
import com.jacquis.jacquis_system.services.MarcaService;
import com.jacquis.jacquis_system.services.ProveedorService;
import com.jacquis.jacquis_system.services.TallaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/inventario")
public class InventarioController {
    private final BarcodeService barcodeService;
    private final InventarioService inventario;

    

    public InventarioController(BarcodeService barcodeService, InventarioService inventario) {
        this.barcodeService = barcodeService;
        this.inventario = inventario;
    }

    @Autowired
    private InventarioService inventarioService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private TallaService tallaService;


    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private InventarioRepository inventarioRepository;


    @GetMapping
    public String mostrarInventario(Model modelo) {
        modelo.addAttribute("inventarioList", inventarioService.getInventarios());
        return "inventario"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    @GetMapping("/filtro")
    public String filtroProductos(Model modelo,
            @RequestParam(name = "mostrarInactivos", defaultValue = "false") boolean mostrarInactivos) {
        List<Inventario> inventarioList = inventarioService.getInventarios();

        if (!mostrarInactivos) {
            inventarioList = inventarioList.stream()
                    .filter(inventario -> !inventario.getEstado_producto_p().equals("INACTIVO"))
                    .collect(Collectors.toList());
        }
        modelo.addAttribute("inventarioList", inventarioList);
        return "inventario :: tablaInventario";// retorna al archivo index.html con los datos cargados en el modelo
    }

    @GetMapping("/nuevo")
    public String nuevoProducto(Model modelo) {
        Inventario inventario = new Inventario();
        modelo.addAttribute("inventario", inventario);
        List<Proveedor> proveedorSelected = proveedorService.getProveedoreList();
        List<Categoria> categoriaSelected = categoriaService.getCategorias();
        List<Marca> marcaSelected = marcaService.getMarcas();
        List<Talla> tallaSelected = tallaService.getTallas();
        modelo.addAttribute("proveedorSelected", proveedorSelected);
        modelo.addAttribute("categoriaSelected", categoriaSelected);
        modelo.addAttribute("marcaSelected", marcaSelected);
        modelo.addAttribute("tallaSelected", tallaSelected);

        

        return "nuevo_producto"; // retorna al archivo index.html con los datos cargados en el modelo
    }

    @PostMapping
    public String guardarProducto(@Valid @ModelAttribute("inventario") Inventario inventario, Errors errores) {
        if (errores.hasErrors()) {
            return "nuevo_producto";
        } else {
            int count = inventarioRepository.countByCodigo_producto(inventario.getCodigo_producto());
            if (count > 0) {
                errores.rejectValue("codigo_producto", "inventario.duplicate", "El código de producto ya existe");
                return "nuevo_producto";
            } else {
                inventario.setEstado_producto_p("ACTIVO");
                inventarioService.saveOrUpdate(inventario);
                return "redirect:/inventario";
            }
        }
    }

    @GetMapping("/info/{id_producto}")
    public String infoProducto(@PathVariable("id_producto") Long id_producto, Model modelo) {
        Inventario inventario = inventarioService.getInventarioById(id_producto);
        List<Categoria> categoriaSelected = categoriaService.getCategorias();
        List<Proveedor> proveedorSelected = proveedorService.getProveedoreList();
        List<Marca> marcaSelected = marcaService.getMarcas();
        List<Talla> tallaSelected = tallaService.getTallas();
        modelo.addAttribute("tallaSelected", tallaSelected);
        modelo.addAttribute("marcaSelected", marcaSelected);
        modelo.addAttribute("proveedorSelected", proveedorSelected);
        modelo.addAttribute("categoriaSelected", categoriaSelected);
        modelo.addAttribute("inventario", inventario);
        
        return "info_up_del";
    }

    // Actualiza un producto
    @PostMapping("/{id_producto}")
    public String actualizarProducto(@PathVariable("id_producto") Long id_producto,
            @ModelAttribute("inventario") Inventario inventario) {
        Inventario inventarioActual = inventarioService.getInventarioById(id_producto);
        inventarioActual.setCodigo_producto(inventario.getCodigo_producto());
        inventarioActual.setDescripcion_producto(inventario.getDescripcion_producto());
        inventarioActual.setEstado_producto_p(inventario.getEstado_producto_p());
        // Tablas relacionadas
        inventarioActual.setProveedor(inventario.getProveedor());
        inventarioActual.setCategoria(inventario.getCategoria());
        inventarioActual.setTalla(inventario.getTalla());
        inventarioActual.setMarca(inventario.getMarca());


        inventarioService.saveOrUpdate(inventarioActual);
        return "redirect:/inventario";
    }

    @GetMapping("/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable("id_producto") Long id_producto) {
        inventarioService.delete(id_producto);
        return "redirect:/inventario";
    }

    @GetMapping("/baja/{id_producto}")
    public String bajaProducto(@PathVariable("id_producto") Long id_producto, Model modelo) {
        Inventario inventario = inventarioService.getInventarioById(id_producto);
        modelo.addAttribute("id_producto", inventario.getId_producto());
        inventario.setEstado_producto_p("INACTIVO");

        inventarioService.saveOrUpdate(inventario);
        return "redirect:/inventario";
    }


}
