package com.jacquis.jacquis_system.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacquis.jacquis_system.model.Empleado;
import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.repository.EmpleadoRepository;
import com.jacquis.jacquis_system.repository.ProveedorRepository;
import com.jacquis.jacquis_system.services.DatabasePDFService;
import com.jacquis.jacquis_system.services.EmpleadoPDFService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PDFExportController {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @GetMapping(value = "/openpdf/proveedores", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> proveedorReport() throws IOException {
        List<Proveedor> proveedor = (List<Proveedor>) proveedorRepository.findAll();
        byte[] pdfBytes = DatabasePDFService.proveedorPDFReport(proveedor);
        //ByteArrayInputStream bis = DatabasePDFService.proveedorPDFReport(proveedor);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=reporte_proveedores.pdf");

        return ResponseEntity
        .ok()
        .headers(headers)
        .contentType(MediaType.APPLICATION_PDF)
        .body(new InputStreamResource(new ByteArrayInputStream(pdfBytes)));

        //return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
               // .body(new InputStreamResource(bis));
    }

    @GetMapping(value="/openpdf/empleados", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> empleadoReport() throws IOException  {
        List<Empleado> empleado = (List<Empleado>) empleadoRepository.findAll();

        ByteArrayInputStream bis = EmpleadoPDFService.empleadoPDFReport(empleado);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=reporte_empleados.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
    
}
