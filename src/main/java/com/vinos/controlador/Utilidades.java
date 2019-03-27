/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.controlador;

import com.vinos.controlador.DAOS.CuentaDao;
import com.vinos.modelo.Cuenta;
import java.util.Base64;
import java.util.HashMap;

/**
 *
 * @author sissysebas
 */
public class Utilidades {
    public static final int ERROR_DATA_EMPTY = 1; 
    public static final int ERROR_DATA_SAVE = 2; 
    public static final int ERROR_DATA_UPDATE = 3; 
    public static final int ERROR_ACCOUNT_NOT_EXIST = 4; 
    public static final int ERROR_PASSWORD_ERROR = 5; 
    public static final int ERROR_NOT_EXITS_TOKEN = 6; 
    public static final int ERROR_NOT_AUTHENTICATE = 7; 
    
    public static HashMap mensajesError(int error) {
        HashMap mapa = new HashMap();
        if(error == ERROR_DATA_EMPTY) 
            mapa.put("msg", "Faltan datos por completar");
        if(error == ERROR_DATA_SAVE) 
            mapa.put("msg", "No se pudo guardar");
        if(error == ERROR_DATA_UPDATE) 
            mapa.put("msg", "No se pudo modificar");
        if(error == ERROR_ACCOUNT_NOT_EXIST) 
            mapa.put("msg", "No existe su cuenta");
        if(error == ERROR_PASSWORD_ERROR) 
            mapa.put("msg", "Clave incorrecta");
        if(error == ERROR_NOT_EXITS_TOKEN) 
            mapa.put("msg", "Se requiere el token de autorizacion");
        if(error == ERROR_NOT_AUTHENTICATE) 
            mapa.put("msg", "No tiene permisos para ver este recurso");
        return mapa;
    }
    
    public static boolean estaIniciadoSesion(String token) {
        String token_decode = new String(Base64.getDecoder().decode(token));
        String[] token_destrozado = token_decode.split("-.-");
        if(token_destrozado.length == 2) {
            Cuenta c = new CuentaDao().iniciar_sesion(token_destrozado[0]);
            if(c != null) {
                if(c.getPersona().getExternal_id().equals(token_destrozado[1]))
                    return true;
                else 
                    return false;
            } else 
                return false;            
        } else {
            return false;
        }
    }
    
    public static boolean permisoAdmin(String token, String tipo) {
        if(Utilidades.estaIniciadoSesion(token)) {
            if(tipo.equals("1")) 
                return true;
            else 
                return false;
        } else 
            return false;
    }
    
}
