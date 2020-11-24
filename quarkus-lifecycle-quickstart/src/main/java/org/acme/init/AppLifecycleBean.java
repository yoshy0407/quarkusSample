package org.acme.init;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

/**
 * アプリケーションの起動時にフックして、特定のメソッドを実行する
 * JVMでの実行時には、@Initializedや@Destoryedとほとんど変わりがない
 * （ただし、StartupEventは、@Initializedの後に、ShutdownEventは@Destroyedの前に実行される）
 * native-image化した場合、@Initializedは、native-imageのビルド中に実行される。
 * StartupEventはnative-imageの実行時に実行される
 * 
 * @author
 *
 */
@ApplicationScoped
public class AppLifecycleBean {

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//StartupEventが引数であることを受けて、アプリケーションの起動時にフックして、このメソッドが呼び出される
	public void onStartEvent(@Observes StartupEvent evnet) {
		logger.info("The application is starting...");
	}

	//ShutdownEventが引数であることを受けて、アプリケーションの停止時にフックして、このメソッドが呼び出される
	public void onShutdownEvent(@Observes ShutdownEvent evnet) {
		logger.info("The application is stopping...");
	}

	
}
