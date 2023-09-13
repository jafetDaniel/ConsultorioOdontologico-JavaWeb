package servlets.turnos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Odontologos;
import logica.Pacientes;
import logica.Turnos;

@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          List<Turnos> listaTurnos = new ArrayList<Turnos>();
        listaTurnos = control.getTurnos();
        
        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaTurnos", listaTurnos); //establecer variable en la sesion
        
        response.sendRedirect("views/turnos/verTurno.jsp"); //redirigir
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fecha_turno = request.getParameter("fecha_turno");
        String hora_turno = request.getParameter("hora_turno");
        String tratamiento = request.getParameter("tratamiento");
        int id_odonto = Integer.parseInt(request.getParameter("id_odonto"));
        int id_pacient = Integer.parseInt(request.getParameter("id_pacient"));
       
        if (fecha_turno != "" && hora_turno != "" && tratamiento != ""  && id_odonto >0 && id_pacient >0){
            
             Odontologos odonto = control.traerOdontologo(id_odonto);
             Pacientes pacient = control.traerPaciente(id_pacient);
              
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //formato actual (y de BD)
            Date date = null;
        try {
            date = formato.parse(fecha_turno); //convirtiendo a date
 
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        control.crearTurno( date, hora_turno, tratamiento, odonto, pacient); //creando usuario
        response.sendRedirect("SvTurnos");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
