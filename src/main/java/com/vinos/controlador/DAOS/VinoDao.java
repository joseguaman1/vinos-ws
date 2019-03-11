/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador.DAOS;

import com.vinos.modelo.Vino;

/**
 *
 * @author sissy
 */
public class VinoDao extends AdaptadorDao<Vino> {

    private Vino vino;

    public VinoDao() {
        super(Vino.class);
    }

    public Vino getVino() {
        if (this.vino == null) {
            this.vino = new Vino();
        }
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            getManager().getTransaction().begin();
            if (vino.getId() != null) {
                modificar(vino);
            } else {
                guardar(vino);
            }
            getManager().getTransaction().commit();
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guarar la vino " + e);
        }
        return band;
    }
}
