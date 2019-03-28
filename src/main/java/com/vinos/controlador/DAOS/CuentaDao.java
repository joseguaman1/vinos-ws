/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador.DAOS;

import com.vinos.modelo.Cuenta;
import javax.persistence.Query;

/**
 *
 * @author sissy
 */
public class CuentaDao extends AdaptadorDao<Cuenta> {

    private Cuenta cuenta; 

    public CuentaDao() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if (this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            getManager().getTransaction().begin();
            if (cuenta.getId() != null) {
                modificar(cuenta);
            } else {
                guardar(cuenta);
            }
            getManager().getTransaction().commit();
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guarar la cuenta " + e);
        }
        return band;
    }

    public Cuenta obtenerCuentaExternal(String external) {
        Cuenta m = null;
        try {
            String query = "Select p from Cuenta p where p.external_id = :external";
            Query consulta = getManager().createQuery(query);
            consulta.setParameter("external", external);
            m = (Cuenta) consulta.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encotrar la cuenta " + e);
        }
        return m;
    }
    
    public Cuenta iniciar_sesion(String email) {
        Cuenta c = null;
        try {
            Query query = getManager().createQuery("select c from Cuenta c where c.email = :correo");
            query.setParameter("correo", email);
            c = (Cuenta)query.getSingleResult();
        } catch (Exception e) {
        }
        return c;
    }

}
