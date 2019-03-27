package com.vinos.modelo;

import com.vinos.modelo.enums.TipoVino;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vino.class)
public abstract class Vino_ {

	public static volatile SingularAttribute<Vino, Marca> marca;
	public static volatile SingularAttribute<Vino, TipoVino> tipo;
	public static volatile SingularAttribute<Vino, Double> precio;
	public static volatile SingularAttribute<Vino, String> external_id;
	public static volatile SingularAttribute<Vino, Long> id;
	public static volatile SingularAttribute<Vino, String> nombre;
	public static volatile SingularAttribute<Vino, Integer> anio;
	public static volatile SingularAttribute<Vino, String> pais;

}

