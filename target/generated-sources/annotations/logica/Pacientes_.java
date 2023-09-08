package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Responsables;
import logica.Turnos;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-07T18:13:27")
@StaticMetamodel(Pacientes.class)
public class Pacientes_ extends Personas_ {

    public static volatile SingularAttribute<Pacientes, Responsables> responsable;
    public static volatile ListAttribute<Pacientes, Turnos> lista_turnos;
    public static volatile SingularAttribute<Pacientes, String> tipo_sangre;
    public static volatile SingularAttribute<Pacientes, Boolean> tiene_SM;

}