package servlets.personas;

import servlets.usuarios.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;

@WebServlet(name = "SvPersonas", urlPatterns = {"/SvPersonas"})
public class SvPersonas extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { //mostrar lista de personas
        
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas = control.getPersonas();
        
        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaPersonas", listaPersonas); //establecer variable en la sesion
        
        response.sendRedirect("views/personas/verPersona.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = null;
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        
        if (dni != "" && nombre !="" && apellido !="" && telefono != "" && direccion != "" &&
            fecha_nac != ""){
            
            control.crearPersona(dni, nombre, apellido, telefono, direccion, fecha_nac); //creando persona
            response.sendRedirect("SvPersonas"); //redirigir al servlet
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
