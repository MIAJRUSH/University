package com.github.miajrush.university.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This configuration class initializes the application.
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MvcCoreConfig.class, MvcDataSourceConfig.class, MvcViewConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
}
