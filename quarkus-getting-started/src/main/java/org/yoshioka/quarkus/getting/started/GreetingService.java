package org.yoshioka.quarkus.getting.started;

import javax.enterprise.context.ApplicationScoped;

//@SingletonComponentと一緒
@ApplicationScoped
public class GreetingService {

	public String greeting(String name) {
		return "Hello! " + name;
	}
}
