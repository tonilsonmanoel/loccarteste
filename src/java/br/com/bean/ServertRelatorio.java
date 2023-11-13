/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterLocacoes;
import br.com.controle.Locacoes;
import br.com.controle.Relatorio;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */
public class ServertRelatorio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("application/pdf");
      //  response.setHeader("Content-Disposition", "attachment; filename=arquivo.pdf");
       /*
        try {
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.A4);
           
            Document document = new Document(pdfDocument);
            document.setMargins(15, 15, 15, 15);
            // Crie uma tabela com 2 colunas
            float twocol = 400f;
            
            
           float twocolumnWitch[]={twocol,twocol,20f};
           
           Table table= new Table(twocolumnWitch);
           
           table.setBackgroundColor(new DeviceRgb(63,169,219))
                   .setFontColor(Color.WHITE);
           
           table.addCell(new Cell().setHeight(70f).add("Relatorio").
                   setTextAlignment(TextAlignment.CENTER)
                   .setVerticalAlignment(VerticalAlignment.MIDDLE)
                   .setMarginTop(50f)
                   .setMarginBottom(50f)
                   .setFontSize(30f)
                   .setBorder(Border.NO_BORDER));
        
                   
           table.addCell(new Cell().add("Sarthi Technology\n# 3546 Ayodhya \n 9876543210")
                   .setTextAlignment(TextAlignment.RIGHT)
                   .setVerticalAlignment(VerticalAlignment.MIDDLE)
                   .setMarginTop(30f)
                   .setMarginBottom(30f)
                   .setMarginRight(30f)
                   .setBorder(Border.NO_BORDER)
                   
           );

           float colWidth[] = {80,300,100,80};
           
           Table customerInfoTable = new Table(colWidth);
           
           customerInfoTable.addCell(new Cell(0,4).add("Customer Information").setBold());

           customerInfoTable.addCell(new Cell().add("Name").setBorder(Border.NO_BORDER));
           customerInfoTable.addCell(new Cell().add("Raja shamar").setBorder(Border.NO_BORDER));
           customerInfoTable.addCell(new Cell().add("Invoice No.").setBorder(Border.NO_BORDER));
           customerInfoTable.addCell(new Cell().add("23").setBorder(Border.NO_BORDER));
           
           customerInfoTable.addCell(new Cell().add("Mo. No.").setBorder(Border.NO_BORDER));
           customerInfoTable.addCell(new Cell().add("9876543210").setBorder(Border.NO_BORDER));
           customerInfoTable.addCell(new Cell().add("Date:").setBorder(Border.NO_BORDER));
           customerInfoTable.addCell(new Cell().add("05-03-2021").setBorder(Border.NO_BORDER));
           
           
           float itemInfoColWidth[] = {140,140,140,140};
           
           Table itemInfoTable = new Table(itemInfoColWidth);
           
           itemInfoTable.addCell(new Cell().add("Service")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE));
           itemInfoTable.addCell(new Cell().add("Hrs.")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE));
           itemInfoTable.addCell(new Cell().add("Unit Price (INR)")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE));
           itemInfoTable.addCell(new Cell().add("Amout")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE));
           
           itemInfoTable.addCell(new Cell().add("App Creation"));
           itemInfoTable.addCell(new Cell().add("20"));
           itemInfoTable.addCell(new Cell().add("200"));
           itemInfoTable.addCell(new Cell().add(""+20*200));
           
           itemInfoTable.addCell(new Cell().add("Website Design"));
           itemInfoTable.addCell(new Cell().add("15"));
           itemInfoTable.addCell(new Cell().add("150"));
           itemInfoTable.addCell(new Cell().add(""+15*150));
           
           itemInfoTable.addCell(new Cell().add(""));
           itemInfoTable.addCell(new Cell().add(""));
           itemInfoTable.addCell(new Cell().add("Total Amount"));
           itemInfoTable.addCell(new Cell().add(""+15*200));
           
            float locTableColWidth[] = {150,200,200,200,200,200,200,200,200,200,200};
           
           Table locTable = new Table(locTableColWidth);
           
           locTable.addCell(new Cell().add("Cod.")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Cliente.")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Data Locação")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Data Termino")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Placa")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Automovel")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Cor")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Valor Diaria")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Valor Total")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Valor Pago")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Situação")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           
           Locacoes loc = new Locacoes();
            ManterLocacoes daoLoc = new ManterLocacoes();
           
           ArrayList<Locacoes> listaLoc =  daoLoc.pesquisaTudoLocacoes();
           
           for(int a = 0; a < listaLoc.size(); a++){
               loc= listaLoc.get(a);
               
               locTable.addCell(new Cell().add(String.valueOf(loc.getCodigo())).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getCliente()).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getData_inicioFormat()).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getData_terminoFormat()).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getPlaca()).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getModelo()).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getCor()).setFontSize(10));
           locTable.addCell(new Cell().add("R$ "+String.valueOf(loc.getValor_diaria())).setFontSize(10));
           locTable.addCell(new Cell().add("R$ "+String.valueOf(loc.getValor_locacao())).setFontSize(10));
           locTable.addCell(new Cell().add("R$ "+String.valueOf(loc.getValor_pago())).setFontSize(10));
           locTable.addCell(new Cell().add(loc.getStatusLocacoes())).setFontSize(10);
               
           }
         
         
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInfoTable);
            document.add(new Paragraph("\n"));
            document.add(itemInfoTable);
             document.add(new Paragraph("\n"));
             document.add(locTable);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
       String tipoRelatorio = request.getParameter("tipoRelatorio");
       Relatorio relatorios = new Relatorio();
       RequestDispatcher rd;
       switch(tipoRelatorio){
           case "locacoesRelatorio":
                String dataInicio = request.getParameter("dataLocacao");
                String dataFinal = request.getParameter("dataTermino");
                String modeloVeiculo = request.getParameter("modelo");
                String corVeiculo = request.getParameter("corVeiculo"); 
                String situacao = request.getParameter("situacao"); 
                String cliente = request.getParameter("cliente"); 

                
                relatorios.gerarPdfLocacoes(request, response,dataInicio,dataFinal,modeloVeiculo,corVeiculo,situacao,cliente);
                rd = request.getRequestDispatcher("relatorio.jsp");
                rd.forward(request, response);
                break;
           case "garagemRelatorio":
                String modelo = request.getParameter("modelo");
                String marca = request.getParameter("marca");
                String ano = request.getParameter("ano");
                String disponibilidade = request.getParameter("disponibilidade"); 
                relatorios.gerarPdfGaragem(request, response, modelo, marca, ano, disponibilidade);
                rd = request.getRequestDispatcher("relatoriogaragem.jsp");
                rd.forward(request, response);
                break;
           case "clientesRelatorio":
                relatorios.gerarPdfCliente(request, response);
                rd = request.getRequestDispatcher("relatoriocliente.jsp");
                rd.forward(request, response);
                break;
           case "funcionariosRelatorio":
                relatorios.gerarPdfFuncionarios(request, response);
                rd = request.getRequestDispatcher("relatoriofuncionarios.jsp");
                rd.forward(request, response);
                break;
           default:
               break;
       }
       
       
       
       
      
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}