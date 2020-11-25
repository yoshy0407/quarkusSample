package org.acme.resource;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.resource.PersonForm.Status;
import org.acme.thymeleaf.ThymeleafRenderer;
import org.jboss.resteasy.plugins.providers.html.Renderable;

@Path("/person")
public class PersonResource {

	@Inject
	public ThymeleafRenderer views;
	
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    public Renderable getHTML(@PathParam("name") String name) {
        return views
            .view("person.html")
            .with("p", createPerson(name));
    }
    
    protected PersonForm createPerson(String name) {
    	PersonForm form = new PersonForm();
    	form.name = name;
    	form.birth = LocalDate.now();
    	form.status = Status.Alive;
    	return form;
    }
	
	
}
