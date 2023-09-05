<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Creación de Solicitud de Transporte</title>
    <link rel="stylesheet" type="text/css" href="recepcionista.css">
</head>
<body>
    <h1>Creación de Solicitud de Transporte</h1>
     <div class="container">
    <table>
            <tr>
                <th>ID</th>
                <th>Recepcionista</th>
                <th>Transportista</th>
                <th>fecha</th>
                <th>Estado</th>
                <th>Detalle</th>
                <th>ISBN</th>
                <th>Unidades</th>
            </tr>
    </table>
  
              <label for="id">ID:</label>
                <input type="text" id="id" name="id" required>
                
                 <label for="recepcionista">Recepcionista:</label>
                <input type="text" id="recepcionista" name="recepcionista" required>
                
                   <label for="transportista">Transportista:</label>
                   <input type="text" id="transportista" name="transportista" required>
                   
                                <label for="fecha">Fecha:</label>
                <input type="text" id="fecha" name="fecha" required>
                
                <label for="estado">Estado:</label>
                <input type="text" id="estado" name="estado" required>
                
                     <label for="isbn">ISBN:</label>
                <input type="text" id="isbn" name="isbn" required>
                
                
                <label for="existencia">Detalle-Existencia:</label>
                <input type="text" id="existencia" name="existencia" required>
                   
    <h2>Seleccionar Biblioteca Destino</h2>
    <form action="solicitarTransporte.jsp" method="post">
        
        <label for="bibliotecaDestino">Biblioteca Destino:</label>
        <select name="bibliotecaDestino" required>
            <option value="biblioteca1">Biblioteca 1</option>
            <option value="biblioteca2">Biblioteca 2</option>
            <option value="biblioteca3">Biblioteca 3</option>

        </select>
        <input type="submit" value="Seleccionar">
    </form>
  
    <%-- Lógica para mostrar el formulario de búsqueda de libros y selección de unidades --%>
   <%-- <% if (bibliotecaDestinoSeleccionada != null) { %> --%>
        <h2>Buscar Libros</h2>
        <form action="buscarLibros.jsp" method="get">
            <label for="filtro">Filtrar por:</label>
            <select name="filtro">
                <option value="nombre">Nombre</option>
                <option value="autor">Autor</option>
                <option value="categoria">Categoría</option>
                <option value="isbn">ISBN</option>
            </select>
            <label for="valorFiltro">Valor:</label>
            <input type="text" name="valorFiltro" required>
            <input type="submit" value="Buscar">
        </form>
      
        <%-- Lógica para mostrar los resultados de la búsqueda y permitir la selección de unidades 
        <% if (librosEncontrados != null && !librosEncontrados.isEmpty()) { %>
            <h2>Libros Encontrados</h2>
            <form action="agregarLibros.jsp" method="post">
                <input type="hidden" name="bibliotecaDestino" value="<%= bibliotecaDestinoSeleccionada %>">
                <% for (Libro libro : librosEncontrados) { %>
                    <h3><%= libro.getTitulo() %></h3>
                    <p>Autor: <%= libro.getAutor() %></p>
                    <p>Categoría: <%= libro.getCategoria() %></p>
                    <p>ISBN: <%= libro.getISBN() %></p>
                    <label for="<%= libro.getId() %>">Unidades:</label>
                    <input type="number" name="<%= libro.getId() %>" min="1" max="<%= libro.getUnidadesDisponibles() %>" required>
                <% } %>
                <input type="submit" value="Agregar Libros">
            </form>
        <% } else { %>
            <p>No se encontraron libros con los criterios de búsqueda proporcionados.</p>
        <% } %>
    <% } %>
  --%>
   <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
   </div>
</body>
</html>