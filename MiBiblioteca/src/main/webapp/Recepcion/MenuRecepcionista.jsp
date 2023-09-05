

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html>
<head>
    <title>MenuRecepcionista</title>
    <link rel="stylesheet" type="text/css" href="recepcionista.css">
</head>
<body>
    <div class="MenuRecepcionista">
        <h1>Bienvenido Recepcionista</h1>
        <p>Selecciona una opción:</p>
        <div class="botones">
            <input type="button" value="Creación de nuevos usuarios" onclick="CreacionUsuarios()">
            <input type="button" value="Creación de préstamo de libro" onclick="CreacionPrestamo()">
            <input type="button" value="Finalización de solicitud de préstamo de libro" onclick="FinalizacionPrestamo()">
            <input type="button" value="Incidencias con préstamos" onclick="IncidenciasPrestamos()">
            <input type="button" value="Creación de solicitud de transporte de unidades" onclick="CreacionTransporte()">
            <input type="button" value="Solicitudes de transporte" onclick="SolicitudTransporte()">
            <input type="button" value="Reportes" onclick="Reportes()">
        </div>
    </div>

    <script>
        function CreacionUsuarios() {       
            window.location.href = "../Recepcion/CreacionUsuarios.jsp";
        }
        function CreacionPrestamo() {
            window.location.href = "../Recepcion/CreacionPrestamo.jsp";
        }
        function FinalizacionPrestamo() {
            window.location.href = "../Recepcion/FinalizacionPrestamo.jsp";
        }
        function IncidenciasPrestamos() {
            window.location.href = "../Recepcion/IncidenciasPrestamos.jsp";
        }
          function CreacionTransporte() {
            window.location.href = "../Recepcion/CreacionTransporte.jsp";
        }
         function SolicitudTransporte() {
            window.location.href = "../Recepcion/SolicitudTransporte.jsp";
        }
         function Reportes() {
            window.location.href = "../Recepcion/Reportes.jsp";
        }
    </script>
</body>
</html>
