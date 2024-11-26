package com.api.agendamento.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_barbeiro", referencedColumnName = "id", nullable = false)
    private Barber barbeiro;

    @Column(nullable = false)
    private LocalDate dia;

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private String servico;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barber getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barber barbeiro) {
        this.barbeiro = barbeiro;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
