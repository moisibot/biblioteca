
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
@WebServlet(name = "svBibliotecasPrincipal", urlPatterns = {"../svBibliotecasPrincipal"})
public class svBibliotecasPrincipal extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        boolean datosValidos = validarDatos(isbn, titulo, autor);
        if (!datosValidos) {
            response.sendRedirect("error.jsp");
            return;
        }
        System.out.println(isbn);
         System.out.println(titulo);
          System.out.println(autor);
       

          
    }

    private boolean validarDatos(String isbn, String titulo, String autor) {
        // Implementar la lógica de validación de los datos ingresados
        // Por ejemplo, verificar que los campos no estén vacíos, cumplan ciertos criterios, etc.
        // Devolver true si los datos son válidos, false si no lo son
        // ...
        return true;
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
