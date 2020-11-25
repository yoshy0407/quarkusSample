package org.acme.resource;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.resource.PersonForm.Status;
import org.acme.thymeleaf.RenderThymeleaf;
import org.acme.thymeleaf.View;

@Path("test")
public class TestResource {

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    @RenderThymeleaf
    public View getHTML(@PathParam("name") String name) {
        View view = new View();
    	view.setViewName("person.html");
    	view.setParam("p", createPerson(name));
    	return view;
    }

    protected PersonForm createPerson(String name) {
    	PersonForm form = new PersonForm();
    	form.name = name;
    	form.birth = LocalDate.now();
    	form.status = Status.Alive;
    	return form;
    }
	
}
