<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="transporte.css">
    <title>MenuTransportista</title>
   
</head>
<body>
    <div class="MenuTransportista">
        <h1>Bienvenido Transportista</h1>
        <div class="botones">
        
        <p>Selecciona una opción:</p>
       
            <input type="button" value="Transporte a Bibliotecas" onclick="TransporteBibliotecas()">
            <input type="button" value="Transporte a Usuarios" onclick="TransporteUsuario()">
          </div>
      </div>
     
    <script>
        function TransporteBibliotecas() {       
            window.location.href = "../Transporte/TransporteBibliotecas.jsp";
        }
        function TransporteUsuario() {
            window.location.href = "../Transporte/TransporteUsuario.jsp";
        }
     
        
    </script>
       
    
    
  

</body>
</html>
