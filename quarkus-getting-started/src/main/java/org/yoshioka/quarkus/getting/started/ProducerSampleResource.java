package org.yoshioka.quarkus.getting.started;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.yoshioka.quarkus.getting.started.interceptor.Logged;

@Path("producer")
@Logged
public class ProducerSampleResource {

	//変数名をProducer側に合わせる
	@Inject
	String producerStr;
	
	//変数名をメソッド名に合わせる
	@Inject
	List<String> names;
	
	@GET
	@Path("single")
	@Produces(MediaType.TEXT_PLAIN)
	public String producer() {
		return producerStr;
	}
	
	@GET
	@Path("list")
	@Produces(MediaType.TEXT_PLAIN)
	public String producers() {
		return names.toString();
	}
}
