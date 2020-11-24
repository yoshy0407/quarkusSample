package org.yoshioka.quarkus.getting.started.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class TaskCompletedLogger {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	void onTaskFired(@Observes TaskCompleted task) {
		logger.info("Event fired!!!");
	}
}
