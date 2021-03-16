package com.jlg.future;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayFutureApplication {
	
	@Value("${service.environment}")
	private String environment;

	public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplicationBuilder(GatewayFutureApplication.class)
    			.properties("spring.config.name:future",
    		            "spring.main.banner-mode=log")
    			.build();
    			springApplication.run(args);
    }
    	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}
	
	@GetMapping("/future")
	public String future(@RequestParam(value = "when", defaultValue = "Soon") String name) {
	return String.format("The future is %s!", name);
	}
	
	@GetMapping("/env")
	public String getEnvironment() {
	return String.format("The environment is %s!", environment);
	}

}
