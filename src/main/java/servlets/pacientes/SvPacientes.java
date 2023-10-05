package servlets.pacientes;

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
import logica.Pacientes;
import logica.Personas;
import logica.Responsables;

@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Pacientes> listaPacient = new ArrayList();
        listaPacient = control.getPacientes();

        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaPacient", listaPacient); //establecer variable en la sesion
  
        response.sendRedirect("views/pacientes/verPaciente.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int  id_responsable  = Integer.parseInt(request.getParameter("id_responsable"));
        int  id_persona  = Integer.parseInt(request.getParameter("id_persona")); 
        
        boolean tiene_sm = false;
        if (request.getParameter("tiene_sm") != null) {//si no se marco el check
            if (request.getParameter("tiene_sm").equals("true")) {//si se marco el check(devuelve value=true)
                 tiene_sm = true;
            }
        }
        
        String tipo_sangre = request.getParameter("tipo_sangre");
      
        if ((!tipo_sangre.equals("")) && id_persona > 0 && id_responsable > 0){
         
        Responsables resp = control.traerResponsable(id_responsable);
        Personas per = control.traerPersona(id_persona);
            
        control.crearPaciente(tiene_sm, tipo_sangre, resp, per); //creando responsable
        response.sendRedirect("SvPacientes");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
