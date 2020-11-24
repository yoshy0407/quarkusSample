package org.yoshioka.quarkus.getting.started.other;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PostPreBean {

	List<String> list;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostConstruct
	void init() {
		list = new ArrayList<>();
		for (int i = 0; i<=10 ;i++) {
			list.add(String.valueOf(i));
		}
	}

	@PreDestroy
	void destory() {
		list.clear();
		logger.info("call predestory");
	}
	
	public List<String> getList(){
		return list;
	}
}
