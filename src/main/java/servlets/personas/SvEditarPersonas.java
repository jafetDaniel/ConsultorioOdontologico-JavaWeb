package servlets.personas;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;

@WebServlet(name = "SvEditarPersonas", urlPatterns = {"/SvEditarPersonas"})
public class SvEditarPersonas extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         Persona per = control.traerPersona(id);
         
         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("perEditar", per); //establecer variable en la sesion
         
         response.sendRedirect("views/personas/editarPersona.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//editar 
        
        String dni = request.getParameter("dni");//obteniendo valores del form
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        
        Persona per = (Persona) request.getSession().getAttribute("perEditar");//obteniedo datos anteriores
        
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); //formato de fecha
        Date date = null;
        try {
            date = formato.parse(fecha_nac); //convirtiendo a date
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        per.setDni(dni); //cambiando valores SOLO en la variable de sesion
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        per.setFecha_nac(date);
        
       control.editarPersona(per); //para hacer edicion en la bd
       response.sendRedirect("SvPersonas");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
