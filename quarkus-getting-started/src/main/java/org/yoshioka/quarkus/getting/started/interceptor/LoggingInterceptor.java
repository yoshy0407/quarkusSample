package org.yoshioka.quarkus.getting.started.interceptor;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//インターセプターはうまく動かなかった。
//以下のエラーが出るけど、ソースはintroductionと同じように書いてるけど
//javax.enterprise.inject.spi.DefinitionException: Interceptor has no bindings: org.yoshioka.quarkus.getting.started.interceptor.LoggingInterceptor

//自分たちで作成したアノテーションを、インターセプターにつけておくことで、AOP対象のアノテーションになる
@Logged
//インターセプターの実行順序を制御する。数字が小さいほど先に呼ばれる
@Priority(2020)
//インターセプターコンポーネントであることを表す。（これで自動的にbeanに登録される？）
//@Interceptor
public class LoggingInterceptor {

	//@Inject
	//Logger logger;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//対象メソッドを囲んで実行する
	@AroundInvoke
	Object logInvocation(InvocationContext context) throws Exception {
		//logger.info("start");
		Object ret = context.proceed();
		//logger.info("start");
		return ret;
	}

}
