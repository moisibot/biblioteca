
package Controlador.svPrincipal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moisibot
 */
@WebServlet(name = "svInicio", urlPatterns = {"/svInicio"})
public class svInicio extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        
        System.out.println(username);
        System.out.println(password);
  
        
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out=response.getWriter()){
        out.println(username);
        out.println(password);
        
        }
       response.sendRedirect("../Inicio.jsp");
        
       
       
       boolean credencialesValidas = validarCredenciales(username, password);

        if (credencialesValidas) {
            // Redirigir a la página de destino después del inicio de sesión exitoso
            response.sendRedirect("AdminPrincipal.jsp");
        } else {
            // Lógica para manejar el inicio de sesión fallido
            // Puedes mostrar un mensaje de error o redirigir de nuevo a la página de inicio de sesión
            response.sendRedirect("login.jsp?error=1"); // Agregando un parámetro para indicar un error
        }
    }

    // Método para validar las credenciales (sustituye esto con tu lógica de validación real)
    private boolean validarCredenciales(String username, String password) {
        // Aquí debes realizar la validación de las credenciales, por ejemplo, consultando una base de datos
        // Si las credenciales son válidas, devuelve true; de lo contrario, devuelve false
        // Reemplaza este método con tu lógica de validación real
        return username.equals("usuarioEjemplo") && password.equals("contraseñaEjemplo");
    
    }

}
