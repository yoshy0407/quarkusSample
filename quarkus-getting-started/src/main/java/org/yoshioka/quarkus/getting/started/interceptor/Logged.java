package org.yoshioka.quarkus.getting.started.interceptor;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;

@Transactional
@RequestScoped
@Documented
//インターセプターのバインディングアノテーションはこれをつけておかなければいけない
@Stereotype
@Retention(RUNTIME)
//@Target({ TYPE, METHOD })
@Target({ TYPE})
public @interface Logged {

}
