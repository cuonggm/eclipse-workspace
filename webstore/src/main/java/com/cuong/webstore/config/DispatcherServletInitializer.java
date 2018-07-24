package com.cuong.webstore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebApplicationContextConfig.class};
	}

	
	// Dispatcher Servlet nay se xu li cac request bat bau bang / = root url
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
