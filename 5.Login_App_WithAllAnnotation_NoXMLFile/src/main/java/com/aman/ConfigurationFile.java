package com.aman;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.aman"})
public class ConfigurationFile {

	@Bean
	public InternalResourceViewResolver viewResolverAman(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/viewFiles/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
