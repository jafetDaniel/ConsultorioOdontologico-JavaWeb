package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Personas;
import logica.Usuarios;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-05T15:14:46")
@StaticMetamodel(Secretarios.class)
public class Secretarios_ { 

    public static volatile SingularAttribute<Secretarios, Personas> persona;
    public static volatile SingularAttribute<Secretarios, Integer> id_secretario;
    public static volatile SingularAttribute<Secretarios, Usuarios> usuario;
    public static volatile SingularAttribute<Secretarios, String> sector;

}