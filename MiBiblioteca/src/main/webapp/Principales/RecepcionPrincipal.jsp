

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>RecepcionPrincipal</title>
    <link rel="stylesheet" type="text/css" href="admin.css">
</head>
<body>
    <h1>recepcionista!</h1>
  
    <div class="container">
        <h2>Gestión de usuarios recepcionistas</h2>
        <h2>Listado de recepcionistas</h2>
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
        <h2>Agregar nuevo usuario</h2>
        <form action="agregarUsuario.jsp" method="post">
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
            
             <label for="estado">Estado</label>
           <select id="estado" name="estado" required>
                <option value="3">activo</option>
                <option value="3">no activo</option>
           </select>
             
            <label for="biblioteca">Biblioteca:</label>
            <select id="biblioteca" name="biblioteca" required>
                <option value="3">Biblioteca 1</option>
                <option value="3">Biblioteca 2</option>
                <option value="3">Biblioteca 3</option>
                <option value="3">Biblioteca 4</option>
                
           
           </select><br>
            <input type="submit" value="Agregar usuario">
            
            <a href="AdminPrincipal.jsp" class="btn-regresar">Regresar</a>
        </form>
    </div>
    
</body>
</html>