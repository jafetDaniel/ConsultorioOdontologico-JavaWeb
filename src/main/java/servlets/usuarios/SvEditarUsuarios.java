package servlets.usuarios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvEditarUsuarios", urlPatterns = {"/SvEditarUsuarios"})
public class SvEditarUsuarios extends HttpServlet {
  Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
         Usuario usu = control.traerUsuario(id); //obtener datos del usuario de la bd
         
         HttpSession misesion = request.getSession(); //llamando a la sesion
         misesion.setAttribute("usuEditar", usu); //establecer variable en la sesion
         
         response.sendRedirect("views/usuarios/editarUsuario.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        String nombre_usuario = request.getParameter("nombre_usuario"); //obteniendo valores del form
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        
        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        usu.setNombre_usuario(nombre_usuario); //cambiando valores de la variable de sesion
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        
       control.editarUsuario(usu); //para hacer edicion en la bd
       response.sendRedirect("SvUsuarios");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
