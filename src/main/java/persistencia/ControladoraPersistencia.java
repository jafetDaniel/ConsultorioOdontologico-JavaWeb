package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horarios;
import logica.Odontologos;
import logica.Pacientes;
import logica.Personas;
import logica.Responsables;
import logica.Turnos;
import logica.Usuarios;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    HorariosJpaController horaJPA = new HorariosJpaController();
    OdontologosJpaController odontoJPA = new OdontologosJpaController();
    PacientesJpaController pacJPA = new PacientesJpaController();
    PersonasJpaController perJPA = new PersonasJpaController();
    ResponsablesJpaController respJPA = new ResponsablesJpaController();
    //SecretariosJpaController secreJPA = new SecretariosJpaController();
    TurnosJpaController turnoJPA = new TurnosJpaController();
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
    
    
    //HORARIOS
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
    
    
     //RESPONSABLES
     public void crearResponsable(Responsables resp) {
        respJPA.create(resp);
    }
    public List<Responsables> getResponsables() {
        return respJPA.findResponsablesEntities();
    }
    public void borrarResponsable(int id) {
        try {
            respJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Responsables traerResponsable(int id) {
        return respJPA.findResponsables(id);
    }
    public void editarResponsable(Responsables resp) {
        try {
            respJPA.edit(resp);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     //TURNOS
     public void crearTurno(Turnos turno) {
        turnoJPA.create(turno);
    }
    public List<Turnos> getTurnos() {
        return turnoJPA.findTurnosEntities();
    }
    public void borrarTurno(int id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Turnos traerTurno(int id) {
        return turnoJPA.findTurnos(id);
    }
    public void editarTurno(Turnos turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     //Odontologos
     public void crearOdontologo(Odontologos odonto) {
        odontoJPA.create(odonto);
    }
    public List<Odontologos> getOdontologos() {
        return odontoJPA.findOdontologosEntities();
    }
    public void borrarOdontologo(int id) {
        try {
            odontoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Odontologos traerOdontologo(int id) {
        return odontoJPA.findOdontologos(id);
    }
    public void editarOdontologo(Odontologos odonto) {
        try {
            odontoJPA.edit(odonto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Pacientes
     public void crearPaciente(Pacientes pacient) {
        pacJPA.create(pacient);
    }
    public List<Pacientes> getPacientes() {
        return pacJPA.findPacientesEntities();
    }
    public void borrarPaciente(int id) {
        try {
            pacJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Pacientes traerPaciente(int id) {
        return pacJPA.findPacientes(id);
    }
    public void editarPaciente(Pacientes pacient) {
        try {
            pacJPA.edit(pacient);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
