package com.api.agendamento.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionTest implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Executa um simples SELECT para testar a conexão
            String result = jdbcTemplate.queryForObject("SELECT version();", String.class);
            System.out.println("Conexão com o banco de dados bem-sucedida!");
            System.out.println("Versão do PostgreSQL: " + result);
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }
}
