package com.example;

import com.example.service.EquipoService;
import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasketballApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BasketballApplication.class, args);
		context.getBean(EquipoService.class).testEquipo();
		context.getBean(JugadorService.class).testJugador();



	}
}
