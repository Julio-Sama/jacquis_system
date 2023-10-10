package com.jacquis.jacquis_system.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacquis.jacquis_system.model.Proveedor;
import com.jacquis.jacquis_system.services.ExcelGenerator;
import com.jacquis.jacquis_system.services.ProveedorService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ExcelController {

    @Autowired
    private ProveedorService proveedorServ;

    @GetMapping("/export/excel/proveedores")
    public void exportToExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=proveedor" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Proveedor> proveedorList = proveedorServ.getProveedores();

        ExcelGenerator generator = new ExcelGenerator(proveedorList);
        generator.export(response);
    }
    
}