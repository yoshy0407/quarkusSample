package org.acme.config;


import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "test.quarkus")
public class PropertiesConfigration {

	//test.quarkus.messageでバインディングできる
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
