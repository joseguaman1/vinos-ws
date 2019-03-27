/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.rest;

import com.vinos.controlador.DAOS.CuentaDao;
import com.vinos.controlador.DAOS.MarcaDao;
import com.vinos.controlador.DAOS.PersonaDao;
import com.vinos.controlador.Utilidades;
import static com.vinos.controlador.Utilidades.ERROR_NOT_AUTHENTICATE;
import com.vinos.modelo.Marca;
import com.vinos.modelo.Persona;
import com.vinos.rest.dataModel.MarcaModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author sissy
 */
@Path("admin/marca")
public class MarcaRest {

    private MarcaDao obj = new MarcaDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMarcas(@HeaderParam(HttpHeaders.AUTHORIZATION) String token, @HeaderParam("permiso") String permiso) {
        if (token != null && !StringUtils.isAllEmpty(token) && permiso != null && !StringUtils.isAllEmpty(permiso)) {
            if (Utilidades.permisoAdmin(token, permiso)) {
                List<MarcaModel> lista = new ArrayList<>();
                for (Marca m : obj.listar()) {
                    lista.add(new MarcaModel(m));
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarMarca(Marca marca) {
        obj.setMarca(null);
        marca.setExternal_id(UUID.randomUUID().toString());
        obj.setMarca(marca);
        if (obj.guardar()) {
            return Response.status(Response.Status.OK).entity(new MarcaModel(obj.getMarca())).build();
        } else {
            HashMap mapa = new HashMap();
            mapa.put("msg", "No se pudo guardar");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }
    }

    @PUT
    @Path("/{external_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarMarca(@PathParam("external_id") String external_id, Marca marca) {
        obj.setMarca(null);
        Marca marc = obj.obtenerMarcaExternal(external_id);
        if (marc != null) {
            obj.setMarca(marc);
            obj.getMarca().setNombre(marca.getNombre());
            if (obj.guardar()) {
                return Response.status(Response.Status.OK).entity(new MarcaModel(obj.getMarca())).build();
            } else {
                HashMap mapa = new HashMap();
                mapa.put("msg", "No se pudo guardar");
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
            }
        } else {
            HashMap mapa = new HashMap();
            mapa.put("msg", "No se pudo encontrar");
            return Response.status(Response.Status.BAD_REQUEST).entity(mapa).build();
        }
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMarcasTest(@HeaderParam(HttpHeaders.AUTHORIZATION) String token) {
        System.out.println("Aqui esta el token " + token);
        if (token != null) {
            List<MarcaModel> lista = new ArrayList<>();
            for (Marca m : obj.listar()) {
                lista.add(new MarcaModel(m));
            }
            return Response.status(Response.Status.OK).entity(lista).build();
        } else {
            HashMap mapa = new HashMap();
            mapa.put("msg", "No esta autorizado");
            return Response.status(Response.Status.FORBIDDEN).entity(mapa).build();
        }
    }

}
