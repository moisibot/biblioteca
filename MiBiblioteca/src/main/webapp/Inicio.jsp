

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <div class="Inicio">
        <h1>Bienvenido</h1>
        <p>Inicia Sesión</p>
        <form action="Validar" method="POST" onsubmit="return validarCredenciales()">
            <label for="username">Usuario</label>
            <input type="text" id="txtUsuario" name="txtUsuario" placeholder="Nombre Registro" required>
            <label for="password">Contraseña</label>
            <input type="password" id="contra" name="contra" placeholder="Tu contraseña" required>
            <input type="submit" name="btnIngresar" value="Ingresar">
        </form>
    </div>

    <script>
        function validarCredenciales() {
            window.location.href = "../Principales/AdminPrincipal.jsp";
            return false;
        }
    </script>
</body>
</html>