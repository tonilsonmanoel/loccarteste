/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterVeiculo;
import br.com.controle.Veiculos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */
public class ServletEditarVeiculo extends HttpServlet {

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
            
            int id = Integer.valueOf(request.getParameter("id"));
            int ano = Integer.valueOf(request.getParameter("ano"));
            String placa = request.getParameter("placa");
            String disponibilidade = request.getParameter("disponibilidade");
            int modelo_id = Integer.valueOf(request.getParameter("modelo"));
            int cor_id = Integer.valueOf(request.getParameter("cor"));
            
            
            out.println(id);
            out.println(ano);
            out.println(placa);
            out.println(disponibilidade);
            
            out.println(cor_id);
            out.println(modelo_id);
            
            
            
            Veiculos cl = new Veiculos();
            cl.setId(id);
            cl.setAno(ano);
            cl.setPlaca(placa);
            cl.setDisponibilidade(disponibilidade);
            cl.setModelo_id(modelo_id);
            cl.setCores_id(cor_id);
            
            
            ManterVeiculo dao = new ManterVeiculo();
            dao.editarVeiculos(cl);
            
            RequestDispatcher rd = request.getRequestDispatcher("garagem.jsp");
            rd.forward(request, response);
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
