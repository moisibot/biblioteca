
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="usuario.css">
        <title>MenuUsuario</title>
    </head>
    
    <body>
      <div class = "MenuUsuario">   
            <h1>Bienvenido usuario</h1>
     
            
                 <div class="botones">
                     
            <input type="button" value="Buscar Libros" onclick="BusquedaLibros()">       
            <input type="button" value="Crear Solicitud de Revocacion" onclick="CrearRevocacion()">
            <input type="button" value="Crear solicitud de Prestamo" onclick="CrearSolicitud()">
            <input type="button" value="Entrar a perfil" onclick="PerfilSuscripcion()">
            <input type="button" value="Revisar Prestamos" onclick="PrestamosActivos()">
            <input type="button" value="Reportes" onclick="Reportes()">
        </div>
    </div>

    <script>
        function BusquedaLibros() {       
            window.location.href = "../UsuarioFinal/BusquedaLibros.jsp";
        }
        function CrearRevocacion() {
            window.location.href = "../UsuarioFinal/CrearRevocacion.jsp";
        }
                function CrearSolicitud() {
            window.location.href = "../UsuarioFinal/CrearSolicitud.jsp";
        }
                function PerfilSuscripcion() {
            window.location.href = "../UsuarioFinal/PerfilSuscripcion.jsp";
        }
                function PrestamosActivos() {
            window.location.href = "../UsuarioFinal/PrestamosActivos.jsp";
        }
             function Reportes() {
            window.location.href = "../UsuarioFinal/Reportes.jsp";
             }
           </script>
    </body>
</html>
