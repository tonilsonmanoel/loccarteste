<%-- 
    Document   : garagem
    Created on : 25/05/2023, 17:59:16
    Author     : Tonilson
--%>

<%@page import="br.com.controle.Marca"%>
<%@page import="br.com.DAO.ManterMarca"%>
<%@page import="br.com.controle.Cor"%>
<%@page import="br.com.DAO.ManterCor"%>
<%@page import="br.com.controle.Modelo"%>
<%@page import="br.com.DAO.ManterModelo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.controle.Veiculos"%>
<%@page import="br.com.DAO.ManterVeiculo"%>
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
    <title>Garagem</title>
</head>

<body>
    <div class="d-flex" id="wrapper">

        <!-- Modal Cadastro -->
        <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastrar Veiculo</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="CadastroVeiculo" method="POST">
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Placa</label>
                                <input type="text" class="form-control" name="placa"  placeholder="888-8888 ">
                            </div>
                            <div class="form-group margin-input col">
                            <label for="exampleInputText">Ano</label>
                            <input type="text" class="form-control" name="ano" placeholder="Insira o ano">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Marca</label>
                            <select class="form-select" aria-label="Default select example" name="marca">
                                    <option selected>Selecioner a marca</option>
                            <%  
                                String marcaNome = "";
                                String marcaId = "";
                                
                                ManterMarca marcaDao = new ManterMarca();
                                Marca marca = new Marca();
                                ArrayList<Marca> arryMarca = marcaDao.pesquisaTudoMarca();
                                
                                for(int i = 0; i < arryMarca.size();i++){
                                    marca = arryMarca.get(i);
                                    marcaNome = marca.getNome();
                                    marcaId = String.valueOf(marca.getCodigo());
                                    
                            %>
                                    <option value="<%=marcaId%>"><%=marcaNome%></option>
                                    
                                <% } %>
                            </select>
                            </div>
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Modelo</label>
                                <select class="form-select" aria-label="Default select example" name="modelo">
                                        <option selected>Selecioner o modelo</option>
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
                                        <option value="<%=modeloId%>"><%=modeloNome%></option>

                                    <% } %>
                                      </select>
                            </div>
                        </div>
                        <div class="row">
                           <div class="form-group margin-input col">
                               <label for="exampleInputText">Cor</label>
                            <select class="form-select" aria-label="Default select example" name="cor">
                                    <option selected>Selecioner a cor</option>
                            <%  
                                String corNome = "";
                                String corId ="";
                                
                                ManterCor corDao = new ManterCor();
                                Cor cor = new Cor();
                                ArrayList<Cor> arryCor = corDao.pesquisaTudoCor();
                                
                                for(int i = 0; i < arryCor.size();i++){
                                    cor = arryCor.get(i);
                                    corNome = cor.getNome();
                                    corId = String.valueOf(cor.getCodigo());
                            %>
                                    <option value="<%=corId%>"><%=corNome%></option>
                                    
                                <% } %>
                            </select>
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
         
         
        <!-- Sidebar -->
         <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-solid fa-car-side me-2"></i>LOCCAR</div>
            <div class="list-group list-group-flush my-3">
                <a href="index.jsp" class="list-group-item list-group-item-action bg-transparent second-text "><i
                        class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="locacoes.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-car me-2"></i>Locações</a>
                <a href="garagem.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
                        class="fas fa-solid fa-warehouse me-2"></i>Garagem</a>
                <a href="cliente.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user me-2"></i>Clientes</a>
                <a href="funcionarios.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user-tie me-2"></i>Funcionarios</a>
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
               

                <div class="row my-5 ">
                    <div class="row position-relative">
                        <h3 class="fs-4 mb-3 text-dark">Garagem</h3>
                        <button type="button" class="btn btn-primary  botao_cadastrar position-absolute top-50 end-0 translate-middle-y " data-bs-toggle="modal" data-bs-target="#exampleModal">Cadastrar</button>
                    </div>
                    <div class="col">
                        <table class="table bg-white rounded shadow-sm  table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th scope="col">Placa</th>
                                    <th scope="col">Ano</th>
                                    <th scope="col">Disponibilidade</th>
                                    <th scope="col">Modelo</th>
                                    <th scope="col">Marca</th>
                                    <th scope="col">Cor</th>
                                    <th scope="col" width="50">Apagar</th>
                                    <th scope="col" width="50">Editar</th>
                                </tr>
                            </thead>
                            <tbody>
