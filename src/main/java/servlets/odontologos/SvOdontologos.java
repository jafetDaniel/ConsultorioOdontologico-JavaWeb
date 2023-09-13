package servlets.odontologos;

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
import logica.Horarios;
import logica.Odontologos;
import logica.Personas;
import logica.Usuarios;

@WebServlet(name = "SvOdontologos", urlPatterns = {"/SvOdontologos"})
public class SvOdontologos extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Odontologos> listaOdonto = new ArrayList<Odontologos>();
        listaOdonto = control.getOdontologos();

        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaOdonto", listaOdonto); //establecer variable en la sesion
  
        response.sendRedirect("views/odontologos/verOdontologo.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int  id_usuario  = Integer.parseInt(request.getParameter("id_usuario"));
        int  id_persona  = Integer.parseInt(request.getParameter("id_persona"));
        int  id_horario  = Integer.parseInt(request.getParameter("id_horario"));
        String especialidad = request.getParameter("especialidad");
      
        if (especialidad != "" && id_persona > 0 && id_usuario > 0){
         
        Usuarios usu = control.traerUsuario(id_usuario);
        Personas per = control.traerPersona(id_persona);
        Horarios hora = control.traerHorario(id_horario);
            
        control.crearOdontologo(especialidad,usu,hora,per); //creando responsable
        response.sendRedirect("SvOdontologos");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
