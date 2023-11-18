
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="css/stylesLogin2.css" />
    <title>Redefinir Senha</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body class="position-relative">
     <%  
       
        String alertNaoAutorizado = (String) request.getAttribute("naoautorizado");
        if(alertNaoAutorizado != null){
    %>
   <script>
              function alertDial(){
                Swal.fire({
                 position: "top-end",
                 text: "Codigo ou email invalido!",
                 showConfirmButton: false,
                 timer: 1500
                 });
           }
            window.onload = function (){
                alertDial();
            } ;
    </script>
    <% } %>
    
    <div class="login shadow-lg p-3 mb-5 bg-white rounded-25 position-absolute top-50 start-50 translate-middle">
         <div class="sidebar-heading text-center primary-text fs-2 fw-bold text-uppercase">
            <img src="image/logoLocCar.jpg" height="100" width="200" class="img-fluid" >
       </div>
        <div class="sidebar-heading text-center py-1 primary-text fs-2 fw-bold text-uppercase">
            <img src="image/redefinirsenha.png" height="100" width="400" class="img-fluid" >
       </div>
        
        <form class="needs-validation" action="RedefinirSenha" method="POST">
             <div class="form-group was-validated">
                <label class="form-label" for="email" >Email</label>
                <input class="form-control" type="email" id="email" name="email" required>
                <div class="invalid-feedback">
                    Entre com seu email
                </div>
            </div>
            <div class="form-group was-validated">
                <label class="form-label" for="text" >Codigo verificador</label>
                <input class="form-control" type="text" id="email" name="codigo" required>
                <div class="invalid-feedback">
                    Entre com seu codigo verificador
                </div>
            </div>
            <div class="form-group was-validated">
                <label class="form-label" for="password">Nova Senha</label>
                <input class="form-control" type="password" id="password" name="senha" required>
                <div class="invalid-feedback">
                    Digite uma nova senha 
                </div>
            </div>
          
            <input class="btn btn-primary w-100" type="submit" value="Continuar">
        </form>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
  
</body>

</html>