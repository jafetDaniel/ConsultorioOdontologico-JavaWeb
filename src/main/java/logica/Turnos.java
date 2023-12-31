package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turnos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turno;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_turno;
    
    private String hora_turno;
    private String tratamiento;
    
    @ManyToOne
    @JoinColumn(name = "id_odonto")
    private Odontologos odonto;
    
    @ManyToOne
    @JoinColumn(name = "id_pacient")
    private Pacientes pacient;

    public Turnos() {
    }
    
    public Turnos(int id_turno, Date fecha_turno, String hora_turno, String tratamiento, Odontologos odonto, Pacientes pacient) {
        this.id_turno = id_turno;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.tratamiento = tratamiento;
        this.odonto = odonto;
        this.pacient = pacient;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Date getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public String getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Odontologos getOdonto() {
        return odonto;
    }

    public void setOdonto(Odontologos odonto) {
        this.odonto = odonto;
    }

    public Pacientes getPacient() {
        return pacient;
    }

    public void setPacient(Pacientes pacient) {
        this.pacient = pacient;
    }
    
    
    
}
