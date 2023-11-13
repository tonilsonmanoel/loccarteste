

<%@page import="br.com.controle.Funcionario"%>
<%@page import="br.com.controle.Marca"%>
<%@page import="br.com.DAO.ManterMarca"%>
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
    <link rel="stylesheet" href="css/styles3.css" />
    <title>Relatorio Garagem</title>
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
                <a href="historico.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-file me-2"></i>Histórico</a>       
                <a href="relatorio.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
                        class="fas fa-solid fa-file me-2"></i>Relatório</a>
                <a href="remover.jsp" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
            </div>
        </div>
        <!-- sidebar-wrapper -->

        
        <!-- Page Content -->
        <div id="page-content-wrapper position-relative">
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
            
            <div class="container-fluid px-10 mx-auto w-50 position-absolute top-50 start-50 translate-middle">
           
                
                
                     <form action="ServertRelatorio" method="POST">
                      <input hidden="true" name="tipoRelatorio" value="garagemRelatorio">
               <div class="container text-center bg-light p-2 rounded shadow-sm ">
                   <div class="row p-1">
                       <div class="col">
                           <h3 class="fs-3 mb-1 col ">Relatório</h3>
                       </div>
                   </div>
                   
                    <div class="row p-1  ">
                         <div class="col d-flex justify-content-start  gap-2">
                             <label>Tipo de relatório:&nbsp&nbsp   </label>
                            <a href="relatorio.jsp"><button  type="button" class="btn btn-primary p-1">Locações</button></a>
                             <a href="relatoriogaragem.jsp"><button type="button"  class="btn btn-primary p-1">Garagem</button></a>
                             <a href="relatoriocliente.jsp"><button type="button"  class="btn btn-primary p-1">Cliente</button></a>
                             <a href="relatoriofuncionarios.jsp"><button type="button" class="btn btn-primary p-1">Funcionarios</button></a>
                       </div>
                     
                   </div>
                    
                   <div class="row p-2">
                       
                        <div class="col">
                            <select class="form-select" aria-label="Default select example" name="modelo">
                               <option value="" selected>Modelo</option>
                                <%  
                                    String modeloNome = "";
                                    String modeloId = "";
                                    
                                    
                                    ManterModelo modelodao = new ManterModelo();
                                    Modelo modelo = new Modelo();
                                    ArrayList<Modelo> arryModelo = modelodao.pesquisaTudoModelo();

                                    for(int a = 0; a < arryModelo.size();a++){
                                        modelo = arryModelo.get(a);
                                        modeloNome = modelo.getNome();
                                        modeloId = String.valueOf(modelo.getId());
                                        
                                %>
                                        <option value="<%=modeloId%>">Modelo: <%=modeloNome%></option>

                                    <% } %>
                            </select>
                        </div>
                        <div class="col">
                            <select class="form-select" aria-label="Default select example" name="marca">
                               <option value="" selected>Marca</option>
                                <%  
                                   
                                    String marcasID = "";
                                    String marcaNome="";
                                    
                                    ManterMarca daoModelo = new ManterMarca();
                                    Marca marca = new Marca();
                                    
                                    ArrayList<Marca> listMarca = daoModelo.pesquisaTudoMarca();
                   

                                    for(int a = 0; a < listMarca.size();a++){
                                        marca = listMarca.get(a);
                                        marcaNome = marca.getNome();
                                        marcasID = String.valueOf(marca.getCodigo());
                                       
                                %>
                                        <option value="<%=marcaNome%>">Marca: <%=marcaNome%></option>

                                    <% } %>
                            </select>
                        </div>
                             
                        <div class="col">
                            <select class="form-select"  name="ano">
                                <option value="" selected>ANO</option>
                                
                                <%
                                  for(int x = 2023; x > 2000; x-- ){
                                      
                                  

                                %>
                                   <option value="<%=x%>"><%=x%></option>   
                                <%  }%>
                            </select>
                        </div>
                        
                            
                    </div>
                   
                    <div class="row align-items-center p-2 d-flex justify-content-evenly">
                        <div class="col">
                            <select class="form-select"  name="disponibilidade">
                                <option value="" selected>Disponibilidade</option>
                                <option value="DISPONIVEL">DISPONIVEL</option>
                                <option value="ALUGADO">ALUGADO</option>
                                      
                            </select>
                        </div>
                        <div class="form-group col ">
                            <button type="submit" class="btn btn-primary">Gerar Relatorio</button>
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