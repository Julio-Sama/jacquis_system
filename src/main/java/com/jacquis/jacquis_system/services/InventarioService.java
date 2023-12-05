package com.jacquis.jacquis_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.jacquis.jacquis_system.model.Inventario;
import com.jacquis.jacquis_system.repository.InventarioRepository;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class InventarioService {
    
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Inventario inventario) {
        inventarioRepository.save(inventario);
        generateBarcode(inventario.getCodigo_producto());
    }

    public boolean existsById(Long id) {
        return inventarioRepository.existsById(id);
    }

    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }

    public void generateBarcode(String codigo_producto){
        try {
            BitMatrix bitMatrix = new Code128Writer().encode(codigo_producto, BarcodeFormat.CODE_128, 300, 150);
            Path path = Paths.get("C:\\xampp\\htdocs\\Barcodes\\"+codigo_producto+".png");
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
