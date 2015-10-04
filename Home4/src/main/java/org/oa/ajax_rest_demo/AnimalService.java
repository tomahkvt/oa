package org.oa.ajax_rest_demo;

import org.apache.log4j.Logger;
import org.oa.ajax_rest_demo.dao.StorageSession;
import org.oa.ajax_rest_demo.model.Animal;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/animals")
public class AnimalService {
	Logger log = Logger.getLogger(AnimalService.class);
    @GET
    @Produces("application/json")
    public Response getAll() {
        StorageSession session = StorageSession.getInstance();
        List<Animal> animals = session.getDaoFacade().getAnimalDao().loadAll();
        log.info("View animals");
        return Response.ok(animals,
                MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Animal animal) {
        StorageSession session = StorageSession.getInstance();
        System.out.println("test");
        Animal newAnimal = session.getDaoFacade().getAnimalDao().create(animal);
        log.info("Add animal");
        return Response.ok(newAnimal,
                MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Animal animal) {
        StorageSession session = StorageSession.getInstance();
        System.out.println("update");
        Animal newAnimal = session.getDaoFacade().getAnimalDao().update(animal);
        log.info("Update animals");
        return Response.ok(newAnimal,
                MediaType.APPLICATION_JSON_TYPE).build();
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        StorageSession session = StorageSession.getInstance();
        System.out.println("delete=" + id);
        Animal animal = session.getDaoFacade().getAnimalDao().findById(id);
        session.getDaoFacade().getAnimalDao().delete(animal);
        log.info("Delete animal");
        return Response.ok(animal,
                MediaType.APPLICATION_JSON_TYPE).build();

    }
    
}
