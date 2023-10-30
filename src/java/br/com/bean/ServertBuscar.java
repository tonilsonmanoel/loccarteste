/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterLocacoes;
import br.com.controle.Locacoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */
public class ServertBuscar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String marca="todos";
           if(!"todos".equals(request.getParameter("modeloVeiculo"))){
               marca = " M.nome='"+request.getParameter("modeloVeiculo")+"'";
           }
           
           String buscar ="";
           Locacoes loc = new Locacoes();
            ManterLocacoes daoLoc = new ManterLocacoes();
            
           ArrayList<Locacoes> listarLoc ;
           
           
           if(marca.equals("todos")){
              buscar = "SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo\n" +
"FROM locacoes as L \n" +
"inner join veiculos as V ON L.veiculos_id = V.id\n" +
"inner join cliente as C ON L.clientes_id = C.id\n" +
"inner join cores as CR ON V.cores_id = CR.id\n" +
"inner join modelos as M ON V.modelos_id = M.id";
           } else{
                buscar = "SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo\n" +
"FROM locacoes as L \n" +
"inner join veiculos as V ON L.veiculos_id = V.id\n" +
"inner join cliente as C ON L.clientes_id = C.id\n" +
"inner join cores as CR ON V.cores_id = CR.id\n" +
"inner join modelos as M ON V.modelos_id = M.id where"+ marca;
           }
           
              
               
        System.out.println(marca);
           System.out.println(buscar);
     
           
           request.setAttribute("locacoesHistorico", buscar);
          
           request.getRequestDispatcher("historicoresult.jsp").forward(request, response); 
           
        } catch (Exception e ){
            System.out.println("Error"+ e.getMessage());
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
