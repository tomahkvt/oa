package org.oa.ajax_rest_demo;

import org.apache.log4j.Logger;
import org.oa.ajax_rest_demo.dao.StorageRepositories;
import org.oa.ajax_rest_demo.model.Food;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/foods")
public class FoodService {
	private static Logger log = Logger.getLogger(FoodService.class);

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getAll(@PathParam("id") int idAnimal) {
		StorageRepositories repository = StorageRepositories.getInstance();
		List<Food> foods = repository.getFoodRepository().findAll(idAnimal);
		log.info("View foods for id = " + idAnimal);
		return Response.ok(foods, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Food food) {
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getFoodRepository().create(food);
		log.info("Add food");
		return Response.ok(food, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") int id) {
		Food food = new Food();
		food.setId(id);
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getFoodRepository().delete(food);
		log.info("Delete food");
		return Response.ok(food, MediaType.APPLICATION_JSON_TYPE).build();

	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Food food) {
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getFoodRepository().update(food);
		log.info("Update food");
		return Response.ok(food, MediaType.APPLICATION_JSON_TYPE).build();
	}
}
