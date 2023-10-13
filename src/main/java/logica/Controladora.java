package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public void crearPersona(String dni, String nombre,String apellido,String telefono, String direccion, Date fecha_nac){
        Personas per = new Personas();
    
        per.setDni(dni);
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        per.setFecha_nac(fecha_nac);
        
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
    
    
    //HORARIOS
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
    
    
     //RESPONSABLES
    public void crearResponsable(String tipo_resp, Personas persona){
        Responsables resp = new Responsables();
        
        resp.setTipo_resp(tipo_resp);
        resp.setPersona(persona);
        
        controlPersis.crearResponsable(resp);
    }
    public List<Responsables> getResponsables() {
        return controlPersis.getResponsables();
    }
    public void borrarResponsable(int id) {
        controlPersis.borrarResponsable(id);
    }
    public Responsables traerResponsable(int id) {
        return controlPersis.traerResponsable(id);
    }
    public void editarResponsable(Responsables resp) {
        controlPersis.editarResponsable(resp);
    }
    
    
      //TURNOS
    public void crearTurno(Date fecha_turno, String hora_turno, String tratamiento, Odontologos odonto, Pacientes pacient){
        Turnos turno = new Turnos();
        
        turno.setFecha_turno(fecha_turno);
        turno.setHora_turno(hora_turno);
        turno.setTratamiento(tratamiento);
        turno.setOdonto(odonto);
        turno.setPacient(pacient);
        
        controlPersis.crearTurno(turno);
    }
    public List<Turnos> getTurnos() {
        return controlPersis.getTurnos();
    }
    public void borrarTurno(int id) {
        controlPersis.borrarTurno(id);
    }
    public Turnos traerTurno(int id) {
        return controlPersis.traerTurno(id);
    }
    public void editarTurno(Turnos turno) {
        controlPersis.editarTurno(turno);
    }
    
    
      //ODONTOLOGOS
    public void crearOdontologo(String especialidad, Usuarios usuario, Horarios horario, Personas persona){
        Odontologos odonto = new Odontologos();
        
        odonto.setEspecialidad(especialidad);
        //odonto.setLista_turno(lista_turno);
        odonto.setUsuario(usuario);
        odonto.setHorario(horario);
        odonto.setPersona(persona);
        
        controlPersis.crearOdontologo(odonto);
    }
    public List<Odontologos> getOdontologos() {
        return controlPersis.getOdontologos();
    }
    public void borrarOdontologo(int id) {
        controlPersis.borrarOdontologo(id);
    }
    public Odontologos traerOdontologo(int id) {
        return controlPersis.traerOdontologo(id);
    }
    public void editarOdontologo(Odontologos odonto) {
        controlPersis.editarOdontologo(odonto);
    }
    
    //PACIENTES
    public void crearPaciente(boolean tiene_SM, String tipo_sangre, Responsables responsable, Personas persona){
        Pacientes pacient = new Pacientes();
        
        pacient.setTiene_SM(tiene_SM);
        pacient.setTipo_sangre(tipo_sangre);
        pacient.setResponsable(responsable);
        //pacient.setLista_turnos(lista_turnos);
        pacient.setPersona(persona);
        
        controlPersis.crearPaciente(pacient);
    }
    public List<Pacientes> getPacientes() {
        return controlPersis.getPacientes();
    }
    public void borrarPaciente(int id) {
        controlPersis.borrarPaciente(id);
    }
    public Pacientes traerPaciente(int id) {
        return controlPersis.traerPaciente(id);
    }
    public void editarPaciente(Pacientes pacient) {
        controlPersis.editarPaciente(pacient);
    }
    
    
    //SECRETARIOS
    public void crearSecretario(String sector, Usuarios usuario, Personas persona){
        Secretarios secre = new Secretarios();
        
        secre.setSector(sector);
        secre.setUsuario(usuario);
        secre.setPersona(persona);
        
        controlPersis.crearSecretario(secre);
    }
    public List<Secretarios> getSecretarios() {
        return controlPersis.getSecretarios();
    }
    public void borrarSecretario(int id) {
        controlPersis.borrarSecretario(id);
    }
    public Secretarios traerSecretario(int id) {
        return controlPersis.traerSecretario(id);
    }
    public void editarSecretario(Secretarios secre) {
        controlPersis.editarSecretario(secre);
    }
   
}
