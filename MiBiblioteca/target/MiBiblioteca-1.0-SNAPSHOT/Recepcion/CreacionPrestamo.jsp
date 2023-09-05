<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CreacionPrestamo</title>
      <link rel="stylesheet" type="text/css" href="recepcionista.css">
</head>
<body>
    
    <h1>Creación de Prestamos</h1>
    
  <div class="container">
    <form action="CreacionPrestamo.jsp" method="POST">
                <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>biblioteca</th>
                    <th>recepcionista</th>
                    <th>usuario</th>
                    <th>isbn </th>
                    <th>fecha</th>
                    <th>estado</th>
                    <th>multa</th>                                
                </tr>
            </thead>
          
        </table>  
        <tbody>
                <tr>
                        <a href="editarUsuario.jsp?id=1">Editar</a>
                        <a href="inactivarUsuario.jsp?id=1">Inactivar</a>
                        <a href="activarUsuario.jsp?id=1">Activar</a>
                   
                </tr>
            </tbody>
            <label for="id">ID</label>
            <input type="text" id="id" name="id" required><br>
            
            <label for="biblioteca">Biblioteca</label>
            <input type="text" id="biblioteca" name="biblioteca" required><br>
            
            <label for="recepcionista">recepcionista</label>
            <input type="text" id="recepcionista" name="recepcionista" required><br>
            
            <label for="usuario">usuario</label>
            <input type="text" id="usuario" name="usuario" required><br>
            
            <label for="isbn">isbn</label>
            <input type="text" id="isbn" name="isbn" required><br>
            
             <label for="fecha">fecha</label>
            <input type="text" id="fecha" name="fecha" required><br
                
                 <label for="estado">estado</label>
            <input type="text" id="estado" name="estado" required><br
                
                 <label for="multa">multa</label>
            <input type="text" id="multa" name="multa" required><br
        <br>
        <input type="submit" value="Crear Usuario">
        
         <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
    </form>
  </div>
</body>
</html>
