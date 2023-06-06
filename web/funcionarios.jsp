<%-- 
    Document   : cliente
    Created on : 22/05/2023, 17:34:48
    Author     : Tonilson
--%>

<%@page import="br.com.controle.Funcionario"%>
<%@page import="br.com.DAO.ManterFuncionario"%>
<%@page import="java.util.ArrayList"%>


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
    <title>Funcionarios</title>
</head>

<body>
    <div class="d-flex" id="wrapper">

        <!-- Modal Cadastro -->
        <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastrar Funcionario</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="CadastroFuncionario" method="POST">
                        <div class="form-group margin-input">
                            <label for="exampleInputText">Nome</label>
                            <input type="text" class="form-control" name="nome"  placeholder="Insira o nome ">
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                            <label for="exampleInputText">CPF</label>
                            <input type="text" class="form-control" name="cpf" placeholder="888.888.888-88">
                            </div>
                            <div class="form-group margin-input col">
                            <label for="exampleInputText">Telefone</label>
                            <input type="text" class="form-control" name="telefone" placeholder="(61) 98888-8888">
                            </div>
                        </div>
                        <div class="form-group margin-input">
                            <label for="exampleInputText">Endereço</label>
                            <input type="text" class="form-control" name="endereco"  placeholder="Insira o Endereço ">
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                            <label for="exampleInputText">Email</label>
                            <input type="text" class="form-control" name="email" placeholder="Insira o email">
                            </div>
                            <div class="form-group margin-input col">
                            <label for="exampleInputText">Senha</label>
                            <input type="text" class="form-control" name="senha" placeholder="Insira a senha">
                            </div>
                        </div>
                        <div class="form-group margin-input col">
                            <label for="exampleInputText">Cep</label>
                            <input type="text" class="form-control" name="cep" placeholder="88888-888">
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
                <a href="garagem.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-warehouse me-2"></i>Garagem</a>
                <a href="cliente.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-solid fa-user me-2"></i>Clientes</a>
                
                <a href="funcionarios.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold active"><i
                        class="fas fa-solid fa-user-tie me-2"></i>Funcionarios</a>
                <a href="remover.jsp" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold "><i
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
                    <div class="col-md-6">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <% 
                                Funcionario totalFuncionario = new Funcionario();
                                ManterFuncionario daoTotalFuncionario = new ManterFuncionario();

                                totalFuncionario = daoTotalFuncionario.totalFucnioario();

                                String vTotalFuncionario = String.valueOf(totalFuncionario.getCodigo());

                            %>
                                <h3 class="fs-2"><%=vTotalFuncionario%></h3>
                                <p class="fs-5">Funcionarios</p>
                            </div>
                            <i class="fas fa-solid fa-users fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>
                    
                </div>        
                <!-- Final Cards   -->
                
                
                
                <div class="row my-5 ">
                    <div class="row position-relative">
                        <h3 class="fs-4 mb-3 text-dark">Funcionarios</h3>
                        <button type="button" class="btn btn-primary  botao_cadastrar position-absolute top-50 end-0 translate-middle-y " data-bs-toggle="modal" data-bs-target="#exampleModal">Cadastrar</button>
                    </div>
                    <div class="col">
                        <table class="table bg-white rounded shadow-sm  table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">CPF</th>
                                    <th scope="col">Endereco</th>
                                    <th scope="col">Telefone</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Senha</th>
                                    <th scope="col">CEP</th>
                                    
                                    <th scope="col">Apagar</th>
                                    <th scope="col">Editar</th>
                                </tr>
                            </thead>
                            <tbody>
<%
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
                                                                    %>
                                <tr>
                                    <th scope="row"><%=vid%></th>
                                    <td><%=vnome%></td>
                                    <td><%=vcpf%></td>
                                    <td><%=vendereco%></td>
                                    <td><%=vtelefone%></td>
                                    <td><%=vemail%></td>
                                    <td><%=vsenha%></td>
                                    <td><%=vcep%></td>
                                    <td class=""><a href="DeletarFuncionario?id=<%=vid%>" onclick="return confirm('Confirma exclusão do registro <%=vnome%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
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
                                                    <label for="exampleInputText">ID</label>
                                                    <input type="text" class="form-control" name="id" value="<%=vid%>" readonly>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Nome</label>
                                                    <input type="text" class="form-control" name="nome"  value="<%=vnome%>">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">CPF</label>
                                                    <input type="text" class="form-control" name="cpf" value="<%=vcpf%>">
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Telefone</label>
                                                    <input type="text" class="form-control" name="telefone" value="<%=vtelefone%>">
                                                    </div>
                                                </div>
                                                <div class="form-group margin-input">
                                                    <label for="exampleInputText">Endereço</label>
                                                    <input type="text" class="form-control" name="endereco"  value="<%=vendereco%>">
                                                </div>
                                                <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Email</label>
                                                    <input type="text" class="form-control" name="email" value="<%=vemail%>">
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Senha</label>
                                                    <input type="text" class="form-control" name="senha" value="<%=vsenha%>">
                                                    </div>
                                                </div>
                                                <div class="form-group margin-input col">
                                                <label for="exampleInputText">Cep</label>
                                                <input type="text" class="form-control" name="cep" value="<%=vcep%>">
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
                                %>
                                <li class="page-item"><a class="page-link" href="funcionarios.jsp?page=<%=contadorPag%>"><%=contadorPag%></a></li>
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
</body>

</html>