/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.rest;

import com.vinos.controlador.DAOS.CuentaDao;
import com.vinos.controlador.Utilidades;
import com.vinos.modelo.Cuenta;
import com.vinos.modelo.Marca;
import com.vinos.rest.dataModel.InicioModel;
import com.vinos.rest.dataModel.MarcaModel;
import java.util.HashMap;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author sissysebas
 */
@Path("inicio")
public class CuentaRest {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inciar_sesion(InicioModel inicio) {
        
        if (!StringUtils.isAllEmpty(inicio.email) && !StringUtils.isAllEmpty(inicio.clave)) {
            Cuenta cuenta = new CuentaDao().iniciar_sesion(inicio.email);
            if(cuenta != null) {
                if(cuenta.getClave().equals(inicio.clave)) {
                    String rol = (cuenta.getTipo() == 1) ? "Administrador" : "Cliente";
                    HashMap mapa = new HashMap();
                    mapa.put("token", cuenta.getToken());
                    mapa.put("usuario", cuenta.getPersona().toString());
                    mapa.put("rol", rol);
                    mapa.put("tipo", cuenta.getTipo());
                    return Response.status
                            (Response.Status.OK)
                            .entity(mapa)
                            .build();
                } else {
                    return Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Utilidades.mensajesError
        (Utilidades.ERROR_PASSWORD_ERROR))
                    .build();
                }                   
            } else {
                return Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Utilidades.mensajesError
        (Utilidades.ERROR_ACCOUNT_NOT_EXIST))
                    .build();
            }
            
        } else {            
            return Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Utilidades.mensajesError
        (Utilidades.ERROR_DATA_EMPTY))
                    .build();
        }
    }
}
