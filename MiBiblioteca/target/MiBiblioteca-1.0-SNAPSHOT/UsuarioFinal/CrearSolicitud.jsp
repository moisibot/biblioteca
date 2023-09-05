<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
     <link rel="stylesheet" type="text/css" href="usuario.css">
    <title>Creación de Solicitud de Préstamo</title>
</head>
<body>
    <h1>Creación de Solicitud de Préstamo</h1>
  <div class="container">
    <%-- Formulario de búsqueda de libro --%>
    <h2>Búsqueda de Libro</h2>
    <form action="buscarLibro.jsp" method="get">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo">
        <br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor">
        <br>
         <label for="isbn">ISBN</label>
        <input type="text" id="isbn" name="isbn">
         <br>
        <input type="submit" value="Buscar Libro">
    </form>
  
    <%-- Resultados de la búsqueda de libro 
    <% if (libroEncontrado != null) { %>--%>
        <h2>Libro Encontrado</h2>
        <p>Título: <%--= libroEncontrado.getTitulo() --%></p>
        <p>Autor: <%--= libroEncontrado.getAutor() --%></p>
      
        <%-- aca se crea el prestamo  --%>
        <h2>Crear Solicitud de Préstamo</h2>
        <form action="crearSolicitud.jsp" method="post">
            <input type="hidden" name="libroId" value="<%--= libroEncontrado.getId() --%>">
          
            <label for="biblioteca">Biblioteca:</label>
            <select id="biblioteca" name="biblioteca">
                <option value="">Seleccione una biblioteca</option>
                <%-- for (Biblioteca biblioteca : bibliotecasDisponibles) { --%>
                    <option value="<%--= biblioteca.getId() %>"><%= biblioteca.getNombre() --%> "</option>
                <%-- } --%>
            </select>
            
            <br>
            <label for="diasPrestamo">Días de préstamo:</label>
            <input type="number" id="diasPrestamo" name="diasPrestamo">
            <br>
            <label for="opcionesEntrega">Opciones de entrega:</label>
            <select id="opcionesEntrega" name="opcionesEntrega">
                <option value="recoger">Recoger en tienda</option>
                <option value="entrega">Entrega a domicilio</option>
            </select>
            <br>
            <input type="submit" value="Crear Solicitud">
        </form>
    <%-- } --%>
  <a href="MenuUsuario.jsp" class="btn-regresar">Regresar</a>
    
  </div>
</body>
</html>