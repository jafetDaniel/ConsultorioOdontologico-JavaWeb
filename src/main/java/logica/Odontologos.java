package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_odontologo;
            
    private String especialidad;
    
    @OneToMany(mappedBy = "odonto")
    private List<Turnos> lista_turno; //relacion 1-N
    
    @OneToOne
    private Usuarios usuario; //relacion 1-1
    
    @OneToOne
    private Horarios horario; //relacion 1-1
    
    @OneToOne
    private Personas persona;

    public Odontologos() {
    }

    public Odontologos(int id_odontologo, String especialidad, List<Turnos> lista_turno, Usuarios usuario, Horarios horario, Personas persona) {
        this.id_odontologo = id_odontologo;
        this.especialidad = especialidad;
        this.lista_turno = lista_turno;
        this.usuario = usuario;
        this.horario = horario;
        this.persona = persona;
    }

    public Odontologos(int id_odontologo, String especialidad, Usuarios usuario, Horarios horario, Personas persona) {
        this.id_odontologo = id_odontologo;
        this.especialidad = especialidad;
        this.usuario = usuario;
        this.horario = horario;
        this.persona = persona;
    }
    
    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turnos> getLista_turno() {
        return lista_turno;
    }

    public void setLista_turno(List<Turnos> lista_turno) {
        this.lista_turno = lista_turno;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario) {
        this.horario = horario;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
    
    
}
