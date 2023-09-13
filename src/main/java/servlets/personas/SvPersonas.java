package servlets.personas;

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
import logica.Personas;

@WebServlet(name = "SvPersonas", urlPatterns = {"/SvPersonas"})
public class SvPersonas extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { //mostrar lista de personas
        
        List<Personas> listaPersonas = new ArrayList<Personas>();
        listaPersonas = control.getPersonas();
        
        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaPersonas", listaPersonas); //establecer variable en la sesion
        
        response.sendRedirect("views/personas/verPersona.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        
        if (dni != "" && nombre !="" && apellido !="" && telefono != "" && direccion != "" && fecha_nac != ""){
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //formato actual (y de BD)
            Date date = null;
        try {
            date = formato.parse(fecha_nac); //convirtiendo a date
 
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            control.crearPersona(dni, nombre, apellido, telefono, direccion, date); //creando persona
            response.sendRedirect("SvPersonas"); //redirigir al servlet
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
