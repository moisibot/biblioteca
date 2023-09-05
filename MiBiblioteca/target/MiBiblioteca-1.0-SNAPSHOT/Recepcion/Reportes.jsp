<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="recepcionista.css">
    <title>Reportes</title>
</head>
<body>
    <div class="MenuRecepcionista">
    <h1>Reportes</h1>
  
    <h2>Top 5 Usuarios con más Incidencias Generadas</h2>
    <%-- Lógica para mostrar el reporte 
    <% if (!usuariosConIncidencias.isEmpty()) { %>
        <ol>
            <% for (Usuario usuario : usuariosConIncidencias) { %>
                <li><%= usuario.getNombre() %> - <%= usuario.getIncidenciasGeneradas() %> incidencias</li>
            <% } %>
        </ol>
    <% } else { %>--%>
        <p>No hay usuarios con incidencias generadas.</p>
    <%-- }-- %>
  
    <h2>Usuarios Suspendidos Actualmente</h2>
    <%-- Lógica para mostrar el reporte --%>
    <%-- if (!usuariosSuspendidos.isEmpty()) { %>
        <ul>
            <% for (Usuario usuario : usuariosSuspendidos) { %>
                <li><%= usuario.getNombre() %></li>
            <% } %>
        </ul>
    <% } else { --%>
        <p>No hay usuarios suspendidos actualmente.</p>
    <%-- } --%>
  
    <h2>Préstamos Realizados en los Últimos 30 Días por Estado</h2>
    <%-- Lógica para mostrar el reporte --%>
    <%-- if (!prestamosUltimos30Dias.isEmpty()) { --%>
        <table>
            <tr>
                <th>Estado</th>
                <th>Cantidad de Préstamos</th>
            </tr>
            <%-- for (Map.Entry<String, Integer> entry : prestamosUltimos30Dias.entrySet()) { %>
                <tr>
                    <td><%= entry.getKey() %></td>
                    <td><%= entry.getValue() %></td>
                </tr>
            <% } --%>
        </table>
    <%-- } else { --%>
        <p>No hay préstamos realizados en los últimos 30 días.</p>
    <%-- } --%>
    
    <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
        </div>
</body>
</html>