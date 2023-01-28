package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



// I am Using Swagger UI for posting so to use this just Open chrome and type:  http://localhost:8085/swagger-ui/#/
// we can also post the method through POSTMAN. so for that We need to delete @EnableSwagger2.


@EnableSwagger2
@SpringBootApplication
public class SimpleOrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleOrderManagementSystemApplication.class, args);
	}

}
