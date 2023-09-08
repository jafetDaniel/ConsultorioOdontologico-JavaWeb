package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pacientes extends Personas implements Serializable{
    private boolean tiene_SM; //sm= seguro medico
    private String tipo_sangre;
    
    @OneToOne
    private Responsables responsable; //relacion 1-1
    
    @OneToMany(mappedBy = "pacient") //mismo nombre que en el atributo de la clase Turnos
    private List<Turnos> lista_turnos; //relacion 1-N

    public Pacientes() {
    }

    public Pacientes(boolean tiene_SM, String tipo_sangre, Responsables responsable, List<Turnos> lista_turnos, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
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
    
    
}
