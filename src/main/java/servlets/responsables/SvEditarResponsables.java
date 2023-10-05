package servlets.responsables;

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
import logica.Personas;
import logica.Responsables;

@WebServlet(name = "SvEditarResponsables", urlPatterns = {"/SvEditarResponsables"})
public class SvEditarResponsables extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         
         Responsables resp = control.traerResponsable(id);
         
          List<Personas> listaPersonas = new ArrayList();
          listaPersonas = control.getPersonas();
         
         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("respEditar", resp); //establecer variable en la sesion
         misesion.setAttribute("selecPersonas", listaPersonas);
         
         response.sendRedirect("views/responsables/editarResponsable.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//editar 
        
        String tipo_resp = request.getParameter("tipo_resp");//obteniendo valores del form
        int id_persona  = Integer.parseInt(request.getParameter("id_persona"));

        
        Responsables resp = (Responsables) request.getSession().getAttribute("respEditar");//obteniedo datos anteriores
       
            
        if (!tipo_resp.equals("")) {
            
            if (id_persona  > 0) {
                  Personas per = control.traerPersona(id_persona);
                  resp.setPersona(per);  //cambiando valores SOLO en la variable de sesion
            }
            
            resp.setTipo_resp(tipo_resp); //cambiando valores SOLO en la variable de sesion
            
            control.editarResponsable(resp); //para hacer edicion en la bd
            response.sendRedirect("SvResponsables");
        }
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
