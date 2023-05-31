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
    <link rel="stylesheet" href="css/stylesLogin.css" />
    <title>Login</title>
</head>

<body>
    <div class="login shadow-lg p-3 mb-5 bg-white rounded-25">
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
            
            <input class="btn btn-success w-100" type="submit" value="ENTRAR">
        </form>

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