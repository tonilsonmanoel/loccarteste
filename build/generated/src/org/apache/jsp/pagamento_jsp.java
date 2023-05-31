package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import br.com.controle.FormaPagamento;
import br.com.DAO.ManterFomarPagamento;

public final class pagamento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Forma Pagamento</title>\n");
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
      out.write("                <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Cadastrar Forma Pagamento</h1>\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form  action=\"Pagamento\" method=\"POST\">\n");
      out.write("                        <input name=\"metodo\" value=\"1\" hidden=\"\">\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                            <label for=\"exampleInputText\">Nome </label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome \">\n");
      out.write("                        </div>\n");
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
      out.write("        <div class=\"bg-white\" id=\"sidebar-wrapper\">\n");
      out.write("            <div class=\"sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom\"><i\n");
      out.write("                    class=\"fas fa-user-secret me-2\"></i>Codersbite</div>\n");
      out.write("            <div class=\"list-group list-group-flush my-3\">\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text active\"><i\n");
      out.write("                        class=\"fas fa-tachometer-alt me-2\"></i>Dashboard</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-car me-2\"></i>Locações</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-warehouse me-2\"></i>Garagem</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-user me-2\"></i>Clientes</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-wrench me-2\"></i>Manutenções</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-credit-card me-2\"></i>Pagamento</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-user-tie me-2\"></i>Funcionarios</a>\n");
      out.write("                <a href=\"#\" class=\"list-group-item list-group-item-action bg-transparent text-danger fw-bold\"><i\n");
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
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n");
      out.write("                    data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\"\n");
      out.write("                    aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav ms-auto mb-2 mb-lg-0\">\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle second-text fw-bold\" href=\"#\" id=\"navbarDropdown\"\n");
      out.write("                                role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"fas fa-user me-2\"></i>John Doe\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Profile</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Settings</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Logout</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid px-4\">\n");
      out.write("                <div class=\"row g-3 my-2\">\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                <h3 class=\"fs-2\">10</h3>\n");
      out.write("                                <p class=\"fs-5\">Veiculos</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-gift fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                <h3 class=\"fs-2\">15</h3>\n");
      out.write("                                <p class=\"fs-5\">Clientes</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i\n");
      out.write("                                class=\"fas fa-hand-holding-usd fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                <h3 class=\"fs-2\">7</h3>\n");
      out.write("                                <p class=\"fs-5\">Manutenções</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-truck fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                <h3 class=\"fs-2\">20</h3>\n");
      out.write("                                <p class=\"fs-5\">Total Locações</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-chart-line fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row my-5 \">\n");
      out.write("                    <div class=\"row position-relative\">\n");
      out.write("                        <h3 class=\"fs-4 mb-3 text-dark\">Forma Pagamento</h3>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar position-absolute top-50 end-0 translate-middle-y \" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Cadastrar</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <table class=\"table bg-white rounded shadow-sm  table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                    <th scope=\"col\">Nome</th>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">Apagar</th>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">Editar</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");

            String vid = "";
            String vnome = "";
            
            ManterFomarPagamento dao =new ManterFomarPagamento();
            FormaPagamento ca = new FormaPagamento();
            
            ArrayList<FormaPagamento> nt = dao.pesquisaTudoForma();
        
            
            for(int i = 0; i < nt.size(); i++){
                ca = nt.get(i);
                vid = String.valueOf(ca.getCodigo());
                vnome = String.valueOf(ca.getNome());
                
               
                                                                    
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"row\">");
      out.print(vid);
      out.write("</th>\n");
      out.write("                                    <td>");
      out.print(vnome);
      out.write("</td>\n");
      out.write("                                    <td class=\"\"><a href=\"Pagamento?id=");
      out.print(vid);
      out.write("&metodo=3\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vnome);
      out.write("?')\"><i class=\"fas fa-solid fa-trash me-2 d-flex justify-content-center \" style=\"color: #ff0000;\"></i></a></td>\n");
      out.write("                                    <td><a href=\"Pagamento?id=");
      out.print(vid);
      out.write("&metodo=2\"data-bs-toggle=\"modal\" data-bs-target=\"#modalEditar");
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
      out.write("                                        <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Editar Pagamento</h1>\n");
      out.write("                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                            <form  action=\"Pagamento\" method=\"POST\">\n");
      out.write("                                                 <div class=\"row\">\n");
      out.write("                                                    <input name=\"metodo\" value=\"2\" hidden=\"\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">ID</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\"  value=\"");
      out.print(vid);
      out.write("\" name=\"id\" readonly>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"nome\"  value=\"");
      out.print(vnome);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
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
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- /#page-content-wrapper -->\n");
      out.write("    \n");
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
      out.write("</html>\n");
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
