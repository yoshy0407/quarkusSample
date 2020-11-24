package org.yoshioka.quarkus.getting.started.greet;

import javax.enterprise.context.ApplicationScoped;

import org.yoshioka.quarkus.getting.started.Greeting;

//SingletonComponent
@ApplicationScoped
public class GreetingFrench implements Greeting {

	@Override
	public String greeting(String name) {
		return "Bonjour!" + name;
	}

}
