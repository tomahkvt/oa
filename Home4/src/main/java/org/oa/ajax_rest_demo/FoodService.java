package org.oa.ajax_rest_demo;

import org.apache.log4j.Logger;
import org.oa.ajax_rest_demo.dao.StorageSession;
import org.oa.ajax_rest_demo.model.Food;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/foods")
public class FoodService {
	Logger log = Logger.getLogger(AnimalService.class);
	@Path("/{id}")
    @GET
    @Produces("application/json")
    public Response getAll(@PathParam("id") long idAnimal) {
        StorageSession session = StorageSession.getInstance();
        List<Food> foods = session.getDaoFacade().getFoodDao().loadAll(idAnimal);
        log.info("View foods for id = " + idAnimal);
        return Response.ok(foods,
                MediaType.APPLICATION_JSON_TYPE).build();
    }
	@POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Food food) {
        StorageSession session = StorageSession.getInstance();
        Food newFood = session.getDaoFacade().getFoodDao().create(food);
        log.info("Add food");
        return Response.ok(newFood,
                MediaType.APPLICATION_JSON_TYPE).build();
    }
      
	  @Path("/delete/{id}")
	    @DELETE
	    @Produces("application/json")
	    public Response delete(@PathParam("id") long id) {
	        StorageSession session = StorageSession.getInstance();
	        Food food = session.getDaoFacade().getFoodDao().findById(id);
	        session.getDaoFacade().getFoodDao().delete(food);
	        log.info("Delete food");
	        return Response.ok(food,
	                MediaType.APPLICATION_JSON_TYPE).build();

	    }
	
	    @PUT
	    @Consumes("application/json")
	    @Produces("application/json")
	    public Response update(Food food) {
	        StorageSession session = StorageSession.getInstance();
	        Food newFood = session.getDaoFacade().getFoodDao().update(food);
	        log.info("Update food");
	        return Response.ok(newFood,
	                MediaType.APPLICATION_JSON_TYPE).build();
	    }
}
