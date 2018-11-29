package com.accenture.lkm.web.webxml;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.accenture.lkm.spring.web.config.SpringWebContextConfigurator;
import com.accenture.resources.SpringRootContext;
//AnnotationConfigDispatcherServletInitializer
public class JavaWebIntializerOrWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {

	// for root context
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringRootContext.class };
	}

	// for web context
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringWebContextConfigurator.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/","*.html" };
	}
	

}


