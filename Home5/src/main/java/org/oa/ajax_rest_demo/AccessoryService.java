package org.oa.ajax_rest_demo;

import org.apache.log4j.Logger;
import org.oa.ajax_rest_demo.dao.StorageRepositories;
import org.oa.ajax_rest_demo.model.Accessory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/accessories")
public class AccessoryService {
	private static Logger log = Logger.getLogger(AccessoryService.class);

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getAll(@PathParam("id") int idAnimal) {
		StorageRepositories repository = StorageRepositories.getInstance();
		List<Accessory> accessories = repository.getAccessoryRepository().findAll(idAnimal);
		log.info("View accessories for id = " + idAnimal);
		return Response.ok(accessories, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Accessory accessory) {
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getAccessoryRepository().create(accessory);
		log.info("Add accessory");
		return Response.ok(accessory, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") int id) {
		Accessory accessory = new Accessory();
		accessory.setId(id);
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getAccessoryRepository().delete(accessory);
		log.info("Delete accessory");
		return Response.ok(accessory, MediaType.APPLICATION_JSON_TYPE).build();

	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Accessory accessory) {
		StorageRepositories repository = StorageRepositories.getInstance();
		repository.getAccessoryRepository().update(accessory);
		log.info("Update accessory");
		return Response.ok(accessory, MediaType.APPLICATION_JSON_TYPE).build();
	}
}
