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
      out.write("                                <label for=\"exampleInputText\">Modelo Veiculo</label>\n");
      out.write("                                <select class=\"form-select\" aria-label=\"Default select example\" name=\"modelo\">\n");
      out.write("                                        <option selected>Selecioner o modelo do veiculo</option>\n");
      out.write("                                ");
  
                                    String modeloNome = "";
                                    String modeloId = "";
                                    String marcasID = "";
                                    String marcasNome="";
                                    
                                    ManterModelo modelodao = new ManterModelo();
                                    Modelo modelo = new Modelo();
                                    ArrayList<Modelo> arryModelo = modelodao.pesquisaTudoModelo();

                                    for(int a = 0; a < arryModelo.size();a++){
                                        modelo = arryModelo.get(a);
                                        modeloNome = modelo.getNome();
                                        modeloId = String.valueOf(modelo.getId());
                                        marcasNome = String.valueOf(modelo.getMarca());
                                
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(modeloId);
      out.write("\">Modelo: ");
      out.print(modeloNome);
      out.write(" | Marca: ");
      out.print(marcasNome);
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
      out.write("        \n");
      out.write("       \n");
      out.write("         <!-- Modal Marcas -->\n");
      out.write("         \n");
      out.write("         <div class=\"modal fade\" id=\"ModalMarca\">\n");
      out.write("            <div class=\"modal-dialog modal-lg modal-dialog-scrollable\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"DSLabel\">Marcas</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\">\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body \">\n");
      out.write("                       <table class=\"table bg-white rounded shadow-sm  table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                            <th scope=\"col\">Nome</th>\n");
      out.write("                                            <th scope=\"col\" width=\"50\">Apagar</th>\n");
      out.write("                                            \n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("            ");

                        String vidMarca = "";
                        String vnomeMarca = "";

                        ManterMarca daoMarca =new ManterMarca();
                        Marca marcaobj = new Marca();


                        ArrayList<Marca> nt23 = daoMarca.pesquisaTudoMarca();

                    for(int i3 = 0; i3 < nt23.size(); i3++){
                        marcaobj = nt23.get(i3);
                        vidMarca = String.valueOf(marcaobj.getCodigo());
                        vnomeMarca = String.valueOf(marcaobj.getNome());
                                                                            
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"row\">");
      out.print(vidMarca);
      out.write("</th>\n");
      out.write("                                            <td>");
      out.print(vnomeMarca);
      out.write("</td>\n");
      out.write("                                            <td class=\"\"><a href=\"DeletarMarca?id=");
      out.print(vidMarca);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vnomeMarca);
      out.write("?')\"><i class=\"fas fa-solid fa-trash me-2 d-flex justify-content-center \" style=\"color: #ff0000;\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                ");
  }   
      out.write("\n");
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Fechar</button>\n");
      out.write("                        <button class=\"btn btn-primary\"data-bs-target=\"#ModalCadastrarMarca\" data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">\n");
      out.write("                            Cadastrar\n");
      out.write("                        </button>\n");
      out.write("                         <button class=\"btn btn-primary\"data-bs-target=\"#ModalEditarMarca\" data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">\n");
      out.write("                            Editar\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                \n");
      out.write("        <!-- Modal Cadastro Marcas -->                        \n");
      out.write("        <div class=\"modal fade\" id=\"ModalCadastrarMarca\" \n");
      out.write("             aria-hidden=\"true\" aria-labelledby=\"DSLabel2\" \n");
      out.write("             tabindex=\"-1\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"AlgoLabel\">Cadastrar Marca</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body p-5\">\n");
      out.write("                        <form  action=\"CadastroMarca\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                            <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" data-bs-target=\"#ModalMarca\"data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">Voltar</button>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Cadastrar</button></form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim Modal Marca Cadastro -->\n");
      out.write("        \n");
      out.write("        <!-- Modal Editar Marcas -->                        \n");
      out.write("        <div class=\"modal fade\" id=\"ModalEditarMarca\" \n");
      out.write("             aria-hidden=\"true\" aria-labelledby=\"DSLabel2\" \n");
      out.write("             tabindex=\"-1\">\n");
      out.write("            <div class=\"modal-dialog \">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"AlgoLabel\">Editar Marca</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body p-5\">\n");
      out.write("                        <form  action=\"EditarMarca\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                             <label for=\"exampleInputText\">Marca</label>\n");
      out.write("                              <select class=\"form-select\" aria-label=\"Default select example\" name=\"idmarca\">\n");
      out.write("                                <option selected>Selecione a marca </option>\n");
      out.write("                                                    ");
  
                                                        String marcaNome3 = "";
                                                        String marcaId3 = "";

                                                        ManterMarca marcaDao3 = new ManterMarca();
                                                        Marca marca3= new Marca();
                                                        ArrayList<Marca> arryMarca3 = marcaDao3.pesquisaTudoMarca();

                                                        for(int i3 = 0; i3 < arryMarca3.size();i3++){
                                                            marca3 = arryMarca3.get(i3);
                                                            marcaNome3 = marca3.getNome();
                                                            marcaId3 = String.valueOf(marca3.getCodigo());

                                                    
      out.write("\n");
      out.write("                                     <option value=\"");
      out.print(marcaId3);
      out.write('"');
      out.write('>');
      out.print(marcaNome3);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                      ");
 } 
      out.write("\n");
      out.write("                                       </select>\n");
      out.write("                        </div>   \n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                            <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" data-bs-target=\"#ModalMarca\"data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">Voltar</button>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Editar</button></form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim editar Marcas -->\n");
      out.write("         <!-- Fim Modal Marcas -->\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <!-- Modal Modelo -->\n");
      out.write("         \n");
      out.write("         <div class=\"modal fade\" id=\"ModalModelo\">\n");
      out.write("            <div class=\"modal-dialog modal-lg modal-dialog-scrollable\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"DSLabel\">Modelo</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\">\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body \">\n");
      out.write("                       <table class=\"table bg-white rounded shadow-sm  table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                            <th scope=\"col\">Nome</th>\n");
      out.write("                                            <th scope=\"col\">Marca</th>\n");
      out.write("                                            <th scope=\"col\" width=\"50\">Apagar</th>\n");
      out.write("                                            \n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("            ");

                        String vidModelo = "";
                        String vnomeModelo = "";
                        String vnomeMarcaId = "";
                        String vnomeMarcaM = "";
                        
                        ManterModelo daoModelo = new ManterModelo();
                        Modelo modeloobj = new Modelo();

                        ArrayList<Modelo> ntModelo = daoModelo.pesquisaTudoModelo();

                    for(int imodelo = 0; imodelo < ntModelo.size(); imodelo++){
                        modeloobj = ntModelo.get(imodelo);
                        vidModelo = String.valueOf(modeloobj.getId());
                        vnomeModelo = String.valueOf(modeloobj.getNome());
                        vnomeMarcaId = String.valueOf(modeloobj.getMarcas_id());
                        vnomeMarcaM = String.valueOf(modeloobj.getMarca());
                        
                                                                            
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"row\">");
      out.print(vidModelo);
      out.write("</th>\n");
      out.write("                                            <td>");
      out.print(vnomeModelo);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(vnomeMarcaM);
      out.write("</td>\n");
      out.write("                                            <td class=\"\"><a href=\"DeletarModelo?id=");
      out.print(vidModelo);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vnomeModelo);
      out.write("?')\"><i class=\"fas fa-solid fa-trash me-2 d-flex justify-content-center \" style=\"color: #ff0000;\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                ");
  }   
      out.write("\n");
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Fechar</button>\n");
      out.write("                        <button class=\"btn btn-primary\"data-bs-target=\"#ModalCadastrarModelo\" data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">\n");
      out.write("                            Cadastrar\n");
      out.write("                        </button>\n");
      out.write("                         <button class=\"btn btn-primary\"data-bs-target=\"#ModalEditarModelo\" data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">\n");
      out.write("                            Editar\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                \n");
      out.write("        <!-- Modal Cadastro Modelo -->                        \n");
      out.write("        <div class=\"modal fade\" id=\"ModalCadastrarModelo\" \n");
      out.write("             aria-hidden=\"true\" aria-labelledby=\"DSLabel2\" \n");
      out.write("             tabindex=\"-1\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"AlgoLabel\">Cadastrar Modelo</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body p-5\">\n");
      out.write("                        <form  action=\"CadastroModelo\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                             <label for=\"exampleInputText\">Marca</label>\n");
      out.write("                              <select class=\"form-select\" aria-label=\"Default select example\" name=\"idmarca\">\n");
      out.write("                                <option selected>Selecione a marca </option>\n");
      out.write("                                                    ");
  
                                                        String marcaNomeModelo = "";
                                                        String marcaIdModelo = "";

                                                        ManterMarca marcaDaoModelo = new ManterMarca();
                                                        Marca marcaModeloCadastro = new Marca();
                                                        
                                                        ArrayList<Marca> arryMarcaModelo = marcaDaoModelo.pesquisaTudoMarca();

                                                        for(int a = 0; a < arryMarcaModelo.size();a++){
                                                            marcaModeloCadastro = arryMarcaModelo.get(a);
                                                            marcaNomeModelo = marcaModeloCadastro.getNome();
                                                            marcaIdModelo = String.valueOf(marcaModeloCadastro.getCodigo());

                                                    
      out.write("\n");
      out.write("                                     <option value=\"");
      out.print(marcaIdModelo);
      out.write('"');
      out.write('>');
      out.print(marcaNomeModelo);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                      ");
 } 
      out.write("\n");
      out.write("                                       </select>\n");
      out.write("                                </div>   \n");
      out.write("                            \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" data-bs-target=\"#ModalModelo\"data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">Voltar</button>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Cadastrar</button></form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim Modal Modelo Cadastro -->\n");
      out.write("        \n");
      out.write("        <!-- Modal Editar Modelo -->                        \n");
      out.write("        <div class=\"modal fade\" id=\"ModalEditarModelo\" \n");
      out.write("             aria-hidden=\"true\" aria-labelledby=\"DSLabel2\" \n");
      out.write("             tabindex=\"-1\">\n");
      out.write("            <div class=\"modal-dialog \">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"AlgoLabel\">Editar Modelo</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body p-5\">\n");
      out.write("                        <form  action=\"EditarModelo\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                  <label for=\"exampleInputText\">Modelo o modelo para editar</label>\n");
      out.write("                                  <select class=\"form-select\" aria-label=\"Default select example\" name=\"idModelo\">\n");
      out.write("                                    <option selected>Selecione o modelo </option>\n");
      out.write("                                                        ");
  
                                                            String nomeModeloEditar= "";
                                                            String idModeloEditar = "";
                                                            
                                                            ManterModelo modeloDaoEditar = new ManterModelo();
                                                            Modelo modeloEditar  = new Modelo();
                                                            ArrayList<Modelo> arryModeloEditar = modeloDaoEditar.pesquisaTudoModelo();

                                                            for(int i3 = 0; i3 < arryModeloEditar.size();i3++){
                                                                modeloEditar = arryModeloEditar.get(i3);
                                                                nomeModeloEditar = modeloEditar.getNome();
                                                                idModeloEditar = String.valueOf(modeloEditar.getId());

                                                        
      out.write("\n");
      out.write("                                         <option value=\"");
      out.print(idModeloEditar);
      out.write('"');
      out.write('>');
      out.print(nomeModeloEditar);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                          ");
 } 
      out.write("\n");
      out.write("                                           </select>\n");
      out.write("                            </div>\n");
      out.write("                                 \n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome\">\n");
      out.write("                            </div>               \n");
      out.write("                                           \n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                  <label for=\"exampleInputText\">Marca</label>\n");
      out.write("                                  <select class=\"form-select\" aria-label=\"Default select example\" name=\"idmarca\">\n");
      out.write("                                    <option selected>Selecione a marca </option>\n");
      out.write("                                                        ");
  
                                                            String marcaNomeModelo2 = "";
                                                            String marcaIdModelo2 = "";

                                                            Marca marcaModelo2= new Marca();
                                                            ArrayList<Marca> arryMarcaModelo3 = marcaDaoModelo.pesquisaTudoMarca();

                                                            for(int i3 = 0; i3 < arryMarcaModelo3.size();i3++){
                                                                marcaModelo2 = arryMarcaModelo3.get(i3);
                                                                marcaNomeModelo2 = marcaModelo2.getNome();
                                                                marcaIdModelo2 = String.valueOf(marcaModelo2.getCodigo());

                                                        
      out.write("\n");
      out.write("                                         <option value=\"");
      out.print(marcaIdModelo2);
      out.write('"');
      out.write('>');
      out.print(marcaNomeModelo2);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                          ");
 } 
      out.write("\n");
      out.write("                                           </select>\n");
      out.write("                            </div>   \n");
      out.write("                            \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" data-bs-target=\"#ModalModelo\"data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">Voltar</button>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Editar</button></form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim editar Modelo -->\n");
      out.write("         <!-- Fim Modal Modelo -->\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <!-- Modal Cores -->\n");
      out.write("         \n");
      out.write("         <div class=\"modal fade\" id=\"ModalCores\">\n");
      out.write("            <div class=\"modal-dialog modal-lg modal-dialog-scrollable\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"DSLabel\">Cor</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\">\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body \">\n");
      out.write("                       <table class=\"table bg-white rounded shadow-sm  table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                            <th scope=\"col\">Nome</th>\n");
      out.write("                                            <th scope=\"col\" width=\"50\">Apagar</th>\n");
      out.write("                                            \n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("            ");

                        String vidCor = "";
                        String vnomeCor = "";
                        
                        ManterCor daoCor = new ManterCor();
                        Cor corobj = new Cor();

                        ArrayList<Cor> ntCor = daoCor.pesquisaTudoCor();

                    for(int iCor = 0; iCor < ntCor.size(); iCor++){
                        corobj = ntCor.get(iCor);
                        vidCor = String.valueOf(corobj.getCodigo());
                        vnomeCor = String.valueOf(corobj.getNome());
                        
                        
                                                                            
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th scope=\"row\">");
      out.print(vidCor);
      out.write("</th>\n");
      out.write("                                            <td>");
      out.print(vnomeCor);
      out.write("</td>\n");
      out.write("                                            <td class=\"\"><a href=\"DeletaCor?id=");
      out.print(vidCor);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vnomeCor);
      out.write("?')\"><i class=\"fas fa-solid fa-trash me-2 d-flex justify-content-center \" style=\"color: #ff0000;\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                ");
  }   
      out.write("\n");
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Fechar</button>\n");
      out.write("                        <button class=\"btn btn-primary\"data-bs-target=\"#ModalCadastrarCor\" data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">\n");
      out.write("                            Cadastrar\n");
      out.write("                        </button>\n");
      out.write("                         <button class=\"btn btn-primary\"data-bs-target=\"#ModalEditarCor\" data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">\n");
      out.write("                            Editar\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                \n");
      out.write("        <!-- Modal Cadastro Cores -->                        \n");
      out.write("        <div class=\"modal fade\" id=\"ModalCadastrarCor\" \n");
      out.write("             aria-hidden=\"true\" aria-labelledby=\"DSLabel2\" \n");
      out.write("             tabindex=\"-1\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"AlgoLabel\">Cadastrar Cor</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body p-5\">\n");
      out.write("                        <form  action=\"CadastroCor\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome\">\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" data-bs-target=\"#ModalCores\"data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">Voltar</button>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Cadastrar</button></form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim Modal Cores Cadastro -->\n");
      out.write("        \n");
      out.write("        <!-- Modal Editar Cores -->                        \n");
      out.write("        <div class=\"modal fade\" id=\"ModalEditarCor\" \n");
      out.write("             aria-hidden=\"true\" aria-labelledby=\"DSLabel2\" \n");
      out.write("             tabindex=\"-1\">\n");
      out.write("            <div class=\"modal-dialog \">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"AlgoLabel\">Editar Cor</h5>\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body p-5\">\n");
      out.write("                        <form  action=\"EditarCor\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                  <label for=\"exampleInputText\">Cor para editar</label>\n");
      out.write("                                  <select class=\"form-select\" aria-label=\"Default select example\" name=\"idCor\">\n");
      out.write("                                    <option selected>Selecione a Cor </option>\n");
      out.write("                                                        ");
  
                                                            String nomeCorEditar= "";
                                                            String idCorEditar = "";
                                                            
                                                            Cor corEditar  = new Cor();
                                                            ArrayList<Cor> arryCorEditar = daoCor.pesquisaTudoCor();

                                                            for(int i3 = 0; i3 < arryCorEditar.size();i3++){
                                                                corEditar = arryCorEditar.get(i3);
                                                                nomeCorEditar = corEditar.getNome();
                                                                idCorEditar = String.valueOf(corEditar.getCodigo());

                                                        
      out.write("\n");
      out.write("                                         <option value=\"");
      out.print(idCorEditar);
      out.write('"');
      out.write('>');
      out.print(nomeCorEditar);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                          ");
 } 
      out.write("\n");
      out.write("                                           </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input\">\n");
      out.write("                                <label for=\"exampleInputText\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nome\"  placeholder=\"Insira o nome\">\n");
      out.write("                            </div>    \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" data-bs-target=\"#ModalCores\"data-bs-toggle=\"modal\" data-bs-dismiss=\"modal\">Voltar</button>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Editar</button></form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim editar Cores -->\n");
      out.write("         <!-- Fim Modal Cores -->\n");
      out.write("         \n");
      out.write("         \n");
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
      out.write("                <!--  Cards   -->\n");
      out.write("                <div class=\"row g-3 \">\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                ");
 
                                Veiculos totalVeiculo = new Veiculos();
                                ManterVeiculo daoTotalVeiculo = new ManterVeiculo();

                                totalVeiculo = daoTotalVeiculo.totalVeiculos();

                                String vtotalVei = String.valueOf(totalVeiculo.getId());

                            
      out.write("\n");
      out.write("                                <h3 class=\"fs-2\">");
      out.print(vtotalVei);
      out.write("</h3>\n");
      out.write("                                <p class=\"fs-5\">Veiculos</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-solid fa-car fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                            ");
 
                            Marca totalMarca = new Marca();
                            ManterMarca daoTotalMarca = new ManterMarca();
                            
                            totalMarca = daoTotalMarca.totalMarca();
                            
                            String vtotalMarca = String.valueOf(totalMarca.getCodigo());

                            
      out.write("\n");
      out.write("                                <h3 class=\"fs-2\">");
      out.print(vtotalMarca);
      out.write("</h3>\n");
      out.write("                                <p class=\"fs-5\">Marcas</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i\n");
      out.write("                                class=\"fas fa-duotone fa-car-side fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row justify-content-center\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar my-1\" data-bs-toggle=\"modal\" data-bs-target=\"#ModalMarca\">Exibir</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                  ");
 
                            Modelo totalModelo = new Modelo();
                            ManterModelo daoTotalModelo = new ManterModelo();
                            
                            totalModelo = daoTotalModelo.totalModelo();
                            String vtotalModelo = String.valueOf(totalModelo.getId());

                            
      out.write("\n");
      out.write("                                <h3 class=\"fs-2\">");
      out.print(vtotalModelo);
      out.write("</h3>\n");
      out.write("                                <p class=\"fs-5\">Modelos</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-solid fa-car-side fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row justify-content-center\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar my-1\" data-bs-toggle=\"modal\" data-bs-target=\"#ModalModelo\">Exibir</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded\">\n");
      out.write("                            <div>\n");
      out.write("                                 ");
 
                            Cor totalCor = new Cor();
                            ManterCor daoTotalCor = new ManterCor();
                            
                            totalCor = daoTotalCor.totalCor();
                            String vtotalCor = String.valueOf(totalCor.getCodigo());

                        
      out.write("\n");
      out.write("                                <h3 class=\"fs-2\">");
      out.print(vtotalCor);
      out.write("</h3>\n");
      out.write("                                <p class=\"fs-5\">Cores</p>\n");
      out.write("                            </div>\n");
      out.write("                            <i class=\"fas fa-solid fa-palette fs-1 primary-text border rounded-full secondary-bg p-3\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row justify-content-center\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar my-1\" data-bs-toggle=\"modal\" data-bs-target=\"#ModalCores\">Exibir</button>\n");
      out.write("                        </div>        \n");
      out.write("                    </div>\n");
      out.write("                </div>        \n");
      out.write("                <!-- Final Cards   -->\n");
      out.write("                \n");
      out.write("                <!-- Iniciar tabela -->\n");
      out.write("                <div class=\"row my-5 \">\n");
      out.write("                    <div class=\"row position-relative\">\n");
      out.write("                        <h3 class=\"fs-4 mb-3 text-success\">Garagem</h3>\n");
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
            
            int start;

            if(request.getParameter("page") == null){
                start = 0;
            } else{
                start = Integer.valueOf(request.getParameter("page"));
            }
            
            int totalRegistorPorPagina = 4;

            if(start==0 || start ==1 ){
                 start = 0;
            }
            else{
                start = start * totalRegistorPorPagina-4;
            }
            
            ArrayList<Veiculos> nt = dao.pesquisaTudoVeiculoTabela(start,totalRegistorPorPagina);
            
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
      out.write("                                    <td class=\"\"><a href=\"DeletarVeiculo?id=");
      out.print(vid);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vmodelo);
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
      out.write("                                        <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Editar Veiculo</h1>\n");
      out.write("                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                            <form  action=\"EditarVeiculo\" method=\"POST\">\n");
      out.write("                                                 <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Codigo</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"id\" value=\"");
      out.print(vid);
      out.write("\" readonly>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Ano</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"ano\"  value=\"");
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
      out.write("                                                    <select class=\"form-select\" aria-label=\"Default select example\" name=\"disponibilidade\">\n");
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
      out.write("                                                        <label for=\"exampleInputText\">Modelo</label>\n");
      out.write("                                                        <select class=\"form-select\" aria-label=\"Default select example\" name=\"modelo\">\n");
      out.write("                                                            <option selected value=\"");
      out.print(vmodelo_id);
      out.write("\">Modelo: ");
      out.print(vmodelo);
      out.write(" | Marca: ");
      out.print(vmarca);
      out.write(" </option>\n");
      out.write("                                                       ");
  
                                                                String modeloNomeEditar = "";
                                                                String modeloIdEditar = "";
                                                                String marcasNomeEditar="";

                                                                Modelo modeloEditar2 = new Modelo();
                                                                ArrayList<Modelo> arryModelo2 = modelodao.pesquisaTudoModelo();

                                                                for(int a = 0; a < arryModelo2.size();a++){
                                                                    modeloEditar2 = arryModelo2.get(a);
                                                                    modeloNomeEditar = modeloEditar2.getNome();
                                                                    modeloIdEditar = String.valueOf(modeloEditar2.getId());
                                                                    marcasNomeEditar = String.valueOf(modeloEditar2.getMarca());
                                                            
      out.write("\n");
      out.write("                                                                    <option value=\"");
      out.print(modeloIdEditar);
      out.write("\">Modelo: ");
      out.print(modeloNomeEditar);
      out.write(" | Marca: ");
      out.print(marcasNomeEditar);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                                                ");
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
      out.print(vcores_id);
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

                                                        for(int i3 = 0; i3 < arryCor2.size();i3++){
                                                            cor2 = arryCor2.get(i3);
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
      out.write("                    <nav aria-label=\"Page navigation example position-absolute top-50 start-50 translate-middle\">\n");
      out.write("                            <ul class=\"pagination\">\n");
      out.write("                                ");
   
                                    
                                Veiculos countObj = dao.totalVeiculos();
                                double totalCount = Double.valueOf(countObj.getId());
                                double paginacao = totalCount/totalRegistorPorPagina;
                                int contadorPag = 1;
                                if(paginacao != (int) paginacao){
                                    if(paginacao % 2 != 0){
                                        paginacao +=1;
                                    }
                                }
                                for (int p = 1; p <= paginacao;p++){
                                
      out.write("\n");
      out.write("                                <li class=\"page-item\"><a class=\"page-link\" href=\"garagem.jsp?page=");
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
      out.write("                            \n");
      out.write("                </div>\n");
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
