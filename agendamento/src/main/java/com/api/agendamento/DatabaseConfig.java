package com.api.agendamento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/agendamento"); // Ajuste a URL conforme necessário
        dataSource.setUsername("postgres");                       // Substitua pelo seu usuário
        dataSource.setPassword("markim");                         // Substitua pela sua senha
        return dataSource;
    }
}
