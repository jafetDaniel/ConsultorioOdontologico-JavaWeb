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

@WebServlet(name = "SvEditarPacientes", urlPatterns = {"/SvEditarPacientes"})
public class SvEditarPacientes extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         
         Pacientes pac = control.traerPaciente(id);
         
          List<Personas> listaPersonas = new ArrayList();
          listaPersonas = control.getPersonas();
          
          List<Responsables> listaResp = new ArrayList();
          listaResp = control.getResponsables();
          

         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("pacienteEditar", pac); //establecer variable en la sesion
         misesion.setAttribute("selecPersonas", listaPersonas);
         misesion.setAttribute("selecResponsables", listaResp);
         
         response.sendRedirect("views/pacientes/editarPaciente.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//editar 
       
 
        int id_persona  = Integer.parseInt(request.getParameter("id_persona")); //obteniendo valores del form
        int id_responsable  = Integer.parseInt(request.getParameter("id_responsable"));        
        String tiene_sm =  request.getParameter("tiene_sm");
        String tipo_sangre = request.getParameter("tipo_sangre");

        
        Pacientes paciente = (Pacientes) request.getSession().getAttribute("pacienteEditar");//obteniedo datos anteriores
       
            
        if (!tipo_sangre.equals("")){
          
            if (id_persona > 0) {//si se selecciono una persona
                  Personas per = control.traerPersona(id_persona);
                  paciente.setPersona(per);  //cambiando valores SOLO en la variable de sesion
            }
            if (id_responsable > 0) {
                  Responsables resp = control.traerResponsable(id_responsable);
                  paciente.setResponsable(resp);  //cambiando valores SOLO en la variable de sesion
            }
            
            if (!tiene_sm.equals("0") ){//si se selecciono una opcion true or false
                  Boolean sm = Boolean.valueOf(tiene_sm); //convertir string a boolean
                  paciente.setTiene_SM(sm); //cambiando valores SOLO en la variable de sesion
            }
            
            paciente.setTipo_sangre(tipo_sangre); //cambiando valores SOLO en la variable de sesion
            
            control.editarPaciente(paciente); //para hacer edicion en la bd
            response.sendRedirect("SvPacientes");
        }
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
