<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TransportePrincipal</title>
    <link rel="stylesheet" type="text/css" href="admin.css">
</head>
<body>
    <div class="container">
        <h1>transporte!</h1>
        
        <h2>Gestión de usuarios transportista</h2>
        <h2>Listado de transportistas</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Username</th>
                    <th>Correo</th>
                   
                    <th>Password</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> 
                        <a href="editarUsuario.jsp?id=1">Editar</a>
                        <a href="inactivarUsuario.jsp?id=1">Inactivar</a>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <h2>Agregar nuevo usuario</h2>
        <form action="agregarUsuario.jsp" method="post">
               <label for="nombre">ID</label>
            <input type="text" id="id" name="id" required><br>
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br>
            
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            
            <label for="correo">Correo:</label>
            <input type="text" id="correo" name="correo" required><br>
            
            <label for="password">password</label>
            <input type="text" id="password" name="password" required><br>
            
           <input type="submit" value="Agregar usuario">
           <a href="AdminPrincipal.jsp" class="btn-regresar">Regresar</a>
        </form>
    </div>
</body>
</html>