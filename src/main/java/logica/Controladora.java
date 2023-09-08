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
    
     public Usuarios comprobarIngreso(String nombre_usuario, String password) { //para login
        
         Usuarios ingreso = null;
         List <Usuarios> listaUsuarios = new ArrayList<Usuarios>();
         listaUsuarios = controlPersis.getUsuarios();
         
         for (Usuarios usu : listaUsuarios) {
             if (usu.getNombre_usuario().equals(nombre_usuario) ) {
                 if (usu.getContrasenia().equals(password)) {
                     ingreso = usu;
                     break;
                 }
             }
         }
        // System.out.println(ingreso);
         return ingreso;
    }
    // USUARIOS
    public void crearUsuario(String nombre_usuario, String contrasenia, String rol){
        Usuarios usu = new Usuarios();        
        usu.setNombre_usuario(nombre_usuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        
        controlPersis.crearUsuario(usu);
    }
    public List<Usuarios> getUsuarios() {
        return controlPersis.getUsuarios();
    }
    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }
    public Usuarios traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }
    public void editarUsuario(Usuarios usu) {
        controlPersis.editarUsuario(usu);
    }
    
    //PERSONAS
    public void crearPersona(String dni, String nombre,String apellido,String telefono, String direccion, String fecha_nac){
        Personas per = new Personas();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //formato actual (y de BD)
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
    public List<Personas> getPersonas() {
        return controlPersis.getPersonas();
    }
    public void borrarPersona(int id) {
        controlPersis.borrarPersona(id);
    }
    public Personas traerPersona(int id) {
        return controlPersis.traerPersona(id);
    }
    public void editarPersona(Personas per) {
        controlPersis.editarPersona(per);
    }
    
    
    //HORARIO
    public void crearHorario(String horario_inicio, String horario_fin){
        Horarios horario = new Horarios();
        
        horario.setHorario_inicio(horario_inicio);
        horario.setHorario_fin(horario_fin);
        
        controlPersis.crearHorario(horario);
    }
    public List<Horarios> getHorarios() {
        return controlPersis.getHorarios();
    }
    public void borrarHorario(int id) {
        controlPersis.borrarHorario(id);
    }
    public Horarios traerHorario(int id) {
        return controlPersis.traerHorario(id);
    }
    public void editarHorario(Horarios horario) {
        controlPersis.editarHorario(horario);
    }
   
}
