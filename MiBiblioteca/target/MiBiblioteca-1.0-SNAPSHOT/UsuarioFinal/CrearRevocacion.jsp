<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="usuario.css">
    <title>Solicitud de revocación de suspensión</title>
</head>
<body>
    <h1>Solicitud de revocación de suspensión</h1>
<div class="container">
    <form method="post" action="procesarSolicitud.jsp">
        <label for="solicitudTextArea">Motivo de la solicitud:</label><br>
        <textarea id="solicitudTextArea" name="solicitud" rows="4" cols="50" required></textarea><br>

        <input type="submit" value="Enviar solicitud">
    </form>
       <a href="MenuUsuario.jsp" class="btn-regresar">Regresar</a>
    
    
       
       
       
</div>
</body>
</html>