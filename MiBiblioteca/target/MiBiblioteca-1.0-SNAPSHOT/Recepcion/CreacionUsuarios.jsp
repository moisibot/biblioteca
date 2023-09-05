
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CreacionUsuarios</title>
      <link rel="stylesheet" type="text/css" href="recepcionista.css">
</head>
<body>
    
    <h1>Creación de Usuarios</h1>
    
  <div class="container">
    <form action="CreacionUsuarios.jsp" method="POST">
                <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>username</th>
                    <th>password</th>
                    <th>correo</th>
                    <th>Biblioteca</th>
                    <th>Estado</th>
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
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br>
            
            <label for="username">UserName</label>
            <input type="text" id="username" name="username" required><br>
            
            <label for="password">Password</label>
            <input type="text" id="password" name="password" required><br>
            
            <label for="correo">Correo</label>
            <input type="text" id="correo" name="correo" required><br>
            
            <label for="saldoinicial">saldo incial</label>
            <input type="text" id="saldoinicial" name="saldoinicial" required><br>
        <br>
        <input type="submit" value="Crear Usuario">
        
         <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
    </form>
  </div>
</body>
</html>
