package org.yoshioka.quarkus.getting.started;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.yoshioka.quarkus.getting.started.other.PostPreBean;

@Path("postpre")
public class PostPreResource {

	@Inject
	PostPreBean postPreBean;
	
	@GET
	@Path("list")
	@Produces(MediaType.TEXT_PLAIN)
	public String list() {
		return postPreBean.getList().toString();
	}
	
}
