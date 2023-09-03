<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SolicitudesPrincipal</title>
    <link rel="stylesheet" type="text/css" href="admin.css">
</head>
<body>
    <div class="container">
        <h1>solicitud!</h1>
        
        <h2>Solicitudes de revocación de suspensión</h2>
        <h2>Listado de solicitudes</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                   
                    <td>
                        <a href="aceptarSolicitud.jsp?id=1">Aceptar</a>
                        <a href="rechazarSolicitud.jsp?id=1">Rechazar</a>
                    </td>
                </tr>
            </tbody>
      
        </table>
              <a href="AdminPrincipal.jsp" class="btn-regresar">Regresar</a>
    </div>
</body>
</html>