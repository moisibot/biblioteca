<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="usuario.css">
    <title>Préstamos activos</title>
</head>
<body>
    <h1>Préstamos activos</h1>
  <div class="container">
    <%-- if (!prestamosActivos.isEmpty()) { --%>
        <table>
            <tr>
                <th>Libro</th>
                <th>Días restantes</th>
                <th>Fecha de entrega límite</th>
                <th>Acciones</th>
            </tr>
            <%-- for (Prestamo prestamo : prestamosActivos) { --%>
                <tr>
                    <td><%--= prestamo.getLibro().getTitulo() --%></td>
                    <td><%--= prestamo.getDiasRestantes() --%></td>
                    <td><%--= prestamo.getFechaEntregaLimite() --%></td>
                    <td>
                        <h3>Detalles del Préstamo</h3>
                        <p>Libro: <%--= prestamo.getLibro().getTitulo() --%></p>
                        <p>Días Restantes: <%--= prestamo.getDiasRestantes() --%></p>
                        <p>Fecha de Entrega Límite: <%--= prestamo.getFechaEntregaLimite() --%></p>
                        <p>Estado: <%--= prestamo.getEstado() --%></p>
                        <%-- if (prestamo.isRetrasoEntrega()) { %>
                            <p style="color: red;">¡La entrega del libro está atrasada!</p>
                            <p>Debes pagar una multa.</p>
                        <%--} --%>
                        <%-- if (prestamo.getEstado().equals("Activo")) { --%>
                            <h4>Opciones:</h4>
                            <ul>
                                <li>
                                    <a href="reportarIncidencia.jsp?id=<%--= prestamo.getId() --%>">Reportar Daño o Extravío</a>
                                </li>
                            </ul>
                        <%-- } --%>
                    </td>
                </tr>
            <%-- } --%>
        </table>
    <%-- } else { --%>
        <p>No tienes préstamos activos actualmente.</p>
    <%-- } --%>
   <a href="MenuUsuario.jsp" class="btn-regresar">Regresar</a>
   
   
  </div>
</body>
</html>