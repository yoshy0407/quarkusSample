package org.yoshioka.quarkus.getting.started.greet;

import javax.enterprise.context.RequestScoped;

import org.yoshioka.quarkus.getting.started.Greeting;

//@RequestComponentと一緒
@RequestScoped
public class GreetingJapanese implements Greeting{

	@Override
	public String greeting(String name) {
		return "こんにちは! " + name;
	}
}
