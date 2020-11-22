package org.yoshioka.quarkus.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class GreetingResource {

  	@Inject
	private GreetingService service;
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("second")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {
        return "hello2";
    }

    @GET
    @Path("third")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello3() {
        return "hello3";
    }
    
    @GET
    @Path("greeting/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(@PathParam("name") String name) {
    	return service.greeting(name);
    }
    
}