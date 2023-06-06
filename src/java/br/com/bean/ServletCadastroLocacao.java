/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterLocacoes;
import br.com.DAO.ManterVeiculo;
import br.com.controle.Locacoes;
import br.com.controle.Veiculos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */
public class ServletCadastroLocacao extends HttpServlet {

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
            int idCliente = Integer.valueOf(request.getParameter("cliente"));
            String dataLocacao = request.getParameter("dataLocacao");
            String dataTermino = request.getParameter("dataTermino");
            int idVeiculo = Integer.valueOf(request.getParameter("veiculo"));
            double diaria = Double.valueOf(request.getParameter("diaria").replace(',', '.'));
            double valorLocacao = Double.valueOf(request.getParameter("valorLocacao").replace(',', '.'));
            double valorPago = Double.valueOf(request.getParameter("valorPago").replace(',', '.'));
            String situacao = "ALUGADO";
            
            Locacoes loc = new Locacoes();
            loc.setCliente_id(idCliente);
            loc.setData_inicio(dataLocacao);
            loc.setData_termino(dataTermino);
            loc.setPlaca_id(idVeiculo);
            loc.setValor_diaria(diaria);
            loc.setStatusLocacoes(situacao);
            loc.setValor_locacao(valorLocacao);
            loc.setValor_pago(valorPago);
            
            
            ManterLocacoes daoLocacao = new ManterLocacoes();
            daoLocacao.cadastrarLocacao(loc);
            
            ManterVeiculo daoVeiculos = new ManterVeiculo();
            Veiculos vei = new Veiculos();
            vei.setDisponibilidade(situacao);
            vei.setId(idVeiculo);
            daoVeiculos.atulizarStatusVeiculo(vei);
            
            request.getRequestDispatcher("locacoes.jsp").forward(request, response);
            
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
