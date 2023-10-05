package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Horarios;
import logica.Personas;
import logica.Turnos;
import logica.Usuarios;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-05T15:14:46")
@StaticMetamodel(Odontologos.class)
public class Odontologos_ { 

    public static volatile SingularAttribute<Odontologos, Personas> persona;
    public static volatile SingularAttribute<Odontologos, Horarios> horario;
    public static volatile ListAttribute<Odontologos, Turnos> lista_turno;
    public static volatile SingularAttribute<Odontologos, Usuarios> usuario;
    public static volatile SingularAttribute<Odontologos, Integer> id_odontologo;
    public static volatile SingularAttribute<Odontologos, String> especialidad;

}