<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="usuario.css">
    <title>Reportes</title>
</head>
<body>
    <h1>Reportes</h1>
  <div class="container">
    <h2>Historial de movimientos en el saldo</h2>
  
    <form method="get" action="reporteMovimientos.jsp">
        <label for="tipoMovimientoSelect">Filtrar por:</label>
        <select id="tipoMovimientoSelect" name="tipoMovimiento">
            <option value="ingresos">Ingresos</option>
            <option value="debitos">Débitos</option>
        </select>
        <input type="submit" value="Generar reporte">
    </form>
    <a href="MenuUsuario.jsp" class="btn-regresar">Regresar</a>
  </div>
</body>
</html>