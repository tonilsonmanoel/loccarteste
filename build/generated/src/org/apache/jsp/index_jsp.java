package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.controle.Funcionario;
import br.com.controle.Contador;
import java.util.Date;
import java.text.SimpleDateFormat;
import br.com.controle.Veiculos;
import br.com.DAO.ManterVeiculo;
import br.com.controle.Cliente;
import br.com.DAO.ManterCliente;
import java.util.ArrayList;
import br.com.controle.Locacoes;
import br.com.DAO.ManterLocacoes;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Index</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    <div class=\"d-flex\" id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Modal Cadastro -->\n");
      out.write("        <div class=\"modal fade \" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog \">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Cadastrar locação</h1>\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form  action=\"CadastroLocacao\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                          \n");
      out.write("                            <label for=\"exampleInputText\">Cliente</label>\n");
      out.write("                            <select class=\"form-select\" aria-label=\"Default select example\" name=\"cliente\">\n");
      out.write("                                <option selected>Selecione Cliente</option>\n");
      out.write("                                  ");

                            String vid = "";
                            String vnomeCliente = "";
                            String vcpfCliente ="";
                            ManterCliente dao = new ManterCliente();
                            Cliente ca = new Cliente();

                            ArrayList<Cliente> nt = dao.pesquisarTudoCliente();

                            for(int i = 0; i < nt.size(); i++){
                                ca = nt.get(i);
                                vid = String.valueOf(ca.getCodigo());
                                vnomeCliente = String.valueOf(ca.getNome());
                                vcpfCliente = ca.getCpf();
                
                            
                            
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(vid);
      out.write('"');
      out.write('>');
      out.print(vnomeCliente);
      out.write(" | CPF: ");
      out.print(vcpfCliente);
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Data Locação</label>\n");
      out.write("                                <input type=\"date\" class=\"form-control\" name=\"dataLocacao\" >\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Data Termino</label>\n");
      out.write("                                <input type=\"date\" class=\"form-control\" name=\"dataTermino\" >\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Automovel Disponivel</label>\n");
      out.write("                                <select class=\"form-select\" aria-label=\"Default select example\" name=\"veiculo\">\n");
      out.write("                                    <option selected>Selecione Veiculo</option>\n");
      out.write("                                    ");

                                        String vidVeiculo ="";
                                        String vplacaVeiculo = "";
                                        String vanoVeiculo = "";
                                        String vmodeloVeiculo = "";
                                        String vcorVeiculo = "";
                                        
                                        ManterVeiculo daoVeiculo = new ManterVeiculo();
                                        Veiculos vei = new Veiculos();

                                        ArrayList<Veiculos> nt3 = daoVeiculo.pesquisaVeiculoDisponivel();

                                        for(int i = 0; i < nt3.size(); i++){
                                            vei = nt3.get(i);
                                            vidVeiculo = String.valueOf(vei.getId());
                                            vplacaVeiculo = vei.getPlaca();
                                            vanoVeiculo = String.valueOf(vei.getAno());
                                            vmodeloVeiculo = vei.getModelo();
                                            vcorVeiculo = vei.getCor();
                                            
                                    
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(vidVeiculo);
      out.write("\">Placa: ");
      out.print(vplacaVeiculo);
      out.write(" | Modelo: ");
      out.print(vmodeloVeiculo);
      out.write(" | Ano: ");
      out.print(vanoVeiculo);
      out.write(" | Cor: ");
      out.print(vcorVeiculo);
      out.write("</option>\n");
      out.write("                                            ");
 } 
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Valor Diaria</label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"diaria\" placeholder=\"Insira o valor\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Valor Total </label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"valorLocacao\" placeholder=\"Insira o valor\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group margin-input col\">\n");
      out.write("                                <label for=\"exampleInputText\">Valor Pago</label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"valorPago\" placeholder=\"Insira o valor\">\n");
      out.write("                            </div>\n");
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
      out.write("        <!-- Modal Pagamento -->\n");
      out.write("        <div class=\"modal fade \" id=\"ModalPagamento\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-lg\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Pagamento</h1>\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form  action=\"LocacaoPagamento\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group margin-input\">\n");
      out.write("                            <label for=\"exampleInputText\">Nome </label>\n");
      out.write("                            <select class=\"form-select\" aria-label=\"Default select example\" name=\"pagamento\">\n");
      out.write("                                <option selected>Selecione Cliente</option>\n");
      out.write("                                 ");

                            String vidLocPag= "";
                            String vclientePag = "";
                            String vvalorTotalPag ="";
                            String vvalorPagoPag ="";
                            String vstatusLocacaoPag ="";
                            String vdataInicioFormatPag = "";
                            String vdataTerminoFormatPag = "";

                            ManterLocacoes locacaoDAOPg =new ManterLocacoes();
                            Locacoes locPg = new Locacoes();

                            ArrayList<Locacoes> ntPg = locacaoDAOPg.pesquisaTudoLocacoes();


                            for(int i = 0; i < ntPg.size(); i++){
                                locPg = ntPg.get(i);
                                vidLocPag = String.valueOf(locPg.getCodigo());
                                vclientePag = locPg.getCliente();
                                vdataInicioFormatPag = locPg.getData_inicioFormat();
                                vdataTerminoFormatPag = locPg.getData_terminoFormat();
                                vvalorTotalPag =   String.valueOf(locPg.getValor_locacao());
                                vvalorPagoPag = String.valueOf(locPg.getValor_pago());
                                vstatusLocacaoPag = locPg.getStatusLocacoes();
                                if(vstatusLocacaoPag.equals("ALUGADO")){
                         
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(vidLocPag);
      out.write("\">Nome: ");
      out.print(vclientePag);
      out.write(" | CPF: ");
      out.print(vcpfCliente);
      out.write(" | Data Locação: ");
      out.print(vdataInicioFormatPag);
      out.write(" | Valor Locação: ");
      out.print(vvalorTotalPag);
      out.write("</option>\n");
      out.write("                                \n");
      out.write("                            ");
 }} 
      out.write("\n");
      out.write("                             </select>\n");
      out.write("                        </div>\n");
      out.write("                       <div class=\"form-group margin-input\">\n");
      out.write("                                <label for=\"exampleInputText\">Valor Pagamento</label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"valorPago\" placeholder=\"Insira o valor\">\n");
      out.write("                                \n");
      out.write("                        </div>\n");
      out.write("                                \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Fechar</button>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Pagar</button></form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("         <!-- Fim Modal Pagamento-->  \n");
      out.write("         \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <div class=\"bg-white\" id=\"sidebar-wrapper\">\n");
      out.write("            <div class=\"sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom\"><i\n");
      out.write("                    class=\"fas fa-solid fa-car-side me-2\"></i>LOCCAR</div>\n");
      out.write("            <div class=\"list-group list-group-flush my-3\">\n");
      out.write("                <a href=\"index.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text active\"><i\n");
      out.write("                        class=\"fas fa-tachometer-alt me-2\"></i>Dashboard</a>\n");
      out.write("                <a href=\"locacoes.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
      out.write("                        class=\"fas fa-solid fa-car me-2\"></i>Locações</a>\n");
      out.write("                <a href=\"garagem.jsp\" class=\"list-group-item list-group-item-action bg-transparent second-text fw-bold\"><i\n");
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
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n");
      out.write("                    data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\"\n");
      out.write("                    aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("            </nav>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"container-fluid px-4\">\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div class=\"row my-5 \">\n");
      out.write("                    <div class=\"row position-relative\">\n");
      out.write("                        <h3 class=\"fs-4 mb-3 text-dark col \">Locações Ativas</h3>\n");
      out.write("                        \n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary botao_cadastrar \" style =\"margin-right: 10px; width: 150px; \" data-bs-toggle=\"modal\" data-bs-target=\"#ModalPagamento\">Pagamento</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary  botao_cadastrar col \"  data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Cadastrar</button>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <!-- Inicio Tabela -->\n");
      out.write("                    <div class=\"table-responsive\">\n");
      out.write("                        <table class=\"table bg-white rounded shadow-sm  table-hover table-striped\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\" width=\"50\">#</th>\n");
      out.write("                                    <th scope=\"col\">Cliente</th>\n");
      out.write("                                    <th scope=\"col\">Data Locação</th>\n");
      out.write("                                    <th scope=\"col\">Data Termino</th>\n");
      out.write("                                    <th scope=\"col\">Placa</th>\n");
      out.write("                                    <th scope=\"col\">Automovel</th>\n");
      out.write("                                    <th scope=\"col\">Cor</th>\n");
      out.write("                                    <th scope=\"col\">Valor Diaria</th>\n");
      out.write("                                    <th scope=\"col\">Valor Total</th>\n");
      out.write("                                    <th scope=\"col\">Valor Pago</th>\n");
      out.write("                                    <th scope=\"col\">Situação</th>\n");
      out.write("                                    <th scope=\"col \" width=\"50\">Apagar</th>\n");
      out.write("                                    <th scope=\"col \" width=\"50\" >Editar</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");

                            String vidLoc= "";
                            String vcliente = "";
                            String vdataInicio = "";
                            String vdatatermino = "";
                            String vplaca = "";
                            String vautomovel = "";
                            String vvalorDiaria = "";
                            String vvalorTotal ="";
                            String vvalorPago ="";
                            String vstatusLocacao ="";
                            String vCorLoc = "";
                            String vVeiculoID ="";
                            String vcliente_id = "";
                            String vdataInicioFormat = "";
                            String vdataTerminoFormat = "";

                            ManterLocacoes locacaoDAO =new ManterLocacoes();
                            Locacoes loc = new Locacoes();

                            ArrayList<Locacoes> nt4 = locacaoDAO.pesquisaTudoLocacoes();


                            for(int i = 0; i < nt4.size(); i++){
                                loc = nt4.get(i);
                                vidLoc = String.valueOf(loc.getCodigo());
                                vcliente = loc.getCliente();
                                vdataInicio = loc.getData_inicio();
                                vdatatermino = loc.getData_termino();
                                vdataInicioFormat = loc.getData_inicioFormat();
                                vdataTerminoFormat = loc.getData_terminoFormat();
                                vplaca = loc.getPlaca();
                                vautomovel = loc.getModelo();
                                vvalorDiaria =  String.valueOf(loc.getValor_diaria());
                                vvalorTotal =   String.valueOf(loc.getValor_locacao());
                                vvalorPago =    String.valueOf(loc.getValor_pago());
                                vstatusLocacao = loc.getStatusLocacoes();
                                vCorLoc = loc.getCor();
                                vVeiculoID = String.valueOf(loc.getPlaca_id());
                                vcliente_id = String.valueOf(loc.getCliente_id());
                                if(vstatusLocacao.equals("ALUGADO")){
                                                                    
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"row\">");
      out.print(vidLoc);
      out.write("</th>\n");
      out.write("                                    <td>");
      out.print(vcliente);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vdataInicioFormat);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vdataTerminoFormat);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vplaca);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vautomovel);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(vCorLoc);
      out.write("</td>\n");
      out.write("                                    <td>R$ ");
      out.print(vvalorDiaria);
      out.write("</td>\n");
      out.write("                                    <td>R$ ");
      out.print(vvalorTotal);
      out.write("</td>\n");
      out.write("                                    <td>R$ ");
      out.print(vvalorPago);
      out.write("</td>\n");
      out.write("                                    <td >");
      out.print(vstatusLocacao);
      out.write("</td>\n");
      out.write("                                    <td class=\"\"><a href=\"DeletarLocacao?id=");
      out.print(vidLoc);
      out.write("\" onclick=\"return confirm('Confirma exclusão do registro ");
      out.print(vidLoc);
      out.write("?')\"><i class=\"fas fa-solid fa-trash me-2 d-flex justify-content-center \" style=\"color: #ff0000;\"></i></a></td>\n");
      out.write("                                    <td><a href=\"#\"data-bs-toggle=\"modal\" data-bs-target=\"#modalEditar");
      out.print(vidLoc);
      out.write("\"><i class=\"fas fa-solid fa-pen me-2 d-flex justify-content-center\"></i></a></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <!-- Final Tabela -->\n");
      out.write("                                \n");
      out.write("                                <!-- Modal Editar -->\n");
      out.write("                                <div class=\"modal fade \" id=\"modalEditar");
      out.print(vidLoc);
      out.write("\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                    <div class=\"modal-dialog \">\n");
      out.write("                                    <div class=\"modal-content\">\n");
      out.write("                                        <div class=\"modal-header\">\n");
      out.write("                                        <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Editar Locação</h1>\n");
      out.write("                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                            <form  action=\"EditarLocacao\" method=\"POST\">\n");
      out.write("                                                 <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Codigo</label>\n");
      out.write("                                                    <input readonly type=\"text\" class=\"form-control\" name=\"id\" value=\"");
      out.print(vidLoc);
      out.write("\" >\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Cliente</label>\n");
      out.write("                                                    <input readonly type=\"text\" class=\"form-control\"  value=\"");
      out.print(vcliente);
      out.write("\">\n");
      out.write("                                                    <input hidden type=\"text\" class=\"form-control\" name=\"cliente\"  value=\"");
      out.print(vcliente_id);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Data Locação</label>\n");
      out.write("                                                    <input type=\"date\" class=\"form-control\" name=\"dataInicio\" value=\"");
      out.print(vdataInicio);
      out.write("\" >\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Data Termino</label>\n");
      out.write("                                                    <input type=\"date\" class=\"form-control\" name=\"dataTermino\" value=\"");
      out.print(vdatatermino);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                        \n");
      out.write("                                                        <label for=\"exampleInputText\">Automoveis Disponiveis</label>\n");
      out.write("                                                        <select class=\"form-select\" aria-label=\"Default select example\" name=\"veiculo\">\n");
      out.write("                                                            <option selected value=\"");
      out.print(vVeiculoID);
      out.write("\">Automovel Atual: ");
      out.print(vautomovel);
      out.write(" | Placa: ");
      out.print(vplaca);
      out.write(" </option>\n");
      out.write("                                                            ");

                                                                String vidVeiculoEditar ="";
                                                                String vplacaVeiculoEditar = "";
                                                                String vanoVeiculoEditar = "";
                                                                String vmodeloVeiculoEditar = "";
                                                                String vcorVeiculoEditar = "";
                                                                
                                                                for(int b = 0; b < nt3.size(); b++){
                                                                    vei = nt3.get(b);
                                                                    vidVeiculoEditar = String.valueOf(vei.getId());
                                                                    vplacaVeiculoEditar = vei.getPlaca();
                                                                    vanoVeiculoEditar = String.valueOf(vei.getAno());
                                                                    vmodeloVeiculoEditar = vei.getModelo();
                                                                    vcorVeiculoEditar = vei.getCor();

                                                            
      out.write("\n");
      out.write("                                                            <option value=\"");
      out.print(vidVeiculoEditar);
      out.write("\">Placa: ");
      out.print(vplacaVeiculoEditar);
      out.write(" | Modelo: ");
      out.print(vmodeloVeiculoEditar);
      out.write(" | Ano: ");
      out.print(vanoVeiculoEditar);
      out.write(" | Cor: ");
      out.print(vcorVeiculoEditar);
      out.write("</option>\n");
      out.write("                                                            ");
 } 
      out.write("\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <input type=\"text\" name=\"veiculoAnteriorId\" value=\"");
      out.print(vVeiculoID);
      out.write("\" hidden=\"\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Valor Diaria</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control\" name=\"valorDiaria\" value=\"");
      out.print(vvalorDiaria);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Valor Total</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control\" name=\"valorTotal\" value=\"");
      out.print(vvalorTotal);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                    <label for=\"exampleInputText\">Valor Pago</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control\" name=\"valorPago\" value=\"");
      out.print(vvalorPago);
      out.write("\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group margin-input col\">\n");
      out.write("                                                        <label for=\"exampleInputText\">Status Locação</label>\n");
      out.write("                                                        <select class=\"form-select\" aria-label=\"Default select example\" name=\"status\">\n");
      out.write("                                                            <option value=\"ALUGADO\" selected>ALUGADO</option>\n");
      out.write("                                                            <option value=\"ENCERRADO\">ENCERRADO</option>\n");
      out.write("                                                            \n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
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
    }}   
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
      out.write("   \n");
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
      out.write("        \n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("    \n");
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
