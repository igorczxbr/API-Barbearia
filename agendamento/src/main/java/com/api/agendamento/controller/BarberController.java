package com.api.agendamento.controller;

import com.api.agendamento.model.Barber;
import com.api.agendamento.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/barbeiros")
public class BarberController {

    @Autowired
    private BarberRepository barberRepository;

    // Listar todos os barbeiros
    @GetMapping
    public List<Barber> listarTodos() {
        return barberRepository.findAll();
    }

    // Buscar barbeiro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Barber> buscarPorId(@PathVariable Long id) {
        return barberRepository.findById(id)
                .map(barber -> ResponseEntity.ok().body(barber))
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar um novo barbeiro
    @PostMapping
    public Barber criar(@RequestBody Barber barber) {
        return barberRepository.save(barber);
    }

    // Atualizar um barbeiro existente
    @PutMapping("/{id}")
    public ResponseEntity<Barber> atualizar(@PathVariable Long id, @RequestBody Barber barberAtualizado) {
        return barberRepository.findById(id)
                .map(barber -> {
                    barber.setNome(barberAtualizado.getNome());
                    barber.setTelefone(barberAtualizado.getTelefone());
                    Barber atualizado = barberRepository.save(barber);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

 // Deletar um barbeiro
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return barberRepository.findById(id)
                .map(barber -> {
                    barberRepository.delete(barber);
                    return ResponseEntity.ok("Barbeiro com ID " + id + " foi deletado com sucesso.");
                })
                .orElse(ResponseEntity.status(404).body("Barbeiro com ID " + id + " não encontrado."));
    }

}
