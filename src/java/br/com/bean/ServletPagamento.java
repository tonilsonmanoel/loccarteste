/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterFomarPagamento;
import br.com.controle.FormaPagamento;
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
public class ServletPagamento extends HttpServlet {

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
           int metodo = Integer.valueOf(request.getParameter("metodo"));
           FormaPagamento forma = new FormaPagamento();
           ManterFomarPagamento dao = new ManterFomarPagamento();
           
           // case 1 para cadastro, case 2 para editar e case 3 para excluir
           RequestDispatcher rd;
           switch(metodo){
                case 1:
                   String nome = request.getParameter("nome");
                   
                   forma.setNome(nome);
                   dao.cadastrarFormaPagamento(forma);
                   
                   rd = request.getRequestDispatcher("pagamento.jsp");
                   rd.forward(request, response);
                   break;
                case 2:
                    String codigo = request.getParameter("id");
                    String nomeEditar = request.getParameter("nome");
                    
                    forma.setCodigo(Integer.valueOf(codigo));
                    forma.setNome(nomeEditar);
                    
                    dao.editarFormaPagamento(forma);
                    rd = request.getRequestDispatcher("pagamento.jsp");
                    rd.forward(request, response);
                    
                   break;
                case 3:
                    
                    String codigo2 = request.getParameter("id");
                    
                    forma.setCodigo(Integer.valueOf(codigo2));
                    dao.deletarFormaPagamento(forma);

                    rd = request.getRequestDispatcher("pagamento.jsp");
                    rd.forward(request, response);
                    break;
                default:
                   break;
           }
            
            
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
