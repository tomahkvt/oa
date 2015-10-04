package org.oa.ajax_rest_demo;

import org.apache.log4j.Logger;
import org.oa.ajax_rest_demo.dao.StorageRepositories;
import org.oa.ajax_rest_demo.model.Animal;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/animals")
public class AnimalService {
	//private static Logger log = Logger.getLogger(AnimalService.class);

	@GET
	@Produces("application/json")
	public Response getAll() {
		StorageRepositories repository = StorageRepositories.getInstance();
		List<Animal> animals = repository.getAnimalRepository().findAll();
//		log.info("View animals");
		return Response.ok(animals, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Animal animal) {
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getAnimalRepository().create(animal);
//		log.info("Add animal");
		return Response.ok(animal, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Animal animal) {
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getAnimalRepository().update(animal);
//		log.info("Update animals");
		return Response.ok(animal, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") int id) {
		Animal animal = new Animal();
		animal.setId(id);
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getAnimalRepository().delete(animal);
		;
		//log.info("Delete animal");
		return Response.ok(animal, MediaType.APPLICATION_JSON_TYPE).build();

	}

}
