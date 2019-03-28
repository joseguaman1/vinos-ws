/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.modelo.enums;

/**
 *
 * @author sissy
 */
public enum TipoVino {
    ESPUMOSO("Espumoso"), TINTO("Tinto"), BLANCO("Blanco");
    private String tipo;

    private TipoVino(String tipo) {
        this.tipo = tipo;
    }
    
}
