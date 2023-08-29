package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Horario;
import logica.Turno;
import logica.Usuario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-14T15:12:27")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ extends Persona_ {

    public static volatile SingularAttribute<Odontologo, Horario> horario;
    public static volatile ListAttribute<Odontologo, Turno> lista_turno;
    public static volatile SingularAttribute<Odontologo, Usuario> usuario;
    public static volatile SingularAttribute<Odontologo, String> especialidad;

}