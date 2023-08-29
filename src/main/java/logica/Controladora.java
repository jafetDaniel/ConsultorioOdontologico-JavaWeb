package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
     public boolean comprobarIngreso(String usuario, String password) { //para login
        
         boolean ingreso = false;
         List <Usuario> listaUsuarios = new ArrayList<Usuario>();
         listaUsuarios = controlPersis.getUsuarios();
         
         for (Usuario usu : listaUsuarios) {
             if (usu.getNombre_usuario().equals(usuario) ) {
                 if (usu.getContrasenia().equals(password)) {
                     ingreso = true;
                     //break;
                 }
             }
         }
         System.out.println(ingreso);
         return ingreso;
    }
    // USUARIOS
    public void crearUsuario(String nombre_usuario, String contrasenia, String rol){
        Usuario usu = new Usuario();        
        usu.setNombre_usuario(nombre_usuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        
        controlPersis.crearUsuario(usu);
    }
    public List<Usuario> getUsuarios() {
        return controlPersis.getUsuarios();
    }
    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }
    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }
    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
    
    //PERSONAS
    public void crearPersona(String dni, String nombre,String apellido,String telefono, String direccion, String fecha_nac){
        Persona per = new Persona();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //formato actual
        Date date = null;
        try {
            date = formato.parse(fecha_nac); //convirtiendo a date
 
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        per.setDni(dni);
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        per.setFecha_nac(date);
        
        controlPersis.crearPersona(per);
    }
    public List<Persona> getPersonas() {
        return controlPersis.getPersonas();
    }
    public void borrarPersona(int id) {
        controlPersis.borrarPersona(id);
    }
    public Persona traerPersona(int id) {
        return controlPersis.traerPersona(id);
    }
    public void editarPersona(Persona per) {
        controlPersis.editarPersona(per);
    }
   
}
