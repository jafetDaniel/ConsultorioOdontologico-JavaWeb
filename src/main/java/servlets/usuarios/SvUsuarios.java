package servlets.usuarios;

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

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
        listaUsuarios = control.getUsuarios();
        
        HttpSession miSesion = request.getSession(); //llamando a la sesion
        miSesion.setAttribute("listaUsuarios", listaUsuarios); //establecer variable en la sesion
        
        response.sendRedirect("views/usuarios/verUsuario.jsp"); //redirigir
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre_usuario = request.getParameter("nombre_usuario");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
       
        if (nombre_usuario != "" && contrasenia!= "" && rol != "" ){
            
        control.crearUsuario(nombre_usuario, contrasenia, rol); //creando usuario
        response.sendRedirect("SvUsuarios");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
