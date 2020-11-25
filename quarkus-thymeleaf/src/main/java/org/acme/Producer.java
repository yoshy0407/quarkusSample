package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@ApplicationScoped
public class Producer {

	@Produces
	public TemplateEngine templateEngine() {
		return new TemplateEngine() {
			{
				addDialect(new Java8TimeDialect());
				setTemplateResolver(new ClassLoaderTemplateResolver());
			}
		};
	}
}
