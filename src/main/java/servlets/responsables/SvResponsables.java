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

@WebServlet(name = "SvResponsables", urlPatterns = {"/SvResponsables"})
public class SvResponsables extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Responsables> listaResponsables = new ArrayList<Responsables>();
        listaResponsables = control.getResponsables();

        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaResponsables", listaResponsables); //establecer variable en la sesion
  
        response.sendRedirect("views/responsables/verResponsable.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int  id_persona  = Integer.parseInt(request.getParameter("id_persona"));
        String tipo_resp = request.getParameter("tipo_resp");
      
        if (tipo_resp != "" && id_persona > 0){
         
        Personas per = control.traerPersona(id_persona);
            
        control.crearResponsable(tipo_resp, per); //creando responsable
        response.sendRedirect("SvResponsables");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
