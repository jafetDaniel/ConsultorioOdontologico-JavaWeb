package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Odontologos;
import logica.Pacientes;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-07T18:13:27")
@StaticMetamodel(Turnos.class)
public class Turnos_ { 

    public static volatile SingularAttribute<Turnos, Odontologos> odonto;
    public static volatile SingularAttribute<Turnos, Pacientes> pacient;
    public static volatile SingularAttribute<Turnos, String> hora_turno;
    public static volatile SingularAttribute<Turnos, Date> fecha_turno;
    public static volatile SingularAttribute<Turnos, Integer> id_turno;
    public static volatile SingularAttribute<Turnos, String> tratamiento;

}