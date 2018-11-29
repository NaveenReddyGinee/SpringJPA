
package com.accenture.lkm.spring.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration //makes the class declared as Spring configuration file..

public class SpringConfig extends WebMvcConfigurationSupport{
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false).
		//Setting to favor/use the parameter
	    favorParameter(true).
	    
	    //name of the Parameter to be sent as the part of URL to determine the Content Type to send back
	    parameterName("cst_mediaType").
	    ignoreAcceptHeader(true).
	    
	    //Setting JAF to false as here we are using the explicit media type mapping
	    useJaf(false).
	    
	    //Setting Media Types
	    mediaType("xml", MediaType.APPLICATION_XML). 
	    mediaType("json", MediaType.APPLICATION_JSON).
	    mediaType("xyz", MediaType.APPLICATION_JSON).
	    defaultContentType(MediaType.APPLICATION_XML);
	}
}