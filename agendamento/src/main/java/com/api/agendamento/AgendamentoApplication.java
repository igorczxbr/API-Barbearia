package com.api.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendamentoApplication {

	public static void main(String[] args) {
		System.setProperty("server.port","3000");
		SpringApplication.run(AgendamentoApplication.class, args);
	}

}
