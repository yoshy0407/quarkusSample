package org.acme.thymeleaf;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.*;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface RenderThymeleaf {

}
