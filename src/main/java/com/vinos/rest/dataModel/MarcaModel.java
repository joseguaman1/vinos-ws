/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.rest.dataModel;

import com.vinos.modelo.Marca;

/**
 *
 * @author sissy
 */
public class MarcaModel {
    public String nombre;
    public String external_id;
    public Boolean estado;   

    public MarcaModel(Marca marca) {
        nombre = marca.getNombre();
        external_id = marca.getExternal_id();
        estado = marca.getEstado();
    }   
    
}
