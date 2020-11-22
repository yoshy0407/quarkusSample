package org.acme.config;

import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

/**
 * application.propertiesの内容をインタフェースにバインドすることも可能
 * @author 9800111
 *
 */
@ConfigProperties(prefix = "interface.test")
public interface PropertiesConfigInterface {

	@ConfigProperty(name = "msg")
	String message();
	
	@ConfigProperty(defaultValue = "!")
	String suffix();

	//アノテーションなしでもバインドされる
	Optional<String> name();

}
