package com.github.miajrush.university.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This configuration class contains resource handlers and @EnableWebMvc, @PropertySource and @ComponentScan
 * annotations. This class scans other configs and web packages.
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:pom.properties")
@ComponentScan(basePackages = {"com.github.miajrush.university.config", "com.github.miajrush.university.web"})
public class MvcCoreConfig implements WebMvcConfigurer {
	private final Environment environment;
	
	public MvcCoreConfig(Environment environment) {
		this.environment = environment;
	}
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/messages");
		
		return messageSource;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/bootstrap/**")
		        .addResourceLocations("/webjars/bootstrap/" + environment.getProperty("bootstrap.version") + "/");
		registry.addResourceHandler("/jquery/**")
		        .addResourceLocations("/webjars/jquery/" + environment.getProperty("jquery.version") + "/");
		registry.addResourceHandler("/datatables/**")
		        .addResourceLocations("/webjars/datatables/" + environment.getProperty("datatables.version") + "/");
	}
}
