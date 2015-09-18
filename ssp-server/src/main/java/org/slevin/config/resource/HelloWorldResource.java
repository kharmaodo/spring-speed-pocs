package org.slevin.config.resource;

import org.slevin.config.model.Human;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class HelloWorldResource {
	
	private static final String TEMPLATE = "Hello, %s!";
	
	@GET
	@Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Human sayHello(@PathParam("name") String name) {
		return new Human(String.format(TEMPLATE, name));
    }
}
