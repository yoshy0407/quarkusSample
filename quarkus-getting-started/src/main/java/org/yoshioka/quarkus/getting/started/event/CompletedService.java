package org.yoshioka.quarkus.getting.started.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;


/**
 * SpringのApplicationEventと同じ機能
 * コンポーネント間を疎結合にできる
 * 
 * @author 9800111
 *
 */
@ApplicationScoped
public class CompletedService {

	@Inject
	Event<TaskCompleted> event;
	
	public void doSomething() {
		event.fire(new TaskCompleted());
	}
}
