package com.vinos.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> apellidos;
	public static volatile SingularAttribute<Persona, Boolean> estado;
	public static volatile SingularAttribute<Persona, Date> updated_at;
	public static volatile SingularAttribute<Persona, String> cedula;
	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile SingularAttribute<Persona, Cuenta> cuenta;
	public static volatile SingularAttribute<Persona, Date> created_at;
	public static volatile SingularAttribute<Persona, String> external_id;
	public static volatile SingularAttribute<Persona, Long> id;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, String> nombres;

}

