package org.acme.thymeleaf;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.thymeleaf.TemplateEngine;

@RenderThymeleaf
@Interceptor
@Priority(1)
public class ViewInterceptor {

	@Inject
	protected TemplateEngine templateEngine;
	
	@AroundInvoke
	Object wrapView(InvocationContext context) throws Exception {
		View ret = (View)context.proceed();
		ret.setTemplateEngine(templateEngine);
		return ret;
	}

}
