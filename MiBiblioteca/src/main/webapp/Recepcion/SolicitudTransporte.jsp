<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="recepcionista.css">
    <title>Solicitudes de Transporte</title>
</head>
<body>
    <div class="MenuRecepcionista">
    <h1>Solicitudes de Transporte</h1>
  
    <%-- Lógica para mostrar todas las solicitudes de transporte --%>
    <%-- if (!solicitudesTransporte.isEmpty()) { --%>
        <h2>Lista de Solicitudes</h2>
        <ul>
            <%-- for (SolicitudTransporte solicitud : solicitudesTransporte) { --%>
                <li>
                    <a href="detalleSolicitud.jsp?id=<%--= solicitud.getId() --%>">
                        Solicitud <%--= solicitud.getId() --%>
                    </a>
                </li>
            <%-- } --%>
        </ul>
    <%-- } else { --%>
        <p>No hay solicitudes de transporte disponibles.</p>
    <%-- } --%>
    <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
    </div>
</body>
</html>