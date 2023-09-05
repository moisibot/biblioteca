<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Incidencias con Préstamos</title>
      <link rel="stylesheet" type="text/css" href="recepcionista.css">
</head>
<body>
    <h1>Incidencias con Préstamos</h1>
  
    <div class="container">
    <h2>Buscar Préstamo</h2>
    <form action="buscarPrestamo.jsp" method="get">
        <label for="usuarioId">ID de Usuario:</label>
        <input type="text" name="usuarioId" required>
        <input type="submit" value="Buscar">
    </form>
  
    <h2>Préstamo Encontrado</h2>

    
    /* logica para ingresar los prestamos   */
    <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
    </div>
     
</body>
</html>