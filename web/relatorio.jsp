

<%@page import="br.com.DAO.ManterModelo"%>
<%@page import="br.com.controle.Modelo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.controle.Cliente"%>
<%@page import="br.com.DAO.ManterCliente"%>
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
    <link rel="stylesheet" href="css/styles.css" />
    <title>Relatorio</title>
</head>

<body>
   
    <div class="d-flex" id="wrapper">

         

        <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-solid fa-car-side me-2"></i>LOCCAR</div>
            <div class="list-group list-group-flush my-3">
                <a href="index.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i
                        class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="locacoes.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-car me-2"></i>Locações</a>
                <a href="garagem.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-warehouse me-2"></i>Garagem</a>
                <a href="cliente.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user me-2"></i>Clientes</a>
                <a href="funcionarios.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user-tie me-2"></i>Funcionarios</a>
                <a href="historico.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-file me-2"></i>Histórico</a>        
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
            
            <div class="container-fluid px-10 mx-auto w-75">
           
                
                
                     <form action="" method="GET">
               <div class="container text-center bg-light p-2 rounded shadow-sm ">
                   <div class="row p-2">
                       
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
                        <div class="col-3 ">
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
                        <div class="form-group col-1 ">
                            <button type="submit" class="btn btn-primary">Buscar</button>
                        </div>
                         <div class="form-group col-1 ">
                             <a href="ServertRelatorio" class="btn btn-primary">Relatorio</a>
                        </div>
                        
                        
                          
                    </div>        
                            
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
    
</body>

</html>