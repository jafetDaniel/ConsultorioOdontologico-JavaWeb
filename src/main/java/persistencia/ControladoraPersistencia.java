package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horarios;
import logica.Personas;
import logica.Usuarios;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    HorariosJpaController horaJPA = new HorariosJpaController();
    OdontologosJpaController odontoJPA = new OdontologosJpaController();
    PacientesJpaController pacJPA = new PacientesJpaController();
    PersonasJpaController perJPA = new PersonasJpaController();
    ResponsablesJpaController respJPA = new ResponsablesJpaController();
    SecretariosJpaController secreJPA = new SecretariosJpaController();
    TurnosJpaController turnJPA = new TurnosJpaController();
    UsuariosJpaController usuJPA = new UsuariosJpaController();

    public void crearUsuario(Usuarios usu) {
        usuJPA.create(usu);
    }
    public List<Usuarios> getUsuarios() {
        return usuJPA.findUsuariosEntities();
    }
    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuarios traerUsuario(int id) {
        return usuJPA.findUsuarios(id);
    }
    public void editarUsuario(Usuarios usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //PERSONAS
     public void crearPersona(Personas per) {
        perJPA.create(per);
    }
    public List<Personas> getPersonas() {
        return perJPA.findPersonasEntities();
    }
    public void borrarPersona(int id) {
        try {
            perJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Personas traerPersona(int id) {
        return perJPA.findPersonas(id);
    }
    public void editarPersona(Personas per) {
        try {
            perJPA.edit(per);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //HORARIO
     public void crearHorario(Horarios horario) {
        horaJPA.create(horario);
    }
    public List<Horarios> getHorarios() {
        return horaJPA.findHorariosEntities();
    }
    public void borrarHorario(int id) {
        try {
            horaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Horarios traerHorario(int id) {
        return horaJPA.findHorarios(id);
    }
    public void editarHorario(Horarios horario) {
        try {
            horaJPA.edit(horario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
  
}
