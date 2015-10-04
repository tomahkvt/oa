package org.oa.ajax_rest_demo;

import org.apache.log4j.Logger;
import org.oa.ajax_rest_demo.dao.StorageSession;
import org.oa.ajax_rest_demo.model.Accessory;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/accessories")
public class AccessoryService {
	Logger log = Logger.getLogger(AnimalService.class);
	
	@Path("/{id}")
    @GET
    @Produces("application/json")
    public Response getAll(@PathParam("id") long idAnimal) {
        StorageSession session = StorageSession.getInstance();
        List<Accessory> accessory = session.getDaoFacade().getAccessoriesDao().loadAll(idAnimal);
        log.info("View accessories for id = " + idAnimal);
        return Response.ok(accessory,
                MediaType.APPLICATION_JSON_TYPE).build();
    }
	@POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Accessory accessory) {
        StorageSession session = StorageSession.getInstance();
        Accessory newAccessory = session.getDaoFacade().getAccessoriesDao().create(accessory);
        log.info("Add accessory");
        return Response.ok(newAccessory,
                MediaType.APPLICATION_JSON_TYPE).build();
    }
      
	  @Path("/delete/{id}")
	    @DELETE
	    @Produces("application/json")
	    public Response delete(@PathParam("id") long id) {
	        StorageSession session = StorageSession.getInstance();
	        Accessory accessory = session.getDaoFacade().getAccessoriesDao().findById(id);
	        session.getDaoFacade().getAccessoriesDao().delete(accessory);
	        log.info("Delete accessory");
	        return Response.ok(accessory,
	                MediaType.APPLICATION_JSON_TYPE).build();

	    }
	
	    @PUT
	    @Consumes("application/json")
	    @Produces("application/json")
	    public Response update(Accessory accessory) {
	        StorageSession session = StorageSession.getInstance();
	        Accessory newAccessory = session.getDaoFacade().getAccessoriesDao().update(accessory);
	        log.info("Update accessory");
	        return Response.ok(newAccessory,
	                MediaType.APPLICATION_JSON_TYPE).build();
	    }
}