<%
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
                                                                    %>
                                <tr>
                                    <th scope="row"><%=vid%></th>
                                    <td><%=vplaca%></td>
                                    <td><%=vano%></td>
                                    <td><%=vdisponibilidade%></td>
                                    <td><%=vmodelo%></td>
                                    <td><%=vmarca%></td>
                                    <td><%=vcor%></td>
                                    <td class=""><a href="DeletarFuncionario?id=<%=vid%>" onclick="return confirm('Confirma exclusão do registro <%=vmodelo_id%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
                                    <td><a href="#"data-bs-toggle="modal" data-bs-target="#modalEditar<%=vid%>"><i class="fas fa-solid fa-pen me-2 d-flex justify-content-center"></i></a></td>
                                </tr>
                                
                                <!-- Modal Editar -->
                                <div class="modal fade " id="modalEditar<%=vid%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog ">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Funcionario</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form  action="EditarFuncionario" method="POST">
                                                 <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Codigo</label>
                                                    <input type="text" class="form-control" name="id" value="<%=vid%>" readonly>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Ano</label>
                                                    <input type="text" class="form-control" name="nome"  value="<%=vano%>">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                     <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Placa</label>
                                                    <input type="text" class="form-control" name="placa"  value="<%=vplaca%>">
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Disponibilidade</label>
                                                    <select class="form-select" aria-label="Default select example" name="status">
                                                            <option value="<%=vdisponibilidade%>" selected><%=vdisponibilidade%></option>
                                                            <%  if(vdisponibilidade.equals("ALUGADO")){  %>
                                                            <option value="DISPONIVEL">DISPONIVEL</option>
                                                            <% } else{  %>
                                                            <option value="ALUGADO">ALUGADO</option>
                                                            <% }  %>
                                                        </select>
                                                    </div>
                                                    
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                        <label for="exampleInputText">Marca</label>
                                                    <select class="form-select" aria-label="Default select example" name="marca">
                                                        <option selected value="<%=vmarca%>"><%=vmarca%></option>
                                                    <%  
                                                        String marcaNome2 = "";
                                                        String marcaId2 = "";

                                                        ManterMarca marcaDao2 = new ManterMarca();
                                                        Marca marca2 = new Marca();
                                                        ArrayList<Marca> arryMarca2 = marcaDao2.pesquisaTudoMarca();

                                                        for(int i2 = 0; i2 < arryMarca2.size();i2++){
                                                            marca2 = arryMarca2.get(i2);
                                                            marcaNome2 = marca2.getNome();
                                                            marcaId2 = String.valueOf(marca2.getCodigo());

                                                    %>
                                                            <option value="<%=marcaId2%>"><%=marcaNome2%></option>

                                                        <% } %>
                                                    </select>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                        <label for="exampleInputText">Modelo</label>
                                                        <select class="form-select" aria-label="Default select example" name="modelo">
                                                            <option selected value="<%=vmodelo%>"><%=vmodelo%></option>
                                                        <%  
                                                            String modeloNome2 = "";
                                                            String modeloId2 = "";

                                                            ManterModelo modelodao2 = new ManterModelo();
                                                            Modelo modelo2 = new Modelo();
                                                            ArrayList<Modelo> arryModelo2 = modelodao2.pesquisaTudoModelo();

                                                            for(int a2 = 0; a2 < arryModelo.size();a2++){
                                                                modelo2 = arryModelo2.get(a2);
                                                                modeloNome2 = modelo2.getNome();
                                                                modeloId2 = String.valueOf(modelo2.getId());
                                                        %>
                                                                <option value="<%=modeloId2%>"><%=modeloNome2%></option>

                                                            <% } %>
                                                              </select>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                   <div class="form-group margin-input col">
                                                       <label for="exampleInputText">Cor</label>
                                                    <select class="form-select" aria-label="Default select example" name="cor">
                                                        <option selected value="<%=vcor%>"><%=vcor%></option>
                                                    <%  
                                                        String corNome2 = "";
                                                        String corId2 ="";

                                                        ManterCor corDao2 = new ManterCor();
                                                        Cor cor2 = new Cor();
                                                        ArrayList<Cor> arryCor2 = corDao2.pesquisaTudoCor();

                                                        for(int i3 = 0; i3 < arryCor.size();i3++){
                                                            cor2 = arryCor.get(i3);
                                                            corNome2 = cor2.getNome();
                                                            corId2 = String.valueOf(cor2.getCodigo());
                                                    %>
                                                            <option value="<%=corId2%>"><%=corNome2%></option>

                                                        <% } %>
                                                    </select>
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
