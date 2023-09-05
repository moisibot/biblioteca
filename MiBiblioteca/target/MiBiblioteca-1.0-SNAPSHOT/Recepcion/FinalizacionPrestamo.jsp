

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FinalizarPrestamo</title>
      <link rel="stylesheet" type="text/css" href="recepcionista.css">
</head>
<body>
    
    <h1>FinalizarPrestamo</h1>
    
  <div class="container1">
    <form action="FinalizarPrestamo.jsp" method="POST">
        <table class="Finalizar">
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
                    <th>tipoEntrega</th>
                    <th>transportista</th> 
                </tr>
            </thead>
          
        </table>  
        <tbody>
                <tr>
                        <a href="editarUsuario.jsp?id=1">finalizar</a>
                        <a href="inactivarUsuario.jsp?id=1">rechazar</a>
                  
                   
                </tr>
            </tbody>
          
        <br>

        
         <a href="MenuRecepcionista.jsp" class="btn-regresar">Regresar</a>
    </form>
  </div>
</body>
</html>