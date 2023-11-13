/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;
import br.com.DAO.ManterCliente;
import br.com.DAO.ManterFuncionario;
import br.com.DAO.ManterLocacoes;
import br.com.DAO.ManterVeiculo;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;


import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */


public class Relatorio {
    
    
    public void gerarPdfLocacoes(HttpServletRequest request, HttpServletResponse response,
           String dataInicio,String dataFinal,String modeloVeiculo,String corVeiculo,String situacao,String cliente){
       LocalDateTime now = LocalDateTime.now(); 
        response.setHeader("Content-Disposition", "attachment;filename="+ "Relatorio Locacoes "+now +".pdf");
        try {
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.A4);
           
            Document document = new Document(pdfDocument);
            document.setMargins(15, 15, 15, 15);
            // Crie uma tabela com 2 colunas
       
            
           float twocolumnWitch[]={400,400,400};
           
           Table table= new Table(twocolumnWitch);
          
           table.setBackgroundColor(new DeviceRgb(63,169,219))
                   .setFontColor(Color.WHITE);
           
           table.addCell(new Cell(0,3).setHeight(70f).add("Relatório").
                   setTextAlignment(TextAlignment.CENTER)
                   .setVerticalAlignment(VerticalAlignment.MIDDLE)
                   .setMarginTop(50f)
                   .setMarginBottom(50f)
                   .setFontSize(30f)
                   .setBorder(Border.NO_BORDER));
        
                   
           float colWidth[] = {80,300,100,80};
           
           Table customerInfoTable = new Table(colWidth);
           
           customerInfoTable.addCell(new Cell(0,4).add("Relatório Locações").setBold()
           .setTextAlignment(TextAlignment.CENTER));

           
           
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
           
           
           // criação tabela Locações do Relatorio 
           Locacoes loc = new Locacoes();
           Decimal descFomart = new Decimal();
           
           ManterLocacoes daoLocacoes = new ManterLocacoes();
           ArrayList<Locacoes> listaLoc;
           
            // pesquisar data de locações
            if((dataInicio != null && !dataInicio.isEmpty()) || (dataFinal != null && !dataFinal.isEmpty()) ){
                listaLoc = daoLocacoes.buscarDataLocacoes(dataInicio, dataFinal);
            } else{
                listaLoc =  daoLocacoes.pesquisaTudoLocacoes();
            }
            // fim pesquisar data de locações
           int ContadorRegisto = 0; 
            
           for(int a = 0; a < listaLoc.size(); a++){
               loc= listaLoc.get(a);
               boolean modeloEnc = (modeloVeiculo == null || modeloVeiculo.equals("")|| (loc.getModelo_id() == Integer.valueOf(modeloVeiculo)));
               boolean corEnc = (corVeiculo == null ||corVeiculo.equals("") || loc.getCor().contains(corVeiculo));
               boolean sit = (situacao == null ||situacao.equals("") || loc.getStatusLocacoes().contains(situacao));
               boolean clienteMatch = (cliente == null ||cliente.equals("") || loc.getCliente_id() == Integer.valueOf(cliente));
                    
               if(modeloEnc && corEnc && sit && clienteMatch){
                locTable.addCell(new Cell().add(String.valueOf(loc.getCodigo())).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getCliente()).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getData_inicioFormat()).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getData_terminoFormat()).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getPlaca()).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getModelo()).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getCor()).setFontSize(10));
                locTable.addCell(new Cell().add("R$ "+String.valueOf(descFomart.getDecimalFormat(loc.getValor_diaria()))).setFontSize(10));
                locTable.addCell(new Cell().add("R$ "+String.valueOf(descFomart.getDecimalFormat(loc.getValor_locacao()))).setFontSize(10));
                locTable.addCell(new Cell().add("R$ "+String.valueOf(descFomart.getDecimalFormat(loc.getValor_pago()))).setFontSize(10));
                locTable.addCell(new Cell().add(loc.getStatusLocacoes())).setFontSize(10); 
                
                ContadorRegisto +=1;
               }
           }
           
           if(ContadorRegisto == 0){
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).add("NENHUM REGISTRO ENCONTRADO!")
                        .setBorder(Border.NO_BORDER)
                        .setBorderLeft(new SolidBorder(1))
                        .setBorderRight(new SolidBorder(1))
                        .setTextAlignment(TextAlignment.CENTER));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)).setBorderBottom(new SolidBorder(1)));
           }
         
            // Fim criação tabela Locações do Relatorio 
           
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInfoTable);
            
             document.add(new Paragraph("\n"));
             document.add(locTable);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
    
    
    public void gerarPdfGaragem(HttpServletRequest request, HttpServletResponse response,
           String modelo,String marca,String ano,String disponibilidade){
       LocalDateTime now = LocalDateTime.now(); 
        response.setHeader("Content-Disposition", "attachment;filename="+ "Relatorio Veiculos "+now +".pdf");
        try {
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            Document document = new Document(pdfDocument);
            document.setMargins(15, 15, 15, 15);
            // Crie uma tabela com 2 colunas
       
            
           float twocolumnWitch[]={400,400,400};
           
           Table table= new Table(twocolumnWitch);
          
           table.setBackgroundColor(new DeviceRgb(63,169,219))
                   .setFontColor(Color.WHITE);
           
           table.addCell(new Cell(0,3).setHeight(70f).add("Relatório").
                   setTextAlignment(TextAlignment.CENTER)
                   .setVerticalAlignment(VerticalAlignment.MIDDLE)
                   .setMarginTop(50f)
                   .setMarginBottom(50f)
                   .setFontSize(30f)
                   .setBorder(Border.NO_BORDER));
        
                   
           float colWidth[] = {80,300,100,80};
           
           Table customerInfoTable = new Table(colWidth);
           
           customerInfoTable.addCell(new Cell(0,4).add("Relatório Veiculos").setBold()
           .setTextAlignment(TextAlignment.CENTER));

           
           
           float locTableColWidth[] = {150,200,200,200,200,200,200};
           
           Table locTable = new Table(locTableColWidth);
           
           locTable.addCell(new Cell().add("Cod.")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Placa")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Modelo")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Marca")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Ano")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Cor")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Disponibilidade")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           
           
           // criação tabela Locações do Relatorio 
          Veiculos vei = new Veiculos();
          ManterVeiculo  daoVeiculos = new ManterVeiculo();
          ArrayList<Veiculos> listVeiculos = daoVeiculos.pesquisaTudoVeiculo();
                  
           int ContadorRegisto = 0; 
          
           for(int a = 0; a < listVeiculos.size(); a++){
               vei= listVeiculos.get(a);
               boolean modeloMatch = (modelo == null || modelo.equals("")|| (vei.getModelo_id() == Integer.valueOf(modelo)));
               boolean marcaMatch  = (marca == null ||marca.equals("") || (vei.getMarcas().contains(marca)));
               boolean anoMatch  = (ano == null ||ano.equals("") ||(vei.getAno() == Integer.valueOf(ano)));
               boolean disponibilidadeMatch = (disponibilidade == null ||disponibilidade.equals("") || vei.getDisponibilidade().contains(disponibilidade));
                    
               if(modeloMatch && marcaMatch && anoMatch && disponibilidadeMatch){
               
                locTable.addCell(new Cell().add(String.valueOf(vei.getId())).setFontSize(10));
                locTable.addCell(new Cell().add(vei.getPlaca()).setFontSize(10));
                locTable.addCell(new Cell().add(vei.getModelo()).setFontSize(10));
                locTable.addCell(new Cell().add(vei.getMarcas()).setFontSize(10));
                locTable.addCell(new Cell().add(String.valueOf(vei.getAno())).setFontSize(10));
                locTable.addCell(new Cell().add(vei.getCor()).setFontSize(10));
                locTable.addCell(new Cell().add(vei.getDisponibilidade()).setFontSize(10));
                
                ContadorRegisto +=1;
               }
           }
           
           if(ContadorRegisto == 0){
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).add("NENHUM REGISTRO ENCONTRADO!")
                        .setBorder(Border.NO_BORDER)
                        .setBorderLeft(new SolidBorder(1))
                        .setBorderRight(new SolidBorder(1))
                        .setTextAlignment(TextAlignment.CENTER));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)).setBorderBottom(new SolidBorder(1)));
           }
         
            // Fim criação tabela Locações do Relatorio 
           
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInfoTable);
            
             document.add(new Paragraph("\n"));
             document.add(locTable);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
    
    public void gerarPdfCliente(HttpServletRequest request, HttpServletResponse response ){
       LocalDateTime now = LocalDateTime.now(); 
        response.setHeader("Content-Disposition", "attachment;filename="+ "Relatorio Clientes "+now +".pdf");
        try {
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            Document document = new Document(pdfDocument);
            document.setMargins(15, 15, 15, 15);
            // Crie uma tabela com 2 colunas
       
            
           float twocolumnWitch[]={400,400,400};
           
           Table table= new Table(twocolumnWitch);
          
           table.setBackgroundColor(new DeviceRgb(63,169,219))
                   .setFontColor(Color.WHITE);
           
           table.addCell(new Cell(0,3).setHeight(70f).add("Relatório").
                   setTextAlignment(TextAlignment.CENTER)
                   .setVerticalAlignment(VerticalAlignment.MIDDLE)
                   .setMarginTop(50f)
                   .setMarginBottom(50f)
                   .setFontSize(30f)
                   .setBorder(Border.NO_BORDER));
        
                   
           float colWidth[] = {80,300,100,80};
           
           Table customerInfoTable = new Table(colWidth);
           
           customerInfoTable.addCell(new Cell(0,4).add("Relatório Clientes").setBold()
           .setTextAlignment(TextAlignment.CENTER));

           
           
           float locTableColWidth[] = {100,200,200,200,200,200,200};
           
           Table locTable = new Table(locTableColWidth);
           
           locTable.addCell(new Cell().add("Cod.")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Nome")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("CPF")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Telefone")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Email")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
            locTable.addCell(new Cell().add("Endereço")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("CEP")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           
           
           // criação tabela Locações do Relatorio 
          Cliente cliente = new Cliente();
          ManterCliente daoCliente = new ManterCliente();
          ArrayList<Cliente> listCliente = daoCliente.pesquisarTudoCliente();
          

                  
           int ContadorRegisto = 0; 
          
           for(int a = 0; a < listCliente.size(); a++){
               cliente= listCliente.get(a);
                locTable.addCell(new Cell().add(String.valueOf(cliente.getCodigo())).setFontSize(10));
                locTable.addCell(new Cell().add(cliente.getNome()).setFontSize(10));
                locTable.addCell(new Cell().add(cliente.getCpf()).setFontSize(10));
                locTable.addCell(new Cell().add(cliente.getTelefone()).setFontSize(10));
                locTable.addCell(new Cell().add(cliente.getEmail()).setFontSize(10));
                locTable.addCell(new Cell().add(cliente.getEndereco()).setFontSize(10));
                locTable.addCell(new Cell().add(cliente.getCep()).setFontSize(10));
                
                ContadorRegisto +=1;
               
           }
           
           if(ContadorRegisto == 0){
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).add("NENHUM REGISTRO ENCONTRADO!")
                        .setBorder(Border.NO_BORDER)
                        .setBorderLeft(new SolidBorder(1))
                        .setBorderRight(new SolidBorder(1))
                        .setTextAlignment(TextAlignment.CENTER));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)).setBorderBottom(new SolidBorder(1)));
           }
         
            // Fim criação tabela Locações do Relatorio 
           
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInfoTable);
            
             document.add(new Paragraph("\n"));
             document.add(locTable);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
    
     public void gerarPdfFuncionarios(HttpServletRequest request, HttpServletResponse response
            ){
       LocalDateTime now = LocalDateTime.now(); 
        response.setHeader("Content-Disposition", "attachment;filename="+ "Relatorio Funcionarios "+now +".pdf");
        try {
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            Document document = new Document(pdfDocument);
            document.setMargins(15, 15, 15, 15);
            // Crie uma tabela com 2 colunas
       
            
           float twocolumnWitch[]={400,400,400};
           
           Table table= new Table(twocolumnWitch);
          
           table.setBackgroundColor(new DeviceRgb(63,169,219))
                   .setFontColor(Color.WHITE);
           
           table.addCell(new Cell(0,3).setHeight(70f).add("Relatório").
                   setTextAlignment(TextAlignment.CENTER)
                   .setVerticalAlignment(VerticalAlignment.MIDDLE)
                   .setMarginTop(50f)
                   .setMarginBottom(50f)
                   .setFontSize(30f)
                   .setBorder(Border.NO_BORDER));
        
                   
           float colWidth[] = {80,300,100,80};
           
           Table customerInfoTable = new Table(colWidth);
           
           customerInfoTable.addCell(new Cell(0,4).add("Relatório Funcionarios").setBold()
           .setTextAlignment(TextAlignment.CENTER));

           
           
           float locTableColWidth[] = {100,200,200,200,200,200,200};
           
           Table locTable = new Table(locTableColWidth);
         
           locTable.addCell(new Cell().add("Cod.")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Nome")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("CPF")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Telefone")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("Email")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
            locTable.addCell(new Cell().add("Endereço")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           locTable.addCell(new Cell().add("CEP")
           .setBackgroundColor(new DeviceRgb(65,169,219))
           .setFontColor(Color.WHITE)
           .setFontSize(12));
           
           
           // criação tabela Locações do Relatorio 
          
          
           Funcionario func = new Funcionario();
           ManterFuncionario daoFuncionario = new ManterFuncionario();
           ArrayList<Funcionario> listFuncionario = daoFuncionario.pesquisaTudoFuncionario();
           
                  
           int ContadorRegisto = 0; 
          
           for(int a = 0; a < listFuncionario.size(); a++){
               func= listFuncionario.get(a);
                locTable.addCell(new Cell().add(String.valueOf(func.getCodigo())).setFontSize(10));
                locTable.addCell(new Cell().add(func.getNome()).setFontSize(10));
                locTable.addCell(new Cell().add(func.getCpf()).setFontSize(10));
                locTable.addCell(new Cell().add(func.getTelefone()).setFontSize(10));
                locTable.addCell(new Cell().add(func.getEmail()).setFontSize(10));
                locTable.addCell(new Cell().add(func.getEndereco()).setFontSize(10));
                locTable.addCell(new Cell().add(func.getCep()).setFontSize(10));
                
                ContadorRegisto +=1;
               
           }
           
           if(ContadorRegisto == 0){
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).add("NENHUM REGISTRO ENCONTRADO!")
                        .setBorder(Border.NO_BORDER)
                        .setBorderLeft(new SolidBorder(1))
                        .setBorderRight(new SolidBorder(1))
                        .setTextAlignment(TextAlignment.CENTER));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)));
                locTable.addCell(new Cell(0,11).setBorder(Border.NO_BORDER).setBorderLeft(new SolidBorder(1)).setBorderRight(new SolidBorder(1)).setBorderBottom(new SolidBorder(1)));
           }
         
            // Fim criação tabela Locações do Relatorio 
           
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInfoTable);
            
             document.add(new Paragraph("\n"));
             document.add(locTable);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
    
}
