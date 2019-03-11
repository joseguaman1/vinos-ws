package com.vinos;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("sisa")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        
        HashMap mapa = new HashMap();
        mapa.put("mensaje", "Hola sissa!");
        return Response.status(Response.Status.OK).entity(mapa).build();
    }
}
