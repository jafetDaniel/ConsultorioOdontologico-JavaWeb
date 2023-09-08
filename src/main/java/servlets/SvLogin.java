package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuarios;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
     Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre_usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Usuarios validacion = control.comprobarIngreso(nombre_usuario, password);
        
        if (validacion != null) {
            HttpSession misession = request.getSession(true);
            misession.setAttribute("id_usuario", validacion.getId_usuario());
            misession.setAttribute("nombre_usuario", validacion.getNombre_usuario());
            
            response.sendRedirect("index.jsp");
        }else{
             response.sendRedirect("login.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
