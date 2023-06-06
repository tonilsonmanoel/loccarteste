package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.controle.Funcionario;
import br.com.DAO.ManterFuncionario;
import java.util.ArrayList;

public final class funcionarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js\" integrity=\"sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js\" integrity=\"sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/styles.css\" />\n");
      out.write("    <title>Funcionarios</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"d-flex\" id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Modal Cadastro -->\n");
      out.write("        <div class=\"modal fade \" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog \">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Cadastrar Funcionario</h1>\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form  action=\"CadastroFuncionario\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                            <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome \">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                            <label for=\"exampleInputText\">CPF</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"cpf\" placeholder=\"888.888.888-88\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                            <label for=\"exampleInputText\">Telefone</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"telefone\" placeholder=\"(61) 98888-8888\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                            <label for=\"exampleInputText\">Endereço</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"endereco\"  placeholder=\"Insira o Endereço \">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                            <label for=\"exampleInputText\">Email</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Insira o email\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                            <label for=\"exampleInputText\">Senha</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"senha\" placeholder=\"Insira a senha\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group margin-input col\">\n");
      out.write("                            <label for=\"exampleInputText\">Cep</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"cep\" placeholder=\"88888-888\">\n");
      out.write("                            </div>\n");
      out.write("                       \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Fechar</button>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Cadastrar</button></form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("         <!-- Fim Modal Cadastro-->\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("         <div class=\"bg-white\" id=\"sidebar-wrapper\">\n");
      out.write("            <div class=\"sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom\"><i\n");
      out.write("                    class=\"fas fa-solid fa-car-side me-2\"></i>LOCCAR</div>\n");
      out.write("            <div class=\"list-group list-group-flush my-3\">\n");
      out.write("                <a href=\"index.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text \"><i\n");
      out.write("                        class=\"fas fa-tachometer-alt me-2\"></i>Dashboard</a>\n");
      out.write("                <a href=\"locacoes.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-car me-2\"></i>Locações</a>\n");
      out.write("                <a href=\"garagem.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-warehouse me-2\"></i>Garagem</a>\n");
      out.write("                <a href=\"cliente.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-user me-2\"></i>Clientes</a>\n");
      out.write("                \n");
      out.write("                <a href=\"funcionarios.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold active\"><i\n");
      out.write("                        class=\"fas fa-solid fa-user-tie me-2\"></i>Funcionarios</a>\n");
      out.write("                <a href=\"remover.jsp\" class=\"list-group-item list-group-item-action bg-transparent text-danger fw-bold \"><i\n");
      out.write("                        class=\"fas fa-power-off me-2\"></i>Logout</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /#sidebar-wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Page Content -->\n");
      out.write("        <div id=\"page-content-wrapper\">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4\">\n");
      out.write("                <div class=\"d-flex align-items-center\">\n");
      out.write("                    <i class=\"fas fa-align-left primary-text fs-4 me-3\" id=\"menu-toggle\"></i>\n");
      out.write("                    <h2 class=\"fs-2 m-0\">Dashboard</h2>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("              \n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid px-4\">\n");
      out.write("                \n");
      out.write("                 <!--  Cards   -->\n");
      out.write("                <div class=\"row g-3 \">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                ");
 
                                Funcionario totalFuncionario = new Funcionario();
                                ManterFuncionario daoTotalFuncionario = new ManterFuncionario();

                                totalFuncionario = daoTotalFuncionario.totalFucnioario();

                                String vTotalFuncionario = String.valueOf(totalFuncionario.getCodigo());

                            
      out.write("\n");
      out.write("                                <h3 class=\"fs-2\">");
      out.print(vTotalFuncionario);
      out.write("</h3>\n");
      out.write("                                <p class=\"fs-5\">Funcionarios</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-solid fa-users fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>        \n");
      out.write("                <!-- Final Cards   -->\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div class=\"row my-5 \">\n");
      out.write("                    <div class=\"row position-relative\">\n");
      out.write("                        <h3 class=\"fs-4 mb-3 text-dark\">Funcionarios</h3>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar position-absolute top-50 end-0 translate-middle-y \" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Cadastrar</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <table class=\"table bg-white rounded shadow-sm  table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                    <th scope=\"col\">Nome</th>\n");
      out.write("                                    <th scope=\"col\">CPF</th>\n");
      out.write("                                    <th scope=\"col\">Endereco</th>\n");
      out.write("                                    <th scope=\"col\">Telefone</th>\n");
      out.write("                                    <th scope=\"col\">Email</th>\n");
      out.write("                                    <th scope=\"col\">Senha</th>\n");
      out.write("                                    <th scope=\"col\">CEP</th>\n");
      out.write("                                    \n");
      out.write("                                    <th scope=\"col\">Apagar</th>\n");
      out.write("                                    <th scope=\"col\">Editar</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");

            String vid = "";
            String vnome = "";
            String vcpf = "";
            String vendereco = "";
            String vtelefone = "";
            String vemail = "";
            String vcep = "";
            String vsenha ="";
            
            ManterFuncionario dao =new ManterFuncionario();
            Funcionario ca = new Funcionario();
            
            int start;

            if(request.getParameter("page") == null){
                start = 0;
            } else{
                start = Integer.valueOf(request.getParameter("page"));
            }

            int totalRegistorPorPagina = 3;

            if(start==0 || start ==1 ){
                start = 0;
            }
            else{
                start = start * totalRegistorPorPagina-3;
            }
            
            
            
            ArrayList<Funcionario> nt = dao.pesquisaTudoFuncionarioTabela(start, totalRegistorPorPagina);
        
            
            for(int i = 0; i < nt.size(); i++){
                ca = nt.get(i);
                vid = String.valueOf(ca.getCodigo());
                vnome = String.valueOf(ca.getNome());
                vcpf= String.valueOf(ca.getCpf());
                vtelefone = String.valueOf(ca.getTelefone());
                vemail = ca.getEmail();
                vendereco = ca.getEndereco();
                vcep = String.valueOf(ca.getCep());
                vsenha = String.valueOf(ca.getSenha());
                                                                    
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"row\">");
      out.print(vid);
      out.write("</th>\n");
      out.write("                                    <td>");
      out.print(vnome);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vcpf);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vendereco);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vtelefone);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vemail);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vsenha);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vcep);
      out.write("</td>\n");
      out.write("                                    <td class=\"\"><a href=\"DeletarFuncionario?id=");
      out.print(vid);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vnome);
      out.write("?')\"><i class=\"fas fa-solid fa-trash me-2 d-flex justify-content-center \" style=\"color: #ff0000;\"></i></a></td>\n");
      out.write("                                    <td><a href=\"#\"data-bs-toggle=\"modal\" data-bs-target=\"#modalEditar");
      out.print(vid);
      out.write("\"><i class=\"fas fa-solid fa-pen me-2 d-flex justify-content-center\"></i></a></td>\n");
      out.write("                                </tr>\n");
      out.write("                                \n");
      out.write("                                <!-- Modal Editar -->\n");
      out.write("                                <div class=\"modal fade \" id=\"modalEditar");
      out.print(vid);
      out.write("\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                    <div class=\"modal-dialog \">\n");
      out.write("                                    <div class=\"modal-content\">\n");
      out.write("                                        <div class=\"modal-header\">\n");
      out.write("                                        <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Editar Funcionario</h1>\n");
      out.write("                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                            <form  action=\"EditarFuncionario\" method=\"POST\">\n");
      out.write("                                                 <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">ID</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"id\" value=\"");
      out.print(vid);
      out.write("\" readonly>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"nome\"  value=\"");
      out.print(vnome);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">CPF</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"cpf\" value=\"");
      out.print(vcpf);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Telefone</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"telefone\" value=\"");
      out.print(vtelefone);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group margin-input\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Endereço</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"endereco\"  value=\"");
      out.print(vendereco);
      out.write("\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Email</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"email\" value=\"");
      out.print(vemail);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Senha</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"senha\" value=\"");
      out.print(vsenha);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group margin-input col\">\n");
      out.write("                                                <label for=\"exampleInputText\">Cep</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"cep\" value=\"");
      out.print(vcep);
      out.write("\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-footer\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Fechar</button>\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary\">Editar</button></form>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                 <!-- Fim Modal Editar -->\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                        ");
    }   
      out.write("\n");
      out.write("                                \n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <nav aria-label=\"Page navigation example position-absolute top-50 start-50 translate-middle\">\n");
      out.write("                            <ul class=\"pagination\">\n");
      out.write("                                ");
   
                                    
                                Funcionario countObj =dao.totalFucnioario();
                                double totalCount = Double.valueOf(countObj.getCodigo());
                                double paginacao = totalCount/totalRegistorPorPagina;
                                int contadorPag = 1;
                                
                                if(paginacao != (int) paginacao){
                                    if(paginacao % 2 != 0){
                                        paginacao +=1;
                                    }
                                }
                                
                                
                                for (int p = 1; p <= paginacao;p++){
                                
      out.write("\n");
      out.write("                                <li class=\"page-item\"><a class=\"page-link\" href=\"funcionarios.jsp?page=");
      out.print(contadorPag);
      out.write('"');
      out.write('>');
      out.print(contadorPag);
      out.write("</a></li>\n");
      out.write("                                ");
  
                                 contadorPag +=1 ;   }
                                
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                    </nav>    \n");
      out.write("                       \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- /#page-content-wrapper -->\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        var el = document.getElementById(\"wrapper\");\n");
      out.write("        var toggleButton = document.getElementById(\"menu-toggle\");\n");
      out.write("\n");
      out.write("        toggleButton.onclick = function () {\n");
      out.write("            el.classList.toggle(\"toggled\");\n");
      out.write("        };\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
