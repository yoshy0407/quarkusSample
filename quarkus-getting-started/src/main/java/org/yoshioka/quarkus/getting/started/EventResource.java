package org.yoshioka.quarkus.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.yoshioka.quarkus.getting.started.event.CompletedService;

@Path("event")
public class EventResource {

	@Inject
	CompletedService service;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String success() {
		service.doSomething();
		return "success";
	}
}
