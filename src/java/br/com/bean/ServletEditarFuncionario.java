/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.ManterFuncionario;
import br.com.controle.Funcionario;
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
public class ServletEditarFuncionario extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            try {
            int id = Integer.valueOf(request.getParameter("id"));
            String nome= request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String cep = request.getParameter("cep");
            String senha = request.getParameter("senha");
            int perfil =  Integer.valueOf(request.getParameter("perfil"));
            Funcionario cl = new Funcionario();
            cl.setCodigo(id);
            cl.setNome(nome);
            cl.setCpf(cpf);
            cl.setTelefone(telefone);
            cl.setEmail(email);
            cl.setSenha(senha);
            cl.setEndereco(endereco);
            cl.setCep(cep);
            cl.setPerfil(perfil);
            
            System.out.println(perfil);
            System.out.println( cl.getPerfil());
            
            ManterFuncionario dao = new ManterFuncionario();
            dao.editaFuncionario(cl);
            request.getRequestDispatcher("funcionarios.jsp").forward(request, response);
            } catch (Exception e) {
               System.out.println("Erro"+ e.getMessage());
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
