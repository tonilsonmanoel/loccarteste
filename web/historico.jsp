<%-- 
    Document   : historico.jsp
    Created on : 12/10/2023, 14:05:42
    Author     : Tonilson
--%>

<%@page import="br.com.controle.Decimal"%>
<%@page import="br.com.controle.Funcionario"%>
<%@page import="br.com.controle.Cliente"%>
<%@page import="br.com.DAO.ManterCliente"%>
<%@page import="br.com.controle.Modelo"%>
<%@page import="br.com.controle.Modelo"%>
<%@page import="br.com.DAO.ManterModelo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.DAO.ManterLocacoes"%>
<%@page import="br.com.controle.Locacoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/styles3.css" />
    <title>Historico</title>
    </head>
    <body>
         <%  
        Funcionario user = (Funcionario) session.getAttribute("usuarioLogado");
        System.out.print(user);

        if(user == null){
              Thread.sleep(500);
              response.sendRedirect("login.jsp?alert=1");
        }
        
        if(user != null){}
    %>
         <div class="d-flex" id="wrapper">       

        <!-- Sidebar -->
        <div class="bg-white " id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-solid fa-car-side me-2"></i>LOCCAR</div>
            <div class="list-group list-group-flush my-3">
                <a href="index.jsp" class="list-group-item list-group-item-action bg-transparent second-text "><i
                        class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="locacoes.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-car me-2"></i>Locações</a>
                <a href="garagem.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-warehouse me-2"></i>Garagem</a>
                <a href="cliente.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user me-2"></i>Clientes</a>
                <a href="funcionarios.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user-tie me-2"></i>Funcionarios</a>
                <a href="historico.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
                        class="fas fa-solid fa-file me-2"></i>Histórico</a>
                <a href="relatorio.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-file me-2"></i>Relatório</a>
                <a href="remover.jsp" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
            </div>
        </div>
        <!-- sidebar-wrapper -->

        
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                    <h2 class="fs-2 m-0">Dashboard</h2>
                </div>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </nav>
            
            <div class="container-fluid px-4 ">
                
                    
                
               
                    
                    <form action="" method="POST">
               <div class="container text-center bg-light p-2 rounded shadow-sm ">
                   <div class="row p-2">
                        <div class="col">
                            <input type="text" class="form-control col-md-3 placa" name="search" placeholder="Buscar Placa">
                        </div>
                        <div class="col">
                            <select class="form-select" aria-label="Default select example" name="modelo">
                               <option value="" selected>Automovel</option>
                                <%  
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
                                %>
                                        <option value="<%=modeloId%>">Modelo: <%=modeloNome%> | Marca: <%=marcasNome%></option>

                                    <% } %>
                            </select>
                            
                        </div>
                            <div class="col ">
                            <select class="form-select" aria-label="Default select example" name="cliente">
                                <option selected value="">Selecione Cliente</option>
                                  <%
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
                
                            
                            %>
                                <option value="<%=vid%>"><%=vnomeCliente%> | CPF: <%=vcpfCliente%></option>
                                <% } %>
                            </select>
                        </div>
                              
                            <div class="col">
                                <select class="form-select"  name="situacao">
                                    <option value="" selected>Situação</option>
                                    <option value="ALUGADO">ALUGADO</option>
                                      <option value="ENCERRADO">ENCERRADO</option>
                                </select>
                            </div>
                            
                        </div>
                    <div class="row align-items-center">
                            <div class="form-group  col-2">
                                
                                <label for="exampleInputText">Data Locação</label>
                                <input type="date" class="form-control" name="dataLocacao" >
                            </div>
                            <div class="form-group  col-2">
                                <label for="exampleInputText">Data Termino</label>
                                <input type="date" class="form-control" name="dataTermino" >
                            </div>
                        <div class="form-group col-1 ">
                            <button type="submit" class="btn btn-primary">Buscar</button>
                        </div>
                    </div>     
                </div>  
                  </form>
                </div>
              
        
        <!-- Inicio Tabela -->
                    <div class="row my-5 px-4">
                        <div class="table-responsive">
                        <table class="table bg-white rounded shadow-sm  table-hover  ">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Data Locação</th>
                                    <th scope="col">Data Termino</th>
                                    <th scope="col">Placa</th>
                                    <th scope="col">Automovel</th>
                                    <th scope="col">Cor</th>
                                    <th scope="col">Valor Diaria</th>
                                    <th scope="col">Valor Total</th>
                                    <th scope="col">Valor Pago</th>
                                    <th scope="col">Situação</th>
                                  
                                </tr>
                            </thead>
                            <tbody>
                    <% 
                       
                      
                     
                       
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
                            
                            
                     ManterLocacoes daoLocacoes = new ManterLocacoes();
                     Locacoes loc = new Locacoes();
                     ArrayList<Locacoes> listaLoc;
                     Decimal descFomart = new Decimal();
                     
                     // Parametro para paginação
                        int start;

                            if(request.getParameter("page") == null){
                                start = 0;
                            } else{
                                start = Integer.valueOf(request.getParameter("page"));
                            }

                            int totalRegistorPorPagina = 3;

                            if(start ==1 || start ==0){
                                start = 0;
                            }
                            else{
                                start = start * totalRegistorPorPagina-3;
                            }
                     //Parametro para paginação
                     // pesquisar data de locações
                     String dataInicio = request.getParameter("dataLocacao");
                     String dataFinal = request.getParameter("dataTermino");
                  
                     if((dataInicio != null && !dataInicio.isEmpty()) || (dataFinal != null && !dataFinal.isEmpty()) ){
                         listaLoc = daoLocacoes.buscarDataLocacoes(dataInicio, dataFinal);
                     } else{
                         listaLoc =  daoLocacoes.pesquisaTudoLocacoes();
                     }
                     // fim pesquisar data de locações
                    
                     String modeloVeiculo = request.getParameter("modelo");
                     String corVeiculo = request.getParameter("corVeiculo"); 
                     String situacao = request.getParameter("situacao"); 
                     String searchBar = request.getParameter("search"); 
      
                     String cliente = request.getParameter("cliente"); 
                    
                    
                       
                       for(int a1 = 0; a1 < listaLoc.size(); a1++){
                        loc = listaLoc.get(a1);
                         boolean modeloEnc = (modeloVeiculo == null || modeloVeiculo.equals("")|| (loc.getModelo_id() == Integer.valueOf(modeloVeiculo)));
                         boolean corEnc = (corVeiculo == null ||corVeiculo.equals("") || loc.getCor().contains(corVeiculo));
                         boolean sit = (situacao == null ||situacao.equals("") || loc.getStatusLocacoes().contains(situacao));
                          boolean searchMatch = (searchBar == null ||searchBar.equals("") || loc.getPlaca().toLowerCase().contains(searchBar.toLowerCase()));
                         boolean clienteMatch = (cliente == null ||cliente.equals("") || loc.getCliente_id() == Integer.valueOf(cliente));
                    
                         
                        
                           if(modeloEnc && corEnc && sit && searchMatch && clienteMatch ){
                                
                                vidLoc = String.valueOf(loc.getCodigo());
                                vcliente = loc.getCliente();
                                vdataInicio = loc.getData_inicio();
                                vdatatermino = loc.getData_termino();
                                vdataInicioFormat = loc.getData_inicioFormat();
                                vdataTerminoFormat = loc.getData_terminoFormat();
                                vplaca = loc.getPlaca();
                                vautomovel = loc.getModelo();
                                vvalorDiaria =  String.valueOf(descFomart.getDecimalFormat(loc.getValor_diaria()));
                                vvalorTotal =   String.valueOf(descFomart.getDecimalFormat(loc.getValor_locacao()));
                                vvalorPago =    String.valueOf(descFomart.getDecimalFormat(loc.getValor_pago()));
                                vstatusLocacao = loc.getStatusLocacoes();
                                vCorLoc = loc.getCor();
                                vVeiculoID = String.valueOf(loc.getPlaca_id());
                                vcliente_id = String.valueOf(loc.getCliente_id());
                                

                                                                    %>
                                <tr>
                                    <th scope="row"><%=vidLoc%></th>
                                    <td><%=vcliente%></td>
                                    <td><%=vdataInicioFormat%></td>
                                    <td><%=vdataTerminoFormat%></td>
                                    <td><%=vplaca%></td>
                                    <td><%=vautomovel%></td>
                                    <td><%=vCorLoc%></td>
                                    <td>R$ <%=vvalorDiaria%></td>
                                    <td>R$ <%=vvalorTotal%></td>
                                    <td>R$ <%=vvalorPago%></td>
                                    <td ><%=vstatusLocacao%></td>
                                </tr>
                                <%  }} %>
                            </tbody>
                        </table>
                      </div>
                              
                    </div>            
                   </div>  
                             </div> 
    </div><!-- fim -->
   
    <!-- /#page-content-wrapper -->
   

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };
        
        
    </script>
     <!--- Jquery e mascaras de campos --->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
    <script>
        $('.money2').mask("#.##0,00", {reverse: true});
        $('.cep').mask('00000-000');
        $('.phone').mask('0000-0000');
        $('.placa').mask('AAA-AAAA');
        $('.phone_with_ddd').mask('(00) 00000-0000');
        $('.mixed').mask('AAA 000-S0S');
        $('.cpf').mask('000.000.000-00', {reverse: true});
        $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
    </script>
    <!--   -->
    </body>
</html>
