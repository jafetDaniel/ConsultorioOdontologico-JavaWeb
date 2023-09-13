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

@WebServlet(name = "SvEditarOdontologos", urlPatterns = {"/SvEditarOdontologos"})
public class SvEditarOdontologos extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         
         Odontologos resp = control.traerOdontologo(id);
         
          List<Personas> listaPersonas = new ArrayList<Personas>();
          listaPersonas = control.getPersonas();
          List<Usuarios> listaUsu = new ArrayList<Usuarios>();
          listaUsu = control.getUsuarios();
          List<Horarios> listaHora = new ArrayList<Horarios>();
          listaHora = control.getHorarios();
         
         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("odontoEditar", resp); //establecer variable en la sesion
         misesion.setAttribute("selecPersonas", listaPersonas);
         misesion.setAttribute("selecUsu", listaUsu);
         misesion.setAttribute("selecHora", listaHora);
         
         response.sendRedirect("views/odontologos/editarOdontologo.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//editar 
       
        int  id_usuario  = Integer.parseInt(request.getParameter("id_usuario")); //obteniendo valores del form
        int  id_persona  = Integer.parseInt(request.getParameter("id_persona"));
        int  id_horario  = Integer.parseInt(request.getParameter("id_horario"));
        String especialidad = request.getParameter("especialidad");

        
        Odontologos odonto = (Odontologos) request.getSession().getAttribute("odontoEditar");//obteniedo datos anteriores
       
            
        if (especialidad != "") {
            
             if (id_usuario > 0) {
                  Usuarios usu = control.traerUsuario(id_usuario);
                  odonto.setUsuario(usu);  //cambiando valores SOLO en la variable de sesion
            }           
            if (id_persona > 0) {
                  Personas per = control.traerPersona(id_persona);
                  odonto.setPersona(per);  //cambiando valores SOLO en la variable de sesion
            }
            if (id_horario > 0) {
                  Horarios hora = control.traerHorario(id_horario);
                  odonto.setHorario(hora);  //cambiando valores SOLO en la variable de sesion
            }
            
            odonto.setEspecialidad(especialidad); //cambiando valores SOLO en la variable de sesion
            
            control.editarOdontologo(odonto); //para hacer edicion en la bd
            response.sendRedirect("SvOdontologos");
        }
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
