<%-- 
    Document   : login
    Created on : 24/05/2023, 00:36:34
    Author     : Tonilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/stylesLogin2.css" />
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 
    <title>Login</title>
</head>

<body>
     <%  
        String alertNaoAutorizado = (String) request.getAttribute("loginnaoautorizado");
        String alertNaoEncontrado = (String) request.getAttribute("emailnaoencontrado");
        if(alertNaoAutorizado != null){
    %>
        <script>
                 function alertDial1(){
                     Swal.fire({
                      position: "top-end",
                      text: "Email ou senha invalido!",
                      showConfirmButton: false,
                      timer: 1500
                      });
                }
                 window.onload = function (){
                     alertDial1();
                 } ;
         </script>
    <% } else if(alertNaoEncontrado != null){ %>
        <script>
            function alertDial2(){
                Swal.fire({
                 position: "top-end",
                 text: "Email não encontrado!",
                 showConfirmButton: false,
                 timer: 1500
                 });
           }
            window.onload = function (){
                alertDial2();
            } ;
        </script>
    <% } %>
    <div class="login shadow-lg p-3 container-fluid bg-white rounded-25">
        <div class="sidebar-heading text-center py-4 primary-text fs-2 fw-bold text-uppercase"><i
                    class="fas fa-solid fa-car-side me-2"></i>LOCCAR</div>
        <h1 class="text-center">Login</h1>
        
        <form class="needs-validation" action="Login" method="POST">
            
            <div class="form-group was-validated">
                <label class="form-label" for="email" >Email</label>
                <input class="form-control" type="email" id="email" name="email" required>
                <div class="invalid-feedback">
                    Entre com seu email
                </div>
            </div>
            <div class="form-group was-validated">
                <label class="form-label" for="password">Senha</label>
                <input class="form-control" type="password" id="password" name="senha" required>
                <div class="invalid-feedback">
                    Entre com sua senha
                </div>
            </div>
            
            <input class="btn btn-success w-100 p-1" type="submit" value="ENTRAR">
            <p class="text-center  m-1">Esqueceu senha?<a href="esqueceusenha.jsp" class="text-decoration-none  text-danger"> Clique aqui</a></p>
        </form>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
         function alertDial3(){
            Swal.fire({
             position: "top-end",
             text: "Usuario não logado",
             showConfirmButton: false,
             timer: 1500
             });
        }
        
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        const alert = urlParams.get('alert');
        
        if(alert === '1'){
            window.onload = function (){
                alertDial3();
            } ;
        }
      
    </script>
</body>

</html>