
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>AdminPrincipal</title>
    <link rel="stylesheet" type="text/css" href="admin.css">
</head>
<body>
    <div class="AdminPrincipal">
        <h1>Bienvenido Administrador</h1>
        <p>Selecciona una opción:</p>
        <div class="botones">
            <input type="button" value="Recepcionistas" onclick="RecepcionPrincipal()">
            <input type="button" value="Transportistas" onclick="TransportePrincipal()">
            <input type="button" value="Bibliotecas" onclick="BibliotecasPrincipal()">
            <input type="button" value="Solicitudes de Revocacion" onclick="SolicitudesPrincipal()">
            <input type="button" value="Reportes" onclick="ReportesPrincipal()">
        </div>
    </div>

    <script>
        function RecepcionPrincipal() {       
            window.location.href = "../Principales/RecepcionPrincipal.jsp";
        }
        function TransportePrincipal() {
            window.location.href = "../Principales/TransportePrincipal.jsp";
        }
        function BibliotecasPrincipal() {
            window.location.href = "../Principales/BibliotecasPrincipal.jsp";
        }
        function SolicitudesPrincipal() {
            window.location.href = "../Principales/SolicitudesPrincipal.jsp";
        }
          function ReportesPrincipal() {
            window.location.href = "../Principales/ReportesPrincipal.jsp";
        }
    </script>
</body>
</html>