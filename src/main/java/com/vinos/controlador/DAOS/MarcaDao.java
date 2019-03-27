/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador.DAOS;

import com.vinos.modelo.Marca;
import javax.persistence.Query;

/**
 *
 * @author sissy
 */
public class MarcaDao extends AdaptadorDao<Marca> {

    private Marca marca;

    public MarcaDao() {
        super(Marca.class);
    }

    public Marca getMarca() {
        if (this.marca == null) {
            this.marca = new Marca();
        }
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            getManager().getTransaction().begin();
            if (marca.getId() != null) {
                modificar(marca);
            } else {
                guardar(marca);
            }
            getManager().getTransaction().commit();
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guarar la marca " + e);
        }
        return band;
    }

    public Marca obtenerMarcaExternal(String external) {
        Marca m = null;
        try {
            String query = "Select p from Marca p where p.external_id = :external";
            Query consulta = getManager().createQuery(query);
            consulta.setParameter("external", external);
            m = (Marca) consulta.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encotrar la marca " + e);
        }
        return m;
    }

}
