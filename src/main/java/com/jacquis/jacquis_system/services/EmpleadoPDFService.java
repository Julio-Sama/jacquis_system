package com.jacquis.jacquis_system.services;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.apache.pdfbox.multipdf.PDFCloneUtility;
import org.apache.poi.common.usermodel.fonts.FontFamily;

import com.jacquis.jacquis_system.model.Empleado;
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

public class EmpleadoPDFService {
 
    public static ByteArrayInputStream empleadoPDFReport(List<Empleado> empleado) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
 
        try {   
            PdfWriter.getInstance(document, out);   
            document.open();
 
            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.defaultEncoding, 15);
            Paragraph para = new Paragraph("Informe de empleados - Jacquis Store", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
 
            PdfPTable table = new PdfPTable(6);
            // Add PDF Table Header ->
            Stream.of("ID","Nombres", "Apellidos", "Direccion", "Correo", "Estado Actual").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.defaultEncoding, 12);
                header.setBackgroundColor(Color.PINK);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });
 
            for (Empleado emp : empleado) {  
                PdfPCell id = new PdfPCell(new Phrase(emp.getId_empleado().toString()));
                id.setPaddingLeft(1);
                id.setVerticalAlignment(Element.ALIGN_MIDDLE);
                id.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(id);
 
                PdfPCell nombrePDF = new PdfPCell(new Phrase(emp.getNombre()));
                nombrePDF.setPaddingLeft(4);
                nombrePDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nombrePDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(nombrePDF);

                PdfPCell apellidoPDF = new PdfPCell(new Phrase(emp.getApellido()));
                apellidoPDF.setPaddingRight(4);
                apellidoPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                apellidoPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(apellidoPDF);
 
                PdfPCell direccionPDF = new PdfPCell(new Phrase(String.valueOf(emp.getDireccion())));
                direccionPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                direccionPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                direccionPDF.setPaddingRight(4);
                table.addCell(direccionPDF);
 
                PdfPCell correoPDF = new PdfPCell(new Phrase(String.valueOf(emp.getCorreo_empleado())));
                correoPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                correoPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                correoPDF.setPaddingRight(4);
                table.addCell(correoPDF);
 
                PdfPCell estadoPDF = new PdfPCell(new Phrase(String.valueOf(emp.getEstado_empleado())));
                estadoPDF.setVerticalAlignment(Element.ALIGN_MIDDLE);
                estadoPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
                estadoPDF.setPaddingRight(4);
                table.addCell(estadoPDF);

            }
            document.add(table);
            
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
 
        return new ByteArrayInputStream(out.toByteArray());
    }
}
