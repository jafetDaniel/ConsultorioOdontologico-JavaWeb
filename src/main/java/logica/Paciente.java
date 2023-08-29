package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Persona implements Serializable{
    private boolean tiene_SM; //sm= seguro medico
    private String tipo_sangre;
    
    @OneToOne
    private Responsable responsable; //relacion 1-1
    
    @OneToMany(mappedBy = "pacient") //mismo nombre que en el atributo de la clase Turno
    private List<Turno> lista_turnos; //relacion 1-N

    public Paciente() {
    }

    public Paciente(boolean tiene_SM, String tipo_sangre, Responsable responsable, List<Turno> lista_turnos, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.tiene_SM = tiene_SM;
        this.tipo_sangre = tipo_sangre;
        this.responsable = responsable;
        this.lista_turnos = lista_turnos;
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

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public List<Turno> getLista_turnos() {
        return lista_turnos;
    }

    public void setLista_turnos(List<Turno> lista_turnos) {
        this.lista_turnos = lista_turnos;
    }
    
    
}
