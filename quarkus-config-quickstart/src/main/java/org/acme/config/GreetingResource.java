package org.acme.config;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greeting")
public class GreetingResource {

	//Springと同じように、application.propertiesから参照できる
	//ちなみにapplication.propertiesの値を変えてもHot Deployすると更新される
	@ConfigProperty(name = "greeting.message")
	String message;
	
	//デフォルト値が設定可能
	@ConfigProperty(name = "greeting.suffix", defaultValue = "!")
	String suffix;
	
	//Optionalで受けることも可能
	@ConfigProperty(name = "greeting.name")
	Optional<String> name;
	
	//コンフィグクラスをインジェクトできる
	@Inject
	PropertiesConfigration config;
	
	@Inject
	PropertiesConfigInterface inf;
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message + name.orElse("No Name") + suffix;
    }
	
	/**
	 * プログラムチックに取りに行くことも可能
	 * 
	 * @return
	 */
	@GET
    @Path("test")
	@Produces(MediaType.TEXT_PLAIN)
    public String test() {
		//Optionalで受けれる
		ConfigProvider.getConfig().getOptionalValue("test.message", String.class);
        return ConfigProvider.getConfig().getValue("test.message", String.class);
    }
	
	@GET
    @Path("test2")
	@Produces(MediaType.TEXT_PLAIN)
    public String test2() {
        return config.getMessage();
    }

	@GET
    @Path("test3")
	@Produces(MediaType.TEXT_PLAIN)
    public String test3() {
        return inf.message() + inf.suffix() + inf.name().get() + inf.suffix();
    }

}