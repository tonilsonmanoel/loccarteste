<%-- 
    Document   : garagem
    Created on : 25/05/2023, 17:59:16
    Author     : Tonilson
--%>

<%@page import="br.com.controle.Funcionario"%>
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
    <link rel="stylesheet" href="css/styles4.css" />
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
    <title>Garagem</title>
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
                <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastrar Veiculo</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="CadastroVeiculo" method="POST">
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Placa</label>
                                <input type="text" class="form-control placa" name="placa"  placeholder="888-8888 " required>
                            </div>
                            <div class="form-group margin-input col">
                            <label for="exampleInputText">Ano</label>
                            <input type="text" class="form-control" name="ano" placeholder="Insira o ano" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group margin-input col">
                                <label for="exampleInputText">Modelo Veiculo</label>
                                <select class="form-select" aria-label="Default select example" name="modelo" required>
                                    <option value="">Selecioner o modelo do veiculo</option>
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
                        </div>
                        <div class="row">
                           <div class="form-group margin-input col">
                               <label for="exampleInputText">Cor</label>
                            <select class="form-select" aria-label="Default select example" name="cor" required>
                                <option value="">Selecioner a cor</option>
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
         
        
       
         <!-- Modal Marcas -->
         
         <div class="modal fade" id="ModalMarca">
            <div class="modal-dialog modal-lg modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="DSLabel">Marcas</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal">
                        </button>
                    </div>
                    <div class="modal-body ">
                       <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" width="50">#</th>
                                            <th scope="col">Nome</th>
                                            <th scope="col" width="50">Apagar</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
            <%
                        String vidMarca = "";
                        String vnomeMarca = "";

                        ManterMarca daoMarca =new ManterMarca();
                        Marca marcaobj = new Marca();


                        ArrayList<Marca> nt23 = daoMarca.pesquisaTudoMarca();

                    for(int i3 = 0; i3 < nt23.size(); i3++){
                        marcaobj = nt23.get(i3);
                        vidMarca = String.valueOf(marcaobj.getCodigo());
                        vnomeMarca = String.valueOf(marcaobj.getNome());
                                                                            %>
                                        <tr>
                                            <th scope="row"><%=vidMarca%></th>
                                            <td><%=vnomeMarca%></td>
                                            <td class=""><a href="DeletarMarca?id=<%=vidMarca%>" onclick="return confirm('Confirma exclusão do registro <%=vnomeMarca%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
                                        </tr>
                                <%  }   %>

                                    </tbody>
                                </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                        <button class="btn btn-primary"data-bs-target="#ModalCadastrarMarca" data-bs-toggle="modal" data-bs-dismiss="modal">
                            Cadastrar
                        </button>
                         <button class="btn btn-primary"data-bs-target="#ModalEditarMarca" data-bs-toggle="modal" data-bs-dismiss="modal">
                            Editar
                        </button>
                    </div>
                </div>
            </div>
        </div>
                                
        <!-- Modal Cadastro Marcas -->                        
        <div class="modal fade" id="ModalCadastrarMarca" 
             aria-hidden="true" aria-labelledby="DSLabel2" 
             tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="AlgoLabel">Cadastrar Marca</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <div class="modal-body p-5">
                        <form  action="CadastroMarca" method="POST">
                        <div class="form-group margin-input">
                            <label for="exampleInputText">Nome</label>
                            <input type="text" class="form-control" name="nome"  placeholder="Insira o nome" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" data-bs-target="#ModalMarca"data-bs-toggle="modal" data-bs-dismiss="modal">Voltar</button>
                         <button type="submit" class="btn btn-primary">Cadastrar</button></form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim Modal Marca Cadastro -->
        
        <!-- Modal Editar Marcas -->                        
        <div class="modal fade" id="ModalEditarMarca" 
             aria-hidden="true" aria-labelledby="DSLabel2" 
             tabindex="-1">
            <div class="modal-dialog ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="AlgoLabel">Editar Marca</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <div class="modal-body p-5">
                        <form  action="EditarMarca" method="POST">
                        <div class="form-group margin-input">
                             <label for="exampleInputText">Marca</label>
                              <select class="form-select" aria-label="Default select example" name="idmarca" required>
                                  <option value="">Selecione a marca </option>
                                                    <%  
                                                        String marcaNome3 = "";
                                                        String marcaId3 = "";

                                                        ManterMarca marcaDao3 = new ManterMarca();
                                                        Marca marca3= new Marca();
                                                        ArrayList<Marca> arryMarca3 = marcaDao3.pesquisaTudoMarca();

                                                        for(int i3 = 0; i3 < arryMarca3.size();i3++){
                                                            marca3 = arryMarca3.get(i3);
                                                            marcaNome3 = marca3.getNome();
                                                            marcaId3 = String.valueOf(marca3.getCodigo());

                                                    %>
                                     <option value="<%=marcaId3%>"><%=marcaNome3%></option>

                                      <% } %>
                                       </select>
                        </div>   
                        <div class="form-group margin-input">
                            <label for="exampleInputText">Nome</label>
                            <input type="text" class="form-control" name="nome"  placeholder="Insira o nome" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" data-bs-target="#ModalMarca"data-bs-toggle="modal" data-bs-dismiss="modal">Voltar</button>
                         <button type="submit" class="btn btn-primary">Editar</button></form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim editar Marcas -->
         <!-- Fim Modal Marcas -->
         
         
         <!-- Modal Modelo -->
         
         <div class="modal fade" id="ModalModelo">
            <div class="modal-dialog modal-lg modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="DSLabel">Modelo</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal">
                        </button>
                    </div>
                    <div class="modal-body ">
                       <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" width="50">#</th>
                                            <th scope="col">Nome</th>
                                            <th scope="col">Marca</th>
                                            <th scope="col" width="50">Apagar</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
            <%
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
                        
                                                                            %>
                                        <tr>
                                            <th scope="row"><%=vidModelo%></th>
                                            <td><%=vnomeModelo%></td>
                                            <td><%=vnomeMarcaM%></td>
                                            <td class=""><a href="DeletarModelo?id=<%=vidModelo%>" onclick="return confirm('Confirma exclusão do registro <%=vnomeModelo%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
                                        </tr>
                                <%  }   %>

                                    </tbody>
                                </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                        <button class="btn btn-primary"data-bs-target="#ModalCadastrarModelo" data-bs-toggle="modal" data-bs-dismiss="modal">
                            Cadastrar
                        </button>
                         <button class="btn btn-primary"data-bs-target="#ModalEditarModelo" data-bs-toggle="modal" data-bs-dismiss="modal">
                            Editar
                        </button>
                    </div>
                </div>
            </div>
        </div>
                                
        <!-- Modal Cadastro Modelo -->                        
        <div class="modal fade" id="ModalCadastrarModelo" 
             aria-hidden="true" aria-labelledby="DSLabel2" 
             tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="AlgoLabel">Cadastrar Modelo</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <div class="modal-body p-5">
                        <form  action="CadastroModelo" method="POST">
                            <div class="form-group margin-input">
                                <label for="exampleInputText">Nome</label>
                                <input type="text" class="form-control" name="nome"  placeholder="Insira o nome" required>
                            </div>
                            <div class="form-group margin-input">
                             <label for="exampleInputText">Marca</label>
                              <select class="form-select" aria-label="Default select example" name="idmarca" required>
                                  <option value="">Selecione a marca </option>
                                                    <%  
                                                        String marcaNomeModelo = "";
                                                        String marcaIdModelo = "";

                                                        ManterMarca marcaDaoModelo = new ManterMarca();
                                                        Marca marcaModeloCadastro = new Marca();
                                                        
                                                        ArrayList<Marca> arryMarcaModelo = marcaDaoModelo.pesquisaTudoMarca();

                                                        for(int a = 0; a < arryMarcaModelo.size();a++){
                                                            marcaModeloCadastro = arryMarcaModelo.get(a);
                                                            marcaNomeModelo = marcaModeloCadastro.getNome();
                                                            marcaIdModelo = String.valueOf(marcaModeloCadastro.getCodigo());

                                                    %>
                                     <option value="<%=marcaIdModelo%>"><%=marcaNomeModelo%></option>

                                      <% } %>
                                       </select>
                                </div>   
                            
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" data-bs-target="#ModalModelo"data-bs-toggle="modal" data-bs-dismiss="modal">Voltar</button>
                         <button type="submit" class="btn btn-primary">Cadastrar</button></form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim Modal Modelo Cadastro -->
        
        <!-- Modal Editar Modelo -->                        
        <div class="modal fade" id="ModalEditarModelo" 
             aria-hidden="true" aria-labelledby="DSLabel2" 
             tabindex="-1">
            <div class="modal-dialog ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="AlgoLabel">Editar Modelo</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <div class="modal-body p-5">
                        <form  action="EditarModelo" method="POST">
                            <div class="form-group margin-input">
                                  <label for="exampleInputText">Modelo o modelo para editar</label>
                                  <select class="form-select" aria-label="Default select example" name="idModelo" required>
                                      <option value="">Selecione o modelo </option>
                                                        <%  
                                                            String nomeModeloEditar= "";
                                                            String idModeloEditar = "";
                                                            
                                                            ManterModelo modeloDaoEditar = new ManterModelo();
                                                            Modelo modeloEditar  = new Modelo();
                                                            ArrayList<Modelo> arryModeloEditar = modeloDaoEditar.pesquisaTudoModelo();

                                                            for(int i3 = 0; i3 < arryModeloEditar.size();i3++){
                                                                modeloEditar = arryModeloEditar.get(i3);
                                                                nomeModeloEditar = modeloEditar.getNome();
                                                                idModeloEditar = String.valueOf(modeloEditar.getId());

                                                        %>
                                         <option value="<%=idModeloEditar%>"><%=nomeModeloEditar%></option>

                                          <% } %>
                                           </select>
                            </div>
                                 
                            <div class="form-group margin-input">
                                <label for="exampleInputText">Nome</label>
                                <input type="text" class="form-control" name="nome"  placeholder="Insira o nome" required>
                            </div>               
                                           
                            <div class="form-group margin-input">
                                  <label for="exampleInputText">Marca</label>
                                  <select class="form-select" aria-label="Default select example" name="idmarca"required>
                                      <option value="">Selecione a marca </option>
                                                        <%  
                                                            String marcaNomeModelo2 = "";
                                                            String marcaIdModelo2 = "";

                                                            Marca marcaModelo2= new Marca();
                                                            ArrayList<Marca> arryMarcaModelo3 = marcaDaoModelo.pesquisaTudoMarca();

                                                            for(int i3 = 0; i3 < arryMarcaModelo3.size();i3++){
                                                                marcaModelo2 = arryMarcaModelo3.get(i3);
                                                                marcaNomeModelo2 = marcaModelo2.getNome();
                                                                marcaIdModelo2 = String.valueOf(marcaModelo2.getCodigo());

                                                        %>
                                         <option value="<%=marcaIdModelo2%>"><%=marcaNomeModelo2%></option>

                                          <% } %>
                                           </select>
                            </div>   
                            
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" data-bs-target="#ModalModelo"data-bs-toggle="modal" data-bs-dismiss="modal">Voltar</button>
                         <button type="submit" class="btn btn-primary">Editar</button></form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim editar Modelo -->
         <!-- Fim Modal Modelo -->
         
         
         <!-- Modal Cores -->
         
         <div class="modal fade" id="ModalCores">
            <div class="modal-dialog modal-lg modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="DSLabel">Cor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal">
                        </button>
                    </div>
                    <div class="modal-body ">
                       <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" width="50">#</th>
                                            <th scope="col">Nome</th>
                                            <th scope="col" width="50">Apagar</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
            <%
                        String vidCor = "";
                        String vnomeCor = "";
                        
                        ManterCor daoCor = new ManterCor();
                        Cor corobj = new Cor();

                        ArrayList<Cor> ntCor = daoCor.pesquisaTudoCor();

                    for(int iCor = 0; iCor < ntCor.size(); iCor++){
                        corobj = ntCor.get(iCor);
                        vidCor = String.valueOf(corobj.getCodigo());
                        vnomeCor = String.valueOf(corobj.getNome());
                        
                        
                                                                            %>
                                        <tr>
                                            <th scope="row"><%=vidCor%></th>
                                            <td><%=vnomeCor%></td>
                                            <td class=""><a href="DeletaCor?id=<%=vidCor%>" onclick="return confirm('Confirma exclusão do registro <%=vnomeCor%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
                                        </tr>
                                <%  }   %>

                                    </tbody>
                                </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                        <button class="btn btn-primary"data-bs-target="#ModalCadastrarCor" data-bs-toggle="modal" data-bs-dismiss="modal">
                            Cadastrar
                        </button>
                         <button class="btn btn-primary"data-bs-target="#ModalEditarCor" data-bs-toggle="modal" data-bs-dismiss="modal">
                            Editar
                        </button>
                    </div>
                </div>
            </div>
        </div>
                                
        <!-- Modal Cadastro Cores -->                        
        <div class="modal fade" id="ModalCadastrarCor" 
             aria-hidden="true" aria-labelledby="DSLabel2" 
             tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="AlgoLabel">Cadastrar Cor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <div class="modal-body p-5">
                        <form  action="CadastroCor" method="POST">
                            <div class="form-group margin-input">
                                <label for="exampleInputText">Nome</label>
                                <input type="text" class="form-control" name="nome"  placeholder="Insira o nome" required>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" data-bs-target="#ModalCores"data-bs-toggle="modal" data-bs-dismiss="modal">Voltar</button>
                         <button type="submit" class="btn btn-primary">Cadastrar</button></form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim Modal Cores Cadastro -->
        
        <!-- Modal Editar Cores -->                        
        <div class="modal fade" id="ModalEditarCor" 
             aria-hidden="true" aria-labelledby="DSLabel2" 
             tabindex="-1">
            <div class="modal-dialog ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="AlgoLabel">Editar Cor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    
                    <div class="modal-body p-5">
                        <form  action="EditarCor" method="POST">
                            <div class="form-group margin-input">
                                  <label for="exampleInputText">Cor para editar</label>
                                  <select class="form-select" aria-label="Default select example" name="idCor" required>
                                      <option value="">Selecione a Cor </option>
                                                        <%  
                                                            String nomeCorEditar= "";
                                                            String idCorEditar = "";
                                                            
                                                            Cor corEditar  = new Cor();
                                                            ArrayList<Cor> arryCorEditar = daoCor.pesquisaTudoCor();

                                                            for(int i3 = 0; i3 < arryCorEditar.size();i3++){
                                                                corEditar = arryCorEditar.get(i3);
                                                                nomeCorEditar = corEditar.getNome();
                                                                idCorEditar = String.valueOf(corEditar.getCodigo());

                                                        %>
                                         <option value="<%=idCorEditar%>"><%=nomeCorEditar%></option>

                                          <% } %>
                                           </select>
                            </div>
                            <div class="form-group margin-input">
                                <label for="exampleInputText">Nome</label>
                                <input type="text" class="form-control" name="nome"  placeholder="Insira o nome" required>
                            </div>    
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" data-bs-target="#ModalCores"data-bs-toggle="modal" data-bs-dismiss="modal">Voltar</button>
                         <button type="submit" class="btn btn-primary">Editar</button></form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim editar Cores -->
         <!-- Fim Modal Cores -->
         
         
         
         
        <!-- Sidebar -->
         <div class="bg-white" id="sidebar-wrapper">
             <div class="sidebar-heading text-center primary-text fs-4 fw-bold text-uppercase border-bottom">
                <img src="image/logoLocCar.jpg" height="100" width="200" class="img-fluid" >
            </div>
            <div class="list-group list-group-flush my-1">
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
                                Veiculos totalVeiculo = new Veiculos();
                                ManterVeiculo daoTotalVeiculo = new ManterVeiculo();

                                totalVeiculo = daoTotalVeiculo.totalVeiculos();

                                String vtotalVei = String.valueOf(totalVeiculo.getId());

                            %>
                                <h3 class="fs-2"><%=vtotalVei%></h3>
                                <p class="fs-5">Veiculos</p>
                            </div>
                            <i class="fas fa-solid fa-car fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                            <% 
                            Marca totalMarca = new Marca();
                            ManterMarca daoTotalMarca = new ManterMarca();
                            
                            totalMarca = daoTotalMarca.totalMarca();
                            
                            String vtotalMarca = String.valueOf(totalMarca.getCodigo());

                            %>
                                <h3 class="fs-2"><%=vtotalMarca%></h3>
                                <p class="fs-5">Marcas</p>
                            </div>
                            <i
                                class="fas fa-duotone fa-car-side fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                        <div class="row justify-content-center">
                        <button type="button" class="btn btn-primary  botao_cadastrar my-1" data-bs-toggle="modal" data-bs-target="#ModalMarca">Exibir</button>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                  <% 
                            Modelo totalModelo = new Modelo();
                            ManterModelo daoTotalModelo = new ManterModelo();
                            
                            totalModelo = daoTotalModelo.totalModelo();
                            String vtotalModelo = String.valueOf(totalModelo.getId());

                            %>
                                <h3 class="fs-2"><%=vtotalModelo%></h3>
                                <p class="fs-5">Modelos</p>
                            </div>
                            <i class="fas fa-solid fa-car-side fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                        <div class="row justify-content-center">
                        <button type="button" class="btn btn-primary  botao_cadastrar my-1" data-bs-toggle="modal" data-bs-target="#ModalModelo">Exibir</button>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                 <% 
                            Cor totalCor = new Cor();
                            ManterCor daoTotalCor = new ManterCor();
                            
                            totalCor = daoTotalCor.totalCor();
                            String vtotalCor = String.valueOf(totalCor.getCodigo());

                        %>
                                <h3 class="fs-2"><%=vtotalCor%></h3>
                                <p class="fs-5">Cores</p>
                            </div>
                            <i class="fas fa-solid fa-palette fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                        <div class="row justify-content-center">
                        <button type="button" class="btn btn-primary  botao_cadastrar my-1" data-bs-toggle="modal" data-bs-target="#ModalCores">Exibir</button>
                        </div>        
                    </div>
                </div>        
                <!-- Final Cards   -->
                
                <!-- Iniciar tabela -->
                <div class="row my-5 ">
                    <div class="row position-relative">
                        <h3 class="fs-4 mb-3 text-primary">Garagem</h3>
                        <button type="button" class="btn btn-primary  botao_cadastrar position-absolute top-50 end-0 translate-middle-y " data-bs-toggle="modal" data-bs-target="#exampleModal">Cadastrar</button>
                    </div>
                    <div class="table-responsive">
                        <table class="table bg-white rounded shadow-sm  table-hover table-striped">
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
            
            // Parametro para paginação
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
            //Parametro para paginação
            
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
                                                                    %>
                                <tr>
                                    <th scope="row"><%=vid%></th>
                                    <td><%=vplaca%></td>
                                    <td><%=vano%></td>
                                    <td><%=vdisponibilidade%></td>
                                    <td><%=vmodelo%></td>
                                    <td><%=vmarca%></td>
                                    <td><%=vcor%></td>
                                    <td class=""><a href="DeletarVeiculo?id=<%=vid%>" onclick="return confirm('Confirma exclusão do registro <%=vmodelo%>?')"><i class="fas fa-solid fa-trash me-2 d-flex justify-content-center " style="color: #ff0000;"></i></a></td>
                                    <td><a href="#"data-bs-toggle="modal" data-bs-target="#modalEditar<%=vid%>"><i class="fas fa-solid fa-pen me-2 d-flex justify-content-center"></i></a></td>
                                </tr>
                                
                                <!-- Modal Editar -->
                                <div class="modal fade " id="modalEditar<%=vid%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog ">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Veiculo</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form  action="EditarVeiculo" method="POST">
                                                 <div class="row">
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Codigo</label>
                                                    <input type="text" class="form-control" name="id" value="<%=vid%>" readonly>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Ano</label>
                                                    <input type="text" class="form-control" name="ano"  value="<%=vano%>" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                     <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Placa</label>
                                                    <input type="text" class="form-control" name="placa"  value="<%=vplaca%>" required>
                                                    </div>
                                                    <div class="form-group margin-input col">
                                                    <label for="exampleInputText">Disponibilidade</label>
                                                    <select class="form-select" aria-label="Default select example" name="disponibilidade" required>
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
                                                        <label for="exampleInputText">Modelo</label>
                                                        <select class="form-select" aria-label="Default select example" name="modelo" required>
                                                            <option selected value="<%=vmodelo_id%>">Modelo: <%=vmodelo%> | Marca: <%=vmarca%> </option>
                                                       <%  
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
                                                            %>
                                                                    <option value="<%=modeloIdEditar%>">Modelo: <%=modeloNomeEditar%> | Marca: <%=marcasNomeEditar%></option>

                                                                <% } %>
                                                              </select>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                   <div class="form-group margin-input col">
                                                       <label for="exampleInputText">Cor</label>
                                                    <select class="form-select" aria-label="Default select example" name="cor" required>
                                                        <option selected value="<%=vcores_id%>"><%=vcor%></option>
                                                    <%  
                                                        String corNome2 = "";
                                                        String corId2 ="";

                                                        ManterCor corDao2 = new ManterCor();
                                                        Cor cor2 = new Cor();
                                                        ArrayList<Cor> arryCor2 = corDao2.pesquisaTudoCor();

                                                        for(int i3 = 0; i3 < arryCor2.size();i3++){
                                                            cor2 = arryCor2.get(i3);
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
                    <nav aria-label="Page navigation example position-absolute top-50 start-50 translate-middle">
                            <ul class="pagination">
                                <%   
                                    
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
                                %>
                                <li class="page-item"><a class="page-link" href="garagem.jsp?page=<%=contadorPag%>"><%=contadorPag%></a></li>
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
        $('.placa').mask('AAA-AAAA');
        $('.phone').mask('0000-0000');
        $('.phone_with_ddd').mask('(00) 0000-0000');
        $('.mixed').mask('AAA 000-S0S');
        $('.cpf').mask('000.000.000-00', {reverse: true});
        $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
    </script>
    <!--   -->
</body>

</html>
