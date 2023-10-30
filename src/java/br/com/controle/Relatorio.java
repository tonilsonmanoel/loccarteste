/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */
public class Relatorio {
    
    public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws IOException{
          response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename="+ "testPDF.pdf");

        try {
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdfDocument = new PdfDocument(writer);
              try (Document document = new Document(pdfDocument)) {
             
                  document.add(new Paragraph("Este é um documento PDF gerado por uma Servlet usando o iText 7."));
              }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
