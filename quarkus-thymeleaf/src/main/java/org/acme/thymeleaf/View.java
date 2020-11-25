package org.acme.thymeleaf;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;

import org.jboss.resteasy.plugins.providers.html.Renderable;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

public class View implements Renderable{

	protected TemplateEngine templateEngine; 
	
	protected String viewName;
	
	protected Map<String, Object> params;
	
	protected String rootPath = "META-INF/resources/";
	
	public View() {
		this.params = new HashMap<>();
	}
	
	public View setViewName(String viewName) {
		this.viewName = viewName;
		return this;
	}
	
	public View setParam(String key, Object param) {
		this.params.put(key, param);
		return this;
	}
	
	public View setTemplateEngine(TemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
		return this;
	}
	
	
	@Override
	public void render(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, WebApplicationException {
		//本当はここで、引数に異常がないかチェック
		WebContext context = new WebContext(request, response, request.getServletContext());
		
		context.setVariables(params);
		
		templateEngine.process(rootPath + viewName, context, new OutputStreamWriter(response.getOutputStream(),StandardCharsets.UTF_8));

		
	}

}
