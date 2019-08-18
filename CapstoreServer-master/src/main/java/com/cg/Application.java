package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("Hey");
		return builder.sources(Application.class);
	}
	
	@Bean
	public CorsFilter corsFilter() {

	 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

	 CorsConfiguration config = new CorsConfiguration();

	 config.setAllowCredentials(true);

	 config.addAllowedOrigin("*");

	 config.addAllowedHeader("*");

	 config.addAllowedMethod("OPTIONS");

	 config.addAllowedMethod("GET");

	 config.addAllowedMethod("POST");

	 config.addAllowedMethod("PUT");

	 config.addAllowedMethod("DELETE");

	 source.registerCorsConfiguration("/**", config);

	 return new CorsFilter(source);

}
	
}
