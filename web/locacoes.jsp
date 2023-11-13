<%-- 
    Document   : locacoes
    Created on : 27/05/2023, 16:03:12
    Author     : Tonilson
--%>

<%@page import="br.com.controle.Decimal"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="br.com.controle.Funcionario"%>
<%@page import="br.com.controle.Contador"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.controle.Veiculos"%>
<%@page import="br.com.DAO.ManterVeiculo"%>
<%@page import="br.com.controle.Cliente"%>
<%@page import="br.com.DAO.ManterCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.controle.Locacoes"%>
<%@page import="br.com.DAO.ManterLocacoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/styles3.css" />
    <title>Locações</title>
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

        <!-- Modal Cadastro -->
        <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastrar Locação</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="CadastroLocacao" method="POST">
                        <div class="form-group margin-input">
                          
                            <label for="exampleInputText">Cliente</label>
                            <select class="form-select" aria-label="Default select example" name="cliente" required>
                                <option value="">Selecione Cliente</option>
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
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Data Locação</label>
                                <input type="date" class="form-control" name="dataLocacao" required>
                            </div>
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Data Termino</label>
                                <input type="date" class="form-control" name="dataTermino" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Automovel Disponivel</label>
                                <select class="form-select" aria-label="Default select example" name="veiculo" required>
                                    <option value="">Selecione Veiculo</option>
                                    <%
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
                                            
                                    %>
                                            <option value="<%=vidVeiculo%>">Placa: <%=vplacaVeiculo%> | Modelo: <%=vmodeloVeiculo%> | Ano: <%=vanoVeiculo%> | Cor: <%=vcorVeiculo%></option>
                                            <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Valor Diaria</label>
                                <input type="text" class="form-control money2" name="diaria" placeholder="Insira o valor" required>
                            </div>
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Valor Total </label>
                                <input type="text" class="form-control money2" name="valorLocacao" placeholder="Insira o valor" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Valor Pago</label>
                                <input type="text" class="form-control money2" name="valorPago" placeholder="Insira o valor" required>
                            </div>
                        </div>
                       
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                <button type="submit" class="btn btn-primary">Cadastrar</button></form>
                </div>
            </div>
            </div>
        </div>
         <!-- Fim Modal Cadastro-->
         
        <!-- Modal Pagamento -->
        <div class="modal fade " id="ModalPagamento" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Pagamento</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="LocacaoPagamento" method="POST">
                        <div class="form-group margin-input">
                            <label for="exampleInputText">Locação </label>
                            <select class="form-select" aria-label="Default select example" name="pagamento" required>
                                <option value="">Selecione Locaçao</option>
                                 <%
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
                         %>
                                <option value="<%=vidLocPag%>">Nome: <%=vclientePag%> | CPF: <%=vcpfCliente%> | Data Locação: <%=vdataInicioFormatPag%> | Valor Locação: <%=vvalorTotalPag%></option>
                                
                            <% }} %>
                             </select>
                        </div>
                       <div class="form-group margin-input">
                                <label for="exampleInputText">Valor Pagamento</label>
                                <input type="text" class="form-control money2" name="valorPago" placeholder="Insira o valor" required>
                                
                        </div>
                                
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                <button type="submit" class="btn btn-primary">Pagar</button></form>
                </div>
            </div>
            </div>
        </div>
         <!-- Fim Modal Pagamento-->  
         



        <!-- Sidebar -->
         <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-solid fa-car-side me-2"></i>LOCCAR</div>
            <div class="list-group list-group-flush my-3">
                <a href="index.jsp" class="list-group-item list-group-item-action bg-transparent second-text "><i
                        class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="locacoes.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
                        class="fas fa-solid fa-car me-2"></i>Locações</a>
                <a href="garagem.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-warehouse me-2"></i>Garagem</a>
                <a href="cliente.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user me-2"></i>Clientes</a>
                <a href="funcionarios.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user-tie me-2"></i>Funcionarios</a>
                <a href="historico.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-file me-2"></i>Histórico</a>
                <a href="relatorio.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-file-invoice me-2"></i>Relatório</a>
                <a href="remover.jsp" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
            </div>
            </div>
        <!-- /#sidebar-wrapper -->

        
        
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                    <h2 class="fs-2 m-0">Dashboard</h2>
                </div>
            </nav>
            <div class="container-fluid px-4">
                
                <!--  Cards   -->
                <div class="row g-3 ">
                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <% 
                            Veiculos totalVeiculoDisp = new Veiculos();
                            ManterVeiculo daoTotalVeiculo = new ManterVeiculo();
                            
                            totalVeiculoDisp = daoTotalVeiculo.totalVeiculosDisponivel();
                            
                            String vtotalVeiDisp = String.valueOf(totalVeiculoDisp.getId());

                            %>
                                <h3 class="fs-2"><%=vtotalVeiDisp%></h3>
                                <p class="fs-5">Veiculos Disponivel</p>
                            </div>
                            <i class="fas fa-solid fa-car fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                            <% 
                            Cliente totalCliente = new Cliente();
                            ManterCliente daoTotalCliente = new ManterCliente();
                            
                            totalCliente = daoTotalCliente.totalCliente();
                            
                            String vtotalCliente = String.valueOf(totalCliente.getCodigo());

                            %>
                                <h3 class="fs-2"><%=vtotalCliente%></h3>
                                <p class="fs-5">Clientes</p>
                            </div>
                            <i
                                class="fas fa-solid fa-users fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                  <% 
                            Locacoes locacaoTotalAtiva = new Locacoes();
                            ManterLocacoes daoTotalLocacoes = new ManterLocacoes();
                            
                            locacaoTotalAtiva = daoTotalLocacoes.totalLocacaoAtiva();
                            String totalLocacaoAtiva = String.valueOf(locacaoTotalAtiva.getCodigo());

                            %>
                                <h3 class="fs-2"><%=totalLocacaoAtiva%></h3>
                                <p class="fs-5">Locações Ativa</p>
                            </div>
                            <i class="fas fa-solid fa-car-side fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                 <% 
                            Locacoes locacaoTotal = new Locacoes();
                            
                            locacaoTotal = daoTotalLocacoes.totalLocacao();
                            String totalLocacao = String.valueOf(locacaoTotal.getCodigo());

                        %>
                                <h3 class="fs-2"><%=totalLocacao%></h3>
                                <p class="fs-5">Total Locações</p>
                            </div>
                            <i class="fas fa-solid fa-file-contract fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                      </div>
                </div>        
                <!-- Final Cards   -->
                
                
                

                <div class="row my-4 ">
                    <div class="row position-relative">
                        <h3 class="fs-4 mb-3 text-success col ">Locações</h3>
                        
                        <button type="button" class="btn btn-primary botao_cadastrar " style ="margin-right: 10px; width: 150px; " data-bs-toggle="modal" data-bs-target="#ModalPagamento">Pagamento</button>
                        <button type="button" class="btn btn-primary  botao_cadastrar col "  data-bs-toggle="modal" data-bs-target="#exampleModal">Cadastrar</button>
                       
                    </div>
                    
                    <!-- Inicio Tabela -->
                    <div class="table-responsive">
                        <table class="table bg-white rounded shadow-sm  table-hover table-striped">
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
                                    <th scope="col " width="50">Apagar</th>
                                    <th scope="col " width="50" >Editar</th>
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

                            Decimal descFomart = new Decimal();
                            ManterLocacoes locacaoDAO =new ManterLocacoes();
                            Locacoes loc = new Locacoes();

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

                            ArrayList<Locacoes> ntTabela = locacaoDAO.pesquisaTudoLocacoesTabela(start, totalRegistorPorPagina);
                              
                            
                           
                            for(int a1 = 0; a1 < ntTabela.size(); a1++){
                                loc = ntTabela.get(a1);
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
                                    <td class=""><a href="DeletarLocacao?id=<%=vidLoc%>&idCar=<%=vVeiculoID%>" onclick="return confirm('Confirma exclusão do registro <%=vidLoc%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
                                    <td><a href="#"data-bs-toggle="modal" data-bs-target="#modalEditar<%=vidLoc%>"><i class="fas fa-solid fa-pen me-2 d-flex justify-content-center"></i></a></td>
                                </tr>
                                
                                <!-- Modal Editar -->
                                <div class="modal fade " id="modalEditar<%=vidLoc%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog ">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Locação</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form  action="EditarLocacao" method="POST">
                                                 <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Codigo</label>
                                                    <input readonly type="text" class="form-control" name="id" value="<%=vidLoc%>" >
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Cliente</label>
                                                    <input readonly type="text" class="form-control"  value="<%=vcliente%>">
                                                    <input hidden type="text" class="form-control" name="cliente"  value="<%=vcliente_id%>">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Data Locação</label>
                                                    <input type="date" class="form-control" name="dataInicio" value="<%=vdataInicio%>" required>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Data Termino</label>
                                                    <input type="date" class="form-control" name="dataTermino" value="<%=vdatatermino%>" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                        
                                                        <label for="exampleInputText">Automoveis Disponiveis</label>
                                                        <select class="form-select" aria-label="Default select example" name="veiculo" required>
                                                            <option selected value="<%=vVeiculoID%>">Automovel Atual: <%=vautomovel%> | Placa: <%=vplaca%> </option>
                                                            <%
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

                                                            %>
                                                            <option value="<%=vidVeiculoEditar%>">Placa: <%=vplacaVeiculoEditar%> | Modelo: <%=vmodeloVeiculoEditar%> | Ano: <%=vanoVeiculoEditar%> | Cor: <%=vcorVeiculoEditar%></option>
                                                            <% } %>
                                                        </select>
                                                    </div>
                                                    <input type="text" name="veiculoAnteriorId" value="<%=vVeiculoID%>" hidden="">
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Valor Diaria</label>
                                                    <input type="text" class="form-control money2" name="valorDiaria" value="<%=vvalorDiaria%>" required>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Valor Total</label>
                                                    <input type="text" class="form-control money2" name="valorTotal" value="<%=vvalorTotal%>" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Valor Pago</label>
                                                    <input type="text" class="form-control money2" name="valorPago" value="<%=vvalorPago%>" required>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                        <label for="exampleInputText">Situação Locação</label>
                                                        
                                                        <select class="form-select" aria-label="Default select example" name="status" required>
                                                            <option value="<%=vstatusLocacao%>" selected><%=vstatusLocacao%></option>
                                                            <%  if(vstatusLocacao.equals("ALUGADO")){  %>
                                                            <option value="ENCERRADO">ENCERRADO</option>
                                                            <% } else{  %>
                                                            <option value="ALUGADO">ALUGADO</option>
                                                            <% }  %>
                                                        </select>
                                                    </div>
                                                </div>

                                        </div>
                                        <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                                        <button type="submit" class="btn btn-primary">Editar</button></form>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                                 <!-- Fim Modal Editar -->
                                
                                
                        <%    }   %>
                                
                            </tbody>
                        </table>
                    </div>
                    <nav aria-label="Page navigation example position-absolute top-50 start-50 translate-middle">
                            <ul class="pagination">
                                <%   
                                    
                                Locacoes countObj = locacaoDAO.totalLocacao();
                                double totalCount = Double.valueOf(countObj.getCodigo());
                                double paginacao = totalCount/totalRegistorPorPagina;
                                int contadorPag = 1;
                               if(paginacao != (int) paginacao){
                                    if(paginacao % 2 != 0){
                                        paginacao +=1;
                                    }
                                }
                                for (int p = 1; p <= paginacao;p++){
                                %>
                                <li class="page-item"><a class="page-link" href="locacoes.jsp?page=<%=contadorPag%>"><%=contadorPag%></a></li>
                                <%  
                                 contadorPag +=1 ;   }
                                %>
                            </ul>
                    </nav>   
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
   
    </div>

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
        $('.phone_with_ddd').mask('(00) 0000-0000');
        $('.mixed').mask('AAA 000-S0S');
        $('.cpf').mask('000.000.000-00', {reverse: true});
        $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
        
        
   </script>
   <!--   -->
</body>

</html>