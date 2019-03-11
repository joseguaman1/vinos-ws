/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador.DAOS;

import com.vinos.controlador.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author sissy
 * @param <T>
 */
public class AdaptadorDao <T> implements InterfazDao<T> {
    private Class clzz;

    public AdaptadorDao(Class clzz) {
        this.clzz = clzz;
    }
    public EntityManager getManager() {
        return Conexion.getEm();
    }

    @Override
    public void guardar(T obj) throws Exception {
        getManager().persist(obj);
    }

    @Override
    public void modificar(T obj) throws Exception {
        getManager().merge(obj);
    }

    @Override
    public T obtener(Long id) {
        T obj = null;
        try {
            obj = (T) getManager().find(clzz, id);
        } catch (Exception e) {
            System.out.println("Error en obtener "+clzz.getName());
        }
        return obj;
    }

    @Override
    public List<T> listar() {
        List<T> lista = new ArrayList<>();
        try {
            lista = getManager().createQuery("select p from "+clzz.getSimpleName()+" p").getResultList();
        } catch (Exception e) {
            System.out.println("No se pudo listar "+e);
        }
        return lista;
    }
    
}
