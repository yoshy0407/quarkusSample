package org.yoshioka.quarkus.getting.started.greet;

import javax.inject.Singleton;

import org.yoshioka.quarkus.getting.started.Greeting;

//名前の通りシングルトンBean。ApplicationScopedとは異なりClientPoxyしないらしい
@Singleton
public class GreetingGerman implements Greeting {

	@Override
	public String greeting(String name) {
		return "Hallo! " + name;
	}

}
