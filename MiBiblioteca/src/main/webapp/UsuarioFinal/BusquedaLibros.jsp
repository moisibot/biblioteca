<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="usuario.css">
    <title>Búsqueda de Información de Libros</title>
</head>
<body>
    <h1>Búsqueda de Información de Libros</h1>
  <div class="container">
       <form action="buscarLibros.jsp" method="get">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">
        <br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor">
        <br>
        <label for="categoria">Categoría:</label>
        <input type="text" id="categoria" name="categoria">
        <br>
        
        <label for="biblioteca">Biblioteca:</label>
        <select id="biblioteca" name="biblioteca">
            <option value="">Todas las bibliotecas</option>
            <option value="Biblioteca 1">Biblioteca 1</option>
            <option value="Biblioteca 2">Biblioteca 2</option>
            <option value="Biblioteca 3">Biblioteca 3</option>
        </select>
        <br>
        <input type="submit" value="Buscar">
    </form>
  
    <%-- logica para la busqueda 
    <% if (!libros.isEmpty()) { %>
        <h2>Resultados de la Búsqueda</h2>
        <ul>
            <% for (Libro libro : libros) { %>
                <li>
                    <h3><%= libro.getNombre() %></h3>
                    <p>Autor: <%= libro.getAutor() %></p>
                    <p>Categoría: <%= libro.getCategoria() %></p>
                    <p>ISBN: <%= libro.getISBN() %></p>
                    <p>Unidades disponibles:</p>--%>
                    <ul>
                        <%-- for (Biblioteca biblioteca : libro.getUnidadesDisponibles()) { %>
                            <li><%= biblioteca.getNombre() %>: <%= biblioteca.getUnidadesDisponibles() %> unidades</li>
                        <% } --%>
                    </ul>
                    <form action="iniciarSolicitud.jsp" method="post">
                        <input type="hidden" name="idLibro" value="<%--= libro.getId() --%>">
           
                        <a href="CrearSolicitud.jsp" class="btn-regresar">Iniciar Solicitud</a>
                    </form>
                </li>
            <%-- } %>
        </ul>
    <% } else { %>
        <p>No se encontraron resultados.</p>
    <% } --%>
<a href="MenuUsuario.jsp" class="btn-regresar">Regresar</a>
</div>
</body>
</html>