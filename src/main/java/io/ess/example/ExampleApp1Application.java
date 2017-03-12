package io.ess.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan("io.ess.example")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ExampleApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApp1Application.class, args);
	}
}
