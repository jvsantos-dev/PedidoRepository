package br.com.fiap3ESPV.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    @Column(nullable = false)
    private String clienteNome;

    @Column(nullable = false)
    private LocalDate dataPedido;

    @PositiveOrZero(message = "O valor total não pode ser negativo")
    @Column(nullable = false)
    private double valorTotal;

    @PrePersist
    public void prePersist() {
        this.dataPedido = LocalDate.now();
    }

    public Pedido() {}

    public Pedido(String clienteNome, double valorTotal) {
        this.clienteNome = clienteNome;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}