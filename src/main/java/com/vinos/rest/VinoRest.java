/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.rest;

import com.vinos.controlador.DAOS.VinoDao;
import com.vinos.controlador.Utilidades;
import com.vinos.modelo.Marca;
import com.vinos.modelo.Vino;
import com.vinos.modelo.enums.TipoVino;
import com.vinos.rest.dataModel.MarcaModel;
import com.vinos.rest.dataModel.VinoModel;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author sissysebas
 */
@Path("admin/vinos")
public class VinoRest {
    private VinoDao obj = new VinoDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVinos(@HeaderParam(HttpHeaders.AUTHORIZATION) String token) {
        if (token != null && !StringUtils.isAllEmpty(token) ) {
            if (Utilidades.estaIniciadoSesion(token)) {
                List<VinoModel> lista = new ArrayList<>();
                for (Vino m : obj.listar()) {
                    lista.add(new VinoModel(m));
                }
                return Response.status(Response.Status.OK).entity(lista).build();
            } else {
                return Response.status(
                        Response.Status.FORBIDDEN)
                        .entity(Utilidades.mensajesError(Utilidades.ERROR_NOT_AUTHENTICATE))
                        .build();
            }

        } else {
            return Response.status(
                    Response.Status.FORBIDDEN)
                    .entity(Utilidades.mensajesError(Utilidades.ERROR_NOT_EXITS_TOKEN))
                    .build();
        }

    } 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tipos")
    public Response listaTipos() {
        return Response.status(Response.Status.OK).entity(TipoVino.values()).build();
    }
}
