package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona implements Serializable{
    private String especialidad;
    @OneToMany(mappedBy = "odonto")
    private List<Turno> lista_turno; //relacion 1-N
    @OneToOne
    private Usuario usuario; //relacion 1-1
    @OneToOne
    private Horario horario; //relacion 1-1

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> lista_turno, Usuario usuario, Horario horario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
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

    public List<Turno> getLista_turno() {
        return lista_turno;
    }

    public void setLista_turno(List<Turno> lista_turno) {
        this.lista_turno = lista_turno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
}
