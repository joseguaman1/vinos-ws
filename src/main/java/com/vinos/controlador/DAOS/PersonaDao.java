/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador.DAOS;

import com.vinos.modelo.Persona;
import javax.persistence.Query;

/**
 *
 * @author sissy
 */
public class PersonaDao extends AdaptadorDao<Persona> {

    private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            getManager().getTransaction().begin();
            if (persona.getId() != null) {
                modificar(persona);
            } else {
                guardar(persona);
            }
            getManager().getTransaction().commit();
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guarar la persona " + e);
        }
        return band;
    }

    public Persona obtenerPersonaExternal(String external) {
        Persona m = null;
        try {
            String query = "Select p from Persona p where p.external_id = :external";
            Query consulta = getManager().createQuery(query);
            consulta.setParameter("external", external);
            m = (Persona) consulta.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encotrar la persona " + e);
        }
        return m;
    }

}
