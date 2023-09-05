<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="usuario.css">
    <title>Perfil de Usuario</title>
</head>
<body>
    <h1>Perfil de Usuario</h1>
  <div class="container">
      <%-- Mostrar información del usuario --%>
    <h2>Información del Usuario</h2>
    <p>Nombre: <%--= usuario.getNombre() --%></p>
    <p>Email: <%--= usuario.getEmail() --%></p>
    <p>Saldo: <%--= usuario.getSaldo() --%></p>
  
    <%-- Opción para convertirse en usuario premium --%>
    <h2>Opción Premium</h2>
    <%-- if (!usuario.isPremium()) { --%>
        <p>¡Conviértete en un usuario Premium y disfruta de las siguientes ventajas:</p>
        <ul>
            <li>Ventaja 1</li>
            <li>Ventaja 2</li>
            <li>Ventaja 3</li>
        </ul>
        <form action="iniciarSuscripcion.jsp" method="post">
            <input type="submit" value="Iniciar Suscripción">
        </form>
    <%-- } else { --%>
        <p>Eres un usuario Premium. Disfruta de todas las ventajas.</p>
    <%-- } --%>
  
  
    <h2>Recarga de Saldo</h2>
    <form action="realizarRecarga.jsp" method="post">
        <label for="monto">Monto:</label>
        <input type="number" id="monto" name="monto">
        <input type="submit" value="Recargar Saldo">
    </form>
   <a href="MenuUsuario.jsp" class="btn-regresar">Regresar</a>
  </div>
</body>
</html>