package com.api.agendamento.controller;

import com.api.agendamento.model.Agendamento;
import com.api.agendamento.model.Cliente;
import com.api.agendamento.model.Barber;
import com.api.agendamento.repository.AgendamentoRepository;
import com.api.agendamento.repository.ClienteRepository;
import com.api.agendamento.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BarberRepository barberRepository;
    
    @PostMapping
    public ResponseEntity<?> criarAgendamento(@RequestBody Agendamento agendamento) {
        // Verificar se o cliente existe
        Optional<Cliente> clienteOptional = clienteRepository.findById(agendamento.getCliente().getId());
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado."); // Retornar 400 se o cliente não for encontrado
        }

        // Verificar se o barbeiro existe
        Optional<Barber> barbeiroOptional = barberRepository.findById(agendamento.getBarbeiro().getId());
        if (!barbeiroOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Barbeiro não encontrado."); // Retornar 400 se o barbeiro não for encontrado
        }

        // Atribuir cliente e barbeiro ao agendamento
        agendamento.setCliente(clienteOptional.get());
        agendamento.setBarbeiro(barbeiroOptional.get());

        try {
            // Salvar o agendamento
            Agendamento novoAgendamento = agendamentoRepository.save(agendamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento); // Retornar o agendamento criado
        } catch (DataIntegrityViolationException e) {
            // Se ocorrer uma violação de integridade (duplicação de dia e horário)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: O agendamento para o dia " + agendamento.getDia() +
                            " e horário " + agendamento.getHorario() + " já existe.");
        }
    }

    
    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return ResponseEntity.ok(agendamentos);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()) {
            return ResponseEntity.ok(agendamentoOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 se o agendamento não for encontrado
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAgendamento(@PathVariable Long id) {
        // Verificar se o agendamento existe
        if (!agendamentoRepository.existsById(id)) {
            return ResponseEntity.status(404).body("Agendamento não encontrado.");
        }

        // Deletar o agendamento
        agendamentoRepository.deleteById(id);

        return ResponseEntity.status(200).body("Agendamento deletado com sucesso.");
    }
    
}
