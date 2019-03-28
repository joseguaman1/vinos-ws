/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.rest.dataModel;

import com.vinos.modelo.Vino;

/**
 *
 * @author sissysebas
 */
public class VinoModel {
    public String nombre;
    public String external_marca;
    public String marca;
    public String tipo;
    public String precio;
    public String pais;  
    public String foto;  

    public VinoModel(Vino vino) {
        nombre = vino.getNombre();
        external_marca = vino.getMarca().getExternal_id();
        marca = vino.getMarca().getNombre();
        tipo = String.valueOf(vino.getTipo());
        precio = String.valueOf(vino.getPrecio());
        pais = vino.getPais();
        foto = vino.getFoto();
    }
    
}
