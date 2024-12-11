package com.api.app.models;

import com.api.app.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

/**
 * Entidade que representa um pedido associado a um cliente.
 * Contém informações sobre descrição, valor, status e versão do registro.
 */
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private ClienteModel cliente;

    @Column(nullable = false)
    private String descricaoPedido;

    @Column(nullable = false)
    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PedidoStatus status;

    @Version
    private Long versao;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Long getVersao() {
        return versao;
    }

    public void setVersao(Long versao) {
        this.versao = versao;
    }
}
