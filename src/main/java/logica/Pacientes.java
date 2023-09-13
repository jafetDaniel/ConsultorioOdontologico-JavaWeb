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
public class Pacientes implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paciente;
    
    private boolean tiene_SM; //sm= seguro medico
    private String tipo_sangre;
    
    @OneToOne
    private Responsables responsable; //relacion 1-1
    
    @OneToMany(mappedBy = "pacient") //mismo nombre que en el atributo de la clase Turnos
    private List<Turnos> lista_turnos; //relacion 1-N
    
    @OneToOne
    private Personas persona; //relacion 1-1

    public Pacientes() {
    }

    public Pacientes(int id_paciente, boolean tiene_SM, String tipo_sangre, Responsables responsable, List<Turnos> lista_turnos, Personas persona) {
        this.id_paciente = id_paciente;
        this.tiene_SM = tiene_SM;
        this.tipo_sangre = tipo_sangre;
        this.responsable = responsable;
        this.lista_turnos = lista_turnos;
        this.persona = persona;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    
    public boolean isTiene_SM() {
        return tiene_SM;
    }

    public void setTiene_SM(boolean tiene_SM) {
        this.tiene_SM = tiene_SM;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public Responsables getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsables responsable) {
        this.responsable = responsable;
    }

    public List<Turnos> getLista_turnos() {
        return lista_turnos;
    }

    public void setLista_turnos(List<Turnos> lista_turnos) {
        this.lista_turnos = lista_turnos;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
    
}
