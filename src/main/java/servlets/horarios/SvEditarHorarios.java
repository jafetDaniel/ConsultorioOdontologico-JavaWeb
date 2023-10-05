package servlets.horarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horarios;

@WebServlet(name = "SvEditarHorarios", urlPatterns = {"/SvEditarHorarios"})
public class SvEditarHorarios extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         
         Horarios hora = control.traerHorario(id); //obtener datos de la bd
         
         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("horaEditar", hora); //establecer variable en la sesion
         
         response.sendRedirect("views/horarios/editarHorario.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
        String horario_inicio = request.getParameter("horario_inicio"); //obteniendo valores del form
        String horario_fin = request.getParameter("horario_fin"); 
        
        Horarios hora = (Horarios) request.getSession().getAttribute("horaEditar"); //obteniedo datos anteriores
        
        if ( (!horario_inicio.equals("")) && (!horario_fin.equals(""))){
            
        hora.setHorario_inicio(horario_inicio); //cambiando valores de la variable de sesion
        hora.setHorario_fin(horario_fin);
        
       control.editarHorario(hora); //para hacer edicion en la bd
       response.sendRedirect("SvHorarios");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
