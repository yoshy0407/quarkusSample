package org.yoshioka.quarkus.getting.started;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.yoshioka.quarkus.getting.started.greet.GreetingEnglish;
import org.yoshioka.quarkus.getting.started.greet.GreetingFrench;
import org.yoshioka.quarkus.getting.started.greet.GreetingGerman;
import org.yoshioka.quarkus.getting.started.interceptor.Logged;

@Path("/hello")
public class GreetingResource {

	//これでDIされる
	@Inject
	private GreetingEnglish service;
  	
	/**
	 * 複数インスタンスの場合、Instanceで囲むと複数インジェクションできる。
	 */
	@Inject
  	Instance<Greeting> greetings;
	
	//セッターインジェクション用
	GreetingGerman greetingGerman;
	
	//コンストラクターインジェクション用
	GreetingFrench french;
	
	//コンストラクターインジェクションは、アノテーションの設定は不要
 	public GreetingResource(GreetingFrench french) {
 		this.french = french;
 	}	
	
 	//@Logged
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
    
    @GET
    @Path("greetings/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greetings(@PathParam("name") String name) {
    	//インジェクションしたInstanceは、Iterableを実装してるので、拡張forループが可能
    	StringBuilder builder = new StringBuilder();
    	for (Greeting greeting: greetings) {
    		builder.append(greeting.greeting(name));
    		builder.append(", ");
    	}
    	return builder.toString();
    }

    @GET
    @Path("german/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greetGerman(@PathParam("name") String name) {
    	return greetingGerman.greeting(name);
    }
    
    @GET
    @Path("french/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greetFrench(@PathParam("name") String name) {
    	return french.greeting(name);
    }
    
    /**
     * セッターインジェクションは@Injectをつける
     */
    @Inject
    public void setGerman(GreetingGerman german) {
    	this.greetingGerman = german;
    }
    
}