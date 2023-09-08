package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologos extends Personas implements Serializable{
    private String especialidad;
    
    @OneToMany(mappedBy = "odonto")
    private List<Turnos> lista_turno; //relacion 1-N
    
    @OneToOne
    private Usuarios usuario; //relacion 1-1
    
    @OneToOne
    private Horarios horario; //relacion 1-1

    public Odontologos() {
    }

    public Odontologos(String especialidad, List<Turnos> lista_turno, Usuarios usuario, Horarios horario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.lista_turno = lista_turno;
        this.usuario = usuario;
        this.horario = horario;
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
    
}
