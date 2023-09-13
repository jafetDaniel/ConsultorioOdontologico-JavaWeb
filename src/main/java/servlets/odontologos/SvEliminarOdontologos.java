package servlets.odontologos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvEliminarOdontologos", urlPatterns = {"/SvEliminarOdontologos"})
public class SvEliminarOdontologos extends HttpServlet {
    
      Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id_delete")); //obtener id(campo) del form
       
       control.borrarOdontologo(id); //borrar de la bd
       response.sendRedirect("SvOdontologos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
