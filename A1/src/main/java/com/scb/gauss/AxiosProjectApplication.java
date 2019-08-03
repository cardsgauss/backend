package com.scb.gauss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@ComponentScan("com.scb.gauss.*")
public class AxiosProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxiosProjectApplication.class, args);
	}
	 @Bean
	    public WebMvcConfigurer configurer() {
	    	return new WebMvcConfigurer() {
	    		@Override
	    		public void addCorsMappings(CorsRegistry registry) {
	    			registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
	    		}
			};
	    }
}
