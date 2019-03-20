/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sissy
 */
public class Conexion {
    private static String NAME_PERSISTENCE = "vinosPU";
    private static EntityManager em;
    private static EntityManagerFactory sesion() {
        return Persistence.createEntityManagerFactory(NAME_PERSISTENCE);
    }

    public static EntityManager getEm() {
        if(Conexion.em == null) {
            Conexion.em = sesion().createEntityManager();
        }
        return em;
    }
    
}
