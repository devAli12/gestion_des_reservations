package com.example.gestion.des.reservations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Gestion des reservations REST API Documentation",
				description = " API Documentation for crud operations for reservation des salles",
				version = "v1",
				contact = @Contact(
						name = "chawali",
						email = "chawali@example.com",
						url = "https://www.site.com"
				)
		)
)
public class GestionDesReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesReservationsApplication.class, args);
	}

}
