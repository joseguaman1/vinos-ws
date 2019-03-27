package com.vinos.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cuenta.class)
public abstract class Cuenta_ {

	public static volatile SingularAttribute<Cuenta, String> clave;
	public static volatile SingularAttribute<Cuenta, Boolean> estado;
	public static volatile SingularAttribute<Cuenta, Integer> tipo;
	public static volatile SingularAttribute<Cuenta, Persona> persona;
	public static volatile SingularAttribute<Cuenta, Date> updated_at;
	public static volatile SingularAttribute<Cuenta, Date> created_at;
	public static volatile SingularAttribute<Cuenta, String> external_id;
	public static volatile SingularAttribute<Cuenta, Long> id;
	public static volatile SingularAttribute<Cuenta, String> email;
	public static volatile SingularAttribute<Cuenta, String> token;

}

