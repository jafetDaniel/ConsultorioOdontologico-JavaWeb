package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Secretarios implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_secretario;
    
    private String sector;
    
    @OneToOne
    private Usuarios usuario; //relacion1-1
    
    @OneToOne
    private Personas persona; //relacion 1-1

    public Secretarios() {
    }

    public Secretarios(int id_secretario, String sector, Usuarios usuario, Personas persona) {
        this.id_secretario = id_secretario;
        this.sector = sector;
        this.usuario = usuario;
        this.persona = persona;
    }

    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
    
    
}
