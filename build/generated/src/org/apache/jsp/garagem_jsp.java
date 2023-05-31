package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.controle.Marca;
import br.com.DAO.ManterMarca;
import br.com.controle.Cor;
import br.com.DAO.ManterCor;
import br.com.controle.Modelo;
import br.com.DAO.ManterModelo;
import java.util.ArrayList;
import br.com.controle.Veiculos;
import br.com.DAO.ManterVeiculo;

public final class garagem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Garagem</title>\n");
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
      out.write("                <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Cadastrar Veiculo</h1>\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form  action=\"CadastroVeiculo\" method=\"POST\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Placa</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"placa\"  placeholder=\"888-8888 \">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                            <label for=\"exampleInputText\">Ano</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"ano\" placeholder=\"Insira o ano\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Marca</label>\n");
      out.write("                            <select class=\"form-select\" aria-label=\"Default select example\" name=\"marca\">\n");
      out.write("                                    <option selected>Selecioner a marca</option>\n");
      out.write("                            ");
  
                                String marcaNome = "";
                                String marcaId = "";
                                
                                ManterMarca marcaDao = new ManterMarca();
                                Marca marca = new Marca();
                                ArrayList<Marca> arryMarca = marcaDao.pesquisaTudoMarca();
                                
                                for(int i = 0; i < arryMarca.size();i++){
                                    marca = arryMarca.get(i);
                                    marcaNome = marca.getNome();
                                    marcaId = String.valueOf(marca.getCodigo());
                                    
                            
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(marcaId);
      out.write('"');
      out.write('>');
      out.print(marcaNome);
      out.write("</option>\n");
      out.write("                                    \n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Modelo</label>\n");
      out.write("                                <select class=\"form-select\" aria-label=\"Default select example\" name=\"modelo\">\n");
      out.write("                                        <option selected>Selecioner o modelo</option>\n");
      out.write("                                ");
  
                                    String modeloNome = "";
                                    String modeloId = "";
                                    
                                    ManterModelo modelodao = new ManterModelo();
                                    Modelo modelo = new Modelo();
                                    ArrayList<Modelo> arryModelo = modelodao.pesquisaTudoModelo();

                                    for(int a = 0; a < arryModelo.size();a++){
                                        modelo = arryModelo.get(a);
                                        modeloNome = modelo.getNome();
                                        modeloId = String.valueOf(modelo.getId());
                                
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(modeloId);
      out.write('"');
      out.write('>');
      out.print(modeloNome);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                      </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                           <div class=\"form-group margin-input col\">\n");
      out.write("                               <label for=\"exampleInputText\">Cor</label>\n");
      out.write("                            <select class=\"form-select\" aria-label=\"Default select example\" name=\"cor\">\n");
      out.write("                                    <option selected>Selecioner a cor</option>\n");
      out.write("                            ");
  
                                String corNome = "";
                                String corId ="";
                                
                                ManterCor corDao = new ManterCor();
                                Cor cor = new Cor();
                                ArrayList<Cor> arryCor = corDao.pesquisaTudoCor();
                                
                                for(int i = 0; i < arryCor.size();i++){
                                    cor = arryCor.get(i);
                                    corNome = cor.getNome();
                                    corId = String.valueOf(cor.getCodigo());
                            
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(corId);
      out.write('"');
      out.write('>');
      out.print(corNome);
      out.write("</option>\n");
      out.write("                                    \n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
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
      out.write("        <!-- Sidebar -->\n");
      out.write("         <div class=\"bg-white\" id=\"sidebar-wrapper\">\n");
      out.write("            <div class=\"sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom\"><i\n");
      out.write("                    class=\"fas fa-solid fa-car-side me-2\"></i>LOCCAR</div>\n");
      out.write("            <div class=\"list-group list-group-flush my-3\">\n");
      out.write("                <a href=\"index.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text \"><i\n");
      out.write("                        class=\"fas fa-tachometer-alt me-2\"></i>Dashboard</a>\n");
      out.write("                <a href=\"locacoes.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-car me-2\"></i>Locações</a>\n");
      out.write("                <a href=\"garagem.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold active\"><i\n");
      out.write("                        class=\"fas fa-solid fa-warehouse me-2\"></i>Garagem</a>\n");
      out.write("                <a href=\"cliente.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-user me-2\"></i>Clientes</a>\n");
      out.write("                <a href=\"funcionarios.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-user-tie me-2\"></i>Funcionarios</a>\n");
      out.write("                <a href=\"remover.jsp\" class=\"list-group-item list-group-item-action bg-transparent text-danger fw-bold\"><i\n");
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
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid px-4\">\n");
      out.write("               \n");
      out.write("\n");
      out.write("                <div class=\"row my-5 \">\n");
      out.write("                    <div class=\"row position-relative\">\n");
      out.write("                        <h3 class=\"fs-4 mb-3 text-dark\">Garagem</h3>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar position-absolute top-50 end-0 translate-middle-y \" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Cadastrar</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <table class=\"table bg-white rounded shadow-sm  table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                    <th scope=\"col\">Placa</th>\n");
      out.write("                                    <th scope=\"col\">Ano</th>\n");
      out.write("                                    <th scope=\"col\">Disponibilidade</th>\n");
      out.write("                                    <th scope=\"col\">Modelo</th>\n");
      out.write("                                    <th scope=\"col\">Marca</th>\n");
      out.write("                                    <th scope=\"col\">Cor</th>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">Apagar</th>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">Editar</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");

            String vid ="";
            String vplaca = "";
            String vano = "";
            String vdisponibilidade = "";
            String vmodelo_id = "";
            String vcores_id="";
            String vmodelo ="";
            String vcor ="";
            String vmarca = "";
            
            ManterVeiculo dao = new ManterVeiculo();
            Veiculos ca = new Veiculos();
            
            ArrayList<Veiculos> nt = dao.pesquisaTudoVeiculo();
            
            for(int i = 0; i < nt.size(); i++){
                ca = nt.get(i);
                vid = String.valueOf(ca.getId());
                vplaca = ca.getPlaca();
                vano = String.valueOf(ca.getAno());
                vdisponibilidade = ca.getDisponibilidade();
                vmodelo_id = String.valueOf(ca.getModelo_id());
                vcores_id = String.valueOf(ca.getCores_id());
                vmodelo = ca.getModelo();
                vcor = ca.getCor();
                vmarca = ca.getMarcas();
                                                                    
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"row\">");
      out.print(vid);
      out.write("</th>\n");
      out.write("                                    <td>");
      out.print(vplaca);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vano);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vdisponibilidade);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vmodelo);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vmarca);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vcor);
      out.write("</td>\n");
      out.write("                                    <td class=\"\"><a href=\"DeletarFuncionario?id=");
      out.print(vid);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vmodelo_id);
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
      out.write("                                                    <label for=\"exampleInputText\">Codigo</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"id\" value=\"");
      out.print(vid);
      out.write("\" readonly>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Ano</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"nome\"  value=\"");
      out.print(vano);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                     <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Placa</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"placa\"  value=\"");
      out.print(vplaca);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Disponibilidade</label>\n");
      out.write("                                                    <select class=\"form-select\" aria-label=\"Default select example\" name=\"status\">\n");
      out.write("                                                            <option value=\"");
      out.print(vdisponibilidade);
      out.write("\" selected>");
      out.print(vdisponibilidade);
      out.write("</option>\n");
      out.write("                                                            ");
  if(vdisponibilidade.equals("ALUGADO")){  
      out.write("\n");
      out.write("                                                            <option value=\"DISPONIVEL\">DISPONIVEL</option>\n");
      out.write("                                                            ");
 } else{  
      out.write("\n");
      out.write("                                                            <option value=\"ALUGADO\">ALUGADO</option>\n");
      out.write("                                                            ");
 }  
      out.write("\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                        <label for=\"exampleInputText\">Marca</label>\n");
      out.write("                                                    <select class=\"form-select\" aria-label=\"Default select example\" name=\"marca\">\n");
      out.write("                                                        <option selected value=\"");
      out.print(vmarca);
      out.write('"');
      out.write('>');
      out.print(vmarca);
      out.write("</option>\n");
      out.write("                                                    ");
  
                                                        String marcaNome2 = "";
                                                        String marcaId2 = "";

                                                        ManterMarca marcaDao2 = new ManterMarca();
                                                        Marca marca2 = new Marca();
                                                        ArrayList<Marca> arryMarca2 = marcaDao2.pesquisaTudoMarca();

                                                        for(int i2 = 0; i2 < arryMarca2.size();i2++){
                                                            marca2 = arryMarca2.get(i2);
                                                            marcaNome2 = marca2.getNome();
                                                            marcaId2 = String.valueOf(marca2.getCodigo());

                                                    
      out.write("\n");
      out.write("                                                            <option value=\"");
      out.print(marcaId2);
      out.write('"');
      out.write('>');
      out.print(marcaNome2);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                                        ");
 } 
      out.write("\n");
      out.write("                                                    </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                        <label for=\"exampleInputText\">Modelo</label>\n");
      out.write("                                                        <select class=\"form-select\" aria-label=\"Default select example\" name=\"modelo\">\n");
      out.write("                                                            <option selected value=\"");
      out.print(vmodelo);
      out.write('"');
      out.write('>');
      out.print(vmodelo);
      out.write("</option>\n");
      out.write("                                                        ");
  
                                                            String modeloNome2 = "";
                                                            String modeloId2 = "";

                                                            ManterModelo modelodao2 = new ManterModelo();
                                                            Modelo modelo2 = new Modelo();
                                                            ArrayList<Modelo> arryModelo2 = modelodao2.pesquisaTudoModelo();

                                                            for(int a2 = 0; a2 < arryModelo.size();a2++){
                                                                modelo2 = arryModelo2.get(a2);
                                                                modeloNome2 = modelo2.getNome();
                                                                modeloId2 = String.valueOf(modelo2.getId());
                                                        
      out.write("\n");
      out.write("                                                                <option value=\"");
      out.print(modeloId2);
      out.write('"');
      out.write('>');
      out.print(modeloNome2);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                                            ");
 } 
      out.write("\n");
      out.write("                                                              </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                   <div class=\"form-group margin-input col\">\n");
      out.write("                                                       <label for=\"exampleInputText\">Cor</label>\n");
      out.write("                                                    <select class=\"form-select\" aria-label=\"Default select example\" name=\"cor\">\n");
      out.write("                                                        <option selected value=\"");
      out.print(vcor);
      out.write('"');
      out.write('>');
      out.print(vcor);
      out.write("</option>\n");
      out.write("                                                    ");
  
                                                        String corNome2 = "";
                                                        String corId2 ="";

                                                        ManterCor corDao2 = new ManterCor();
                                                        Cor cor2 = new Cor();
                                                        ArrayList<Cor> arryCor2 = corDao2.pesquisaTudoCor();

                                                        for(int i3 = 0; i3 < arryCor.size();i3++){
                                                            cor2 = arryCor.get(i3);
                                                            corNome2 = cor2.getNome();
                                                            corId2 = String.valueOf(cor2.getCodigo());
                                                    
      out.write("\n");
      out.write("                                                            <option value=\"");
      out.print(corId2);
      out.write('"');
      out.write('>');
      out.print(corNome2);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                                        ");
 } 
      out.write("\n");
      out.write("                                                    </select>\n");
      out.write("                                                    </div>\n");
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
