<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="transporte.css">
    <title>Transporte entre Bibliotecas</title>
</head>
<body>
    <div class="container">
    <h1>Transporte entre Bibliotecas</h1>
  
    <%-- Lógica para mostrar la información del transporte --%>
    <%-- if (transporte != null) { %>
        <h2>Transporte <%= transporte.getId() %></h2>
        <p>Estado: <%= transporte.getEstado() %></p>
        <p>Biblioteca Origen: <%= transporte.getBibliotecaOrigen() %></p>
        <p>Biblioteca Destino: <%= transporte.getBibliotecaDestino() %></p>
      
        <%-- Lógica para permitir marcar el transporte como "En camino" o "Finalizado" --%>
        <%-- if (transporte.getEstado().equals("Pendiente")) { --%>
            <form action="marcarEnCamino.jsp" method="post">
                <input type="hidden" name="idTransporte" value="<%--= transporte.getId() --%>">
                <input type="submit" value="Marcar En Camino">
            </form>
        <%-- } else if (transporte.getEstado().equals("En camino")) { --%>
            <form action="marcarFinalizado.jsp" method="post">
                <input type="hidden" name="idTransporte" value="<%--= transporte.getId() --%>">
                <input type="submit" value="Marcar Finalizado">
            </form>
        <%-- } --%>
    <%-- } else { --%>
        <p>No se encontró el transporte especificado.</p>
<a href="MenuTransportista.jsp" class="btn-regresar">Regresar</a>
<%-- } --%>
  </div>
</body>
</html>