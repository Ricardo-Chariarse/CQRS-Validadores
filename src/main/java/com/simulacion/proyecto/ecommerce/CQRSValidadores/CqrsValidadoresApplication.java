package com.simulacion.proyecto.ecommerce.CQRSValidadores;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;


@SpringBootApplication
public class CqrsValidadoresApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CqrsValidadoresApplication.class);
		app.setApplicationStartup(new BufferingApplicationStartup(2048));
		app.run(args);
	}


}
