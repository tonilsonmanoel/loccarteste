/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterFuncionario;
import br.com.controle.EnviarEmail;
import br.com.controle.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonilson
 */
public class ServletEsqueceuSenha extends HttpServlet {

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
           String email = request.getParameter("email");
            
            
            Funcionario u = new Funcionario();
            ManterFuncionario daoUsuario = new ManterFuncionario();
            Random aleatorio = new Random();
            EnviarEmail enviar = new EnviarEmail();
            
            try {
            u = daoUsuario.recuperarSenha(email);
                if (email.equals(u.getEmail())){
                    
                    int codigo = aleatorio.nextInt(1000000)+100000;
                    String codigoVerificador = String.valueOf(codigo);
                    daoUsuario.atualizarCodigoVerificador(codigoVerificador, u.getCodigo());
                    
                    enviar.enviarEmail(u.getEmail(),String.valueOf(codigoVerificador));
                    request.setAttribute("Email", email);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("redefinirsenha.jsp");
                    rd.forward(request, response);
                } else {
                  
                    request.setAttribute("emailnaoencontrado", "naoencontrado");
                    
                     RequestDispatcher rd = request.getRequestDispatcher("esqueceusenha.jsp");
                    rd.forward(request, response);
                }
                
            
            } catch (Exception e) {
                e.printStackTrace();
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
