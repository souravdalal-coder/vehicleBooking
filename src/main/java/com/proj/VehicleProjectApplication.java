package com.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@ComponentScan("com.proj")
@EnableAutoConfiguration
@SpringBootApplication
@CrossOrigin
public class VehicleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleProjectApplication.class, args);
	}

}
