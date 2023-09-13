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

@WebServlet(name = "SvEditarTurnos", urlPatterns = {"/SvEditarTurnos"})
public class SvEditarTurnos extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         
         Turnos turno = control.traerTurno(id);
         
           List<Odontologos> listaOdontologos = new ArrayList<Odontologos>();
           listaOdontologos = control.getOdontologos();
           
           List<Pacientes> listaPacientes = new ArrayList<Pacientes>();
           listaPacientes = control.getPacientes();
           
         
         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("turnoEditar", turno); //establecer variable en la sesion
         misesion.setAttribute("selecOdontologos", listaOdontologos);
         misesion.setAttribute("selecPacientes", listaPacientes);
         
         response.sendRedirect("views/turnos/editarTurno.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//editar 
        
        String fecha_turno = request.getParameter("fecha_truno");//obteniendo valores del form
        String hora_turno = request.getParameter("hora_turno");
        String tratamiento = request.getParameter("tratamiento");
        int id_odonto = Integer.parseInt(request.getParameter("id_odonto"));
        int id_pacient = Integer.parseInt(request.getParameter("id_pacient"));

        
        Turnos turno = (Turnos) request.getSession().getAttribute("turnoEditar");//obteniedo datos anteriores
        Date date = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //formato actual (y de BD)


            if (fecha_turno.equals("")) { //si no se cambio el campo fecha
                
                date = turno.getFecha_turno(); //obtener y asignar la anterior
            } else {
                try {
                    date = formato.parse(fecha_turno); //convirtiendo a date y asignando la nueva facha
                } catch (ParseException ex) {
                    Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        if (hora_turno != "" && tratamiento != ""  && date != null) {
            
             if (id_odonto  > 0) {
                  Odontologos odonto = control.traerOdontologo(id_odonto);
                  turno.setOdonto(odonto);  //cambiando valores SOLO en la variable de sesion
            }
            if (id_pacient  > 0) {
                  Pacientes pacient = control.traerPaciente(id_pacient);
                  turno.setPacient(pacient);  //cambiando valores SOLO en la variable de sesion
            }
            
            turno.setHora_turno(hora_turno); //cambiando valores SOLO en la variable de sesion
            turno.setTratamiento(tratamiento);
            turno.setFecha_turno(date);

            control.editarTurno(turno); //para hacer edicion en la bd
            response.sendRedirect("SvTurnos");
        }
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
