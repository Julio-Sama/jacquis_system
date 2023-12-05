package com.jacquis.jacquis_system.services;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.common.usermodel.fonts.FontFamily;

import com.jacquis.jacquis_system.model.Proveedor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class DatabasePDFService {
 
    public static byte[] proveedorPDFReport(List<Proveedor> proveedor) {
        Document document = new Document(); 
        ByteArrayOutputStream out = new ByteArrayOutputStream();
 
        

        try {   
            PdfWriter.getInstance(document, out).setPdfVersion(PdfWriter.PDF_VERSION_1_7);   
            document.open();
 
            // Add Content to PDF file ->
            //Font fontHeader = FontFactory.getFont(FontFactory.defaultEncoding, 15);
            //Paragraph para = new Paragraph("Informe de proveedores - Jacquis Store", fontHeader);
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLACK);
            Paragraph title = new Paragraph("Informe de Proveedores - Jacquis Store", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            //para.setAlignment(Element.ALIGN_CENTER);
            //document.add(para);
            document.add(Chunk.NEWLINE);
 
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            float[] columnWidths = { 1f, 2f, 2f, 3f, 2f}; // Ajusta los pesos según tus necesidades
            table.setWidths(columnWidths);
            
            // Add PDF Table Header ->
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Stream.of("ID","Nombre", "Direccion", "Correo", "Fecha ingreso").forEach(columnTitle -> {
                PdfPCell header = new PdfPCell();
                header.setBackgroundColor(new Color(46, 49, 146)); // Cambiar el color de fondo del encabezado
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(1);
                        header.setPhrase(new Phrase(columnTitle, headerFont));
                        table.addCell(header);
            });

            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.BLACK);
            proveedor.forEach(prov -> {
                table.addCell(createCell(String.valueOf(prov.getId_proveedor()), contentFont, true));
                table.addCell(createCell(prov.getNombre(), contentFont, false));
                table.addCell(createCell(prov.getDireccion(), contentFont, false));
                table.addCell(createCell(prov.getCorreo(), contentFont, false));
                table.addCell(createCell(formatDate(prov.getFecha_inicio_proveedor()), contentFont, false));
            });
 
            /*for (Proveedor prov : proveedor) {  
                PdfPCell id = new PdfPCell(new Phrase(prov.getId_proveedor().toString()));
                id.setVerticalAlignment(Element.ALIGN_MIDDLE);
                id.setHorizontalAlignment(Element.ALIGN_CENTER);
                id.setBorderWidth(borderWidth);
                id.setPadding(padding);
                table.addCell(id);
 
                PdfPCell nombrePDF = new PdfPCell(new Phrase(prov.getNombre()));
                nombrePDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nombrePDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                nombrePDF.setBorderWidth(borderWidth);
            nombrePDF.setPadding(padding);
            table.addCell(nombrePDF);
 
                 PdfPCell direccionPDF = new PdfPCell(new Phrase(String.valueOf(prov.getDireccion())));
                direccionPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                direccionPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                direccionPDF.setBorderWidth(borderWidth);
                direccionPDF.setPadding(padding);
                table.addCell(direccionPDF);
 
                PdfPCell correoPDF = new PdfPCell(new Phrase(String.valueOf(prov.getCorreo())));
                correoPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                correoPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                correoPDF.setBorderWidth(borderWidth);
                correoPDF.setPadding(padding);
                table.addCell(correoPDF);
 
                PdfPCell estadoPDF = new PdfPCell(new Phrase(String.valueOf(prov.getEstado_prov())));
                estadoPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                estadoPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                estadoPDF.setBorderWidth(borderWidth);
                estadoPDF.setPadding(padding);
                table.addCell(estadoPDF);

                PdfPCell fechaIngresoPDF = new PdfPCell(new Phrase(String.valueOf(prov.getFecha_inicio_proveedor().toString())));
                fechaIngresoPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                fechaIngresoPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                fechaIngresoPDF.setBorderWidth(borderWidth);
                fechaIngresoPDF.setPadding(padding);
                table.addCell(fechaIngresoPDF);
                
            }*/
            document.add(table);
            
            
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
 
        return out.toByteArray();
    }

    private static PdfPCell createCell(String content, Font font, boolean isFirstColumn) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));

        // Configurar el ancho de la primera columna (ID)
        if (isFirstColumn) {
            
             // Ajusta la altura según tus necesidades
        }
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(1);
        return cell;
    }

    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
