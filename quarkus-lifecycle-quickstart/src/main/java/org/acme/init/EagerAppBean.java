package org.acme.init;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.Startup;

//このアノテーションをつけておくとアプリケーション起動時にbean生成がされる。
//これが付加された場合、BeanはApplicationScopedになり、ApplicationScodeがなくてbeanが生成される
@Startup
@ApplicationScoped
public class EagerAppBean {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Bean生成時には、このコンストラクターが呼び出される
	public EagerAppBean() {
		logger.info("compornent started");
		//こんな感じで、静的にしてされたプロファイルが呼び出される
		logger.info(LaunchMode.current().name());
	}
	
	
}
