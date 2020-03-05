package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication

public class WebApp {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApp.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}
}
