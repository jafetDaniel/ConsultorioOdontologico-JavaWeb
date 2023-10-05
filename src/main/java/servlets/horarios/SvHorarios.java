package servlets.horarios;

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

@WebServlet(name = "SvHorarios", urlPatterns = {"/SvHorarios"})
public class SvHorarios extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Horarios> listaHorarios = new ArrayList();
        listaHorarios = control.getHorarios();
        
        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaHorarios", listaHorarios); //establecer variable en la sesion
        
        response.sendRedirect("views/horarios/verHorario.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String horario_inicio = request.getParameter("horario_inicio");
        String  horario_fin = request.getParameter("horario_fin");
       
        if ( horario_inicio != "" &&  horario_fin != ""){
            
        control.crearHorario(horario_inicio, horario_fin); //creando usuario
        response.sendRedirect("SvHorarios");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
