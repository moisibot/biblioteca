<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BibliotecasPrincipal</title>
    <link rel="stylesheet" type="text/css" href="admin.css">
</head>
<body>  
    <div class="container">
    <h1>bibliotecas!</h1>
  
    <p>Selecciona una opción:</p>
    

        <h2>Gestión de listado de libros</h2>
       <table>
            <thead>
                <tr>
                    <th>ISBN</th> 
                    <th></th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Unidades disponibles</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
               <tr>
                   
                    <td>
                        <a href="editarLibro.jsp?id=1">Editar</a>
                        <a href="ajustarUnidades.jsp?id=1">Ajustar unidades</a>
                    </td>
                </tr>
            </tbody>
        </table>

        <h2>Agregar nuevo libro</h2>     
        <form action="svBibliotecasPrincipal" method="POST">
            
              <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" required><br>
            
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required><br>
            
            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" required><br>
            
            <input type="submit" value="Agregar libro">
        </form>

        <h2>Ajustar unidades de un libro</h2>
        <form action="ajustarUnidades.jsp" method="post">
            <label for="libro">Seleccione un libro:</label>
            <select id="libro" name="libro" required>
               <option value="1">isebene</option>
           </select>
              <br>
              <br>
               <label for="libro">Seleccione una biblioteca: </label>
               <select id="biblioteca" name="biblioteca" required>
               <option value="1">Biblioteca 1</option>
               <option value="1">Biblioteca 2</option>
               <option value="1">Biblioteca 3</option>
               <option value="1">Biblioteca 4</option>
               
           </select>
            <br>
            <label for="unidades">Unidades:</label>
            <input type="number" id="unidades" name="unidades" required><br>
            
            <label for="motivo">Motivo del ajuste:</label>
            <input type="text" id="motivo" name="motivo" required><br>
            <input type="submit" value="Realizar ajuste">
            
        </form>
        <a href="AdminPrincipal.jsp" class="btn-regresar">Regresar</a>
    </div>
    
    <script>
        
    </script>
</body>
</html>