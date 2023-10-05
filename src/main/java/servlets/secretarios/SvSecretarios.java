package servlets.secretarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuarios;
import logica.Personas;
import logica.Secretarios;

@WebServlet(name = "SvSecretarios", urlPatterns = {"/SvSecretarios"})
public class SvSecretarios extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Secretarios> listaSecre = new ArrayList();
        listaSecre = control.getSecretarios();

        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaSecre", listaSecre); //establecer variable en la sesion
  
        response.sendRedirect("views/secretarios/verSecretario.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int  id_usuario  = Integer.parseInt(request.getParameter("id_usuario"));
        int  id_persona  = Integer.parseInt(request.getParameter("id_persona")); 
        
        
        String sector = request.getParameter("sector");
      
        if ((!sector.equals("")) && id_persona > 0 && id_usuario > 0){
         
        Usuarios usu = control.traerUsuario(id_usuario);
        Personas per = control.traerPersona(id_persona);
            
        control.crearSecretario(sector, usu, per); //creando secre
        response.sendRedirect("SvSecretarios");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
