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


@WebServlet(name = "SvEditarSecretarios", urlPatterns = {"/SvEditarSecretarios"})
public class SvEditarSecretarios extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         
         Secretarios secre = control.traerSecretario(id);
         
          List<Usuarios> listaUsu = new ArrayList();
          listaUsu = control.getUsuarios();
          
          List<Personas> listaPersonas = new ArrayList();
          listaPersonas = control.getPersonas();

         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("secreEditar", secre); //establecer variable en la sesion
         misesion.setAttribute("selecPersonas", listaPersonas);
         misesion.setAttribute("selecUsuarios", listaUsu);
         
         response.sendRedirect("views/secretarios/editarSecretario.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//editar 
       
        int id_persona  = Integer.parseInt(request.getParameter("id_persona")); //obteniendo valores del form
        int id_usuario  = Integer.parseInt(request.getParameter("id_usuario"));        
        String sector =  request.getParameter("sector");
        
        Secretarios secre = (Secretarios) request.getSession().getAttribute("secreEditar");//obteniedo datos anteriores
            
        if (!sector.equals("")){
          
            if (id_persona > 0) {//si se selecciono una persona
                  Personas per = control.traerPersona(id_persona);
                  secre.setPersona(per);  //cambiando valores SOLO en la variable de sesion
            }
            if (id_usuario > 0) {
                  Usuarios usu = control.traerUsuario(id_usuario);
                  secre.setUsuario(usu);  //cambiando valores SOLO en la variable de sesion
            }

            secre.setSector(sector); //cambiando valores SOLO en la variable de sesion
            
            control.editarSecretario(secre); //para hacer edicion en la bd
            response.sendRedirect("SvSecretarios");
        }
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
