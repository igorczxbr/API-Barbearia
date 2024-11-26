package com.api.agendamento.repository;

import com.api.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    // Não há necessidade de métodos adicionais para este exemplo
}
